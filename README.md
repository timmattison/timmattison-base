Run:

`PACKAGE_NAME` is the name of the package that your main class exists in
`PROJECT_NAME` is the human readable name of your project
`MAIN_CLASS` is the name of your main class, not including the `PACKAGE_NAME`

```
./create-new-project.sh DESTINATION_DIRECTORY PACKAGE_NAME PROJECT_NAME MAIN_CLASS
```

```
rpl -R PACKAGE_NAME com.xxx.yyy.zzz
rpl -R PROJECT_NAME currentprojectname
mv PROJECT_NAME.iml currentprojectname.iml
```
