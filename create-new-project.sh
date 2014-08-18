#!/usr/bin/env bash

# `PACKAGE_NAME` is the name of the package that your main class exists in
# `PROJECT_NAME` is the human readable name of your project
# `MAIN_CLASS` is the name of your main class, not including the `PACKAGE_NAME`

DESTINATION_DIRECTORY=$1
PACKAGE_NAME=$2
PROJECT_NAME=$3
MAIN_CLASS=$4
EXTRA_JUNK=$5

function exit_if_variable_is_not_set {
	[ -z $2 ] && echo "$1 is not set.  Exiting!" && exit $3
}

# Make sure all of the variables we need are set
exit_if_variable_is_not_set "Destination directory" "$DESTINATION_DIRECTORY" 1
exit_if_variable_is_not_set "Package name" "$PACKAGE_NAME" 2
exit_if_variable_is_not_set "Project name" "$PROJECT_NAME" 3
exit_if_variable_is_not_set "Main class" "$MAIN_CLASS" 4

# Make sure that there aren't any extra variables
	[ ! -z $EXTRA_JUNK ] && echo "There are extra parameters.  Does your pathname or project name have a space in it?  If so, put the pathname in double-quotes and try again.  Package name, project name, and main class CANNOT have spaces in them.  Exiting!" && exit 5

# Change the destination directory if it does not begin with a slash or a tilde
if [[ ! $DESTINATION_DIRECTORY == ~* ]] && [[ ! $DESTINATION_DIRECTORY == /* ]];
then
	DESTINATION_DIRECTORY="$HOME/$DESTINATION_DIRECTORY"
fi

# Make sure the destination directory does not exist
if [ -d "$DESTINATION_DIRECTORY" ];
then
	echo "$DESTINATION_DIRECTORY already exists.  Cowardly refusing to overwrite it."
	exit 6
fi

# We know the destination does not exist.  Is it in the same directory that the base project is?
[[ $DESTINATION_DIRECTORY == `pwd`* ]] && echo "$DESTINATION_DIRECTORY is inside of the timmattison-base directory.  Cowardly refusing to create a project inside of itself.  Please specify an absolute path to a new directory." && exit 6

echo $DESTINATION_DIRECTORY

# Copy the current structure to the new directory
cp -R . $DESTINATION_DIRECTORY

# Replace all of the important stuff with the values they specified
pushd .
cd $DESTINATION_DIRECTORY
rpl -R PACKAGE_NAME $PACKAGE_NAME .
rpl -R PROJECT_NAME $PROJECT_NAME .
rpl -R MAIN_CLASS $MAIN_CLASS .
PACKAGE_DIRECTORY=`echo "$PACKAGE_NAME" | sed "s/\./\//g"`
TEST_PACKAGE_DIRECTORY=$PACKAGE_DIRECTORY
PACKAGE_DIRECTORY="java/src/main/java/$PACKAGE_DIRECTORY"
TEST_PACKAGE_DIRECTORY="java/src/test/java/$TEST_PACKAGE_DIRECTORY"
mkdir -p $PACKAGE_DIRECTORY
mkdir -p $TEST_PACKAGE_DIRECTORY
mv java/src/main/java/MAIN_CLASS.java $PACKAGE_DIRECTORY/$MAIN_CLASS.java
mv java/src/main/java/MAIN_CLASSModule.java $PACKAGE_DIRECTORY/${MAIN_CLASS}Module.java
mv java/src/test/java/SharedTest.java $TEST_PACKAGE_DIRECTORY/SharedTest.java
mv java/PROJECT_NAME.iml java/$PROJECT_NAME.iml
echo "Put README info here" > README.md
rm create-new-project.sh
rm -rf .git
popd
