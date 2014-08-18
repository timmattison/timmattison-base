package PACKAGE_NAME;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MAIN_CLASS {
    public static void main(String args[]) {
        Injector injector = Guice.createInjector(new MAIN_CLASSModule());
    }

    /* COMMONS_CLI_START */
    /* Example command line processing with commons CLI */
    /*
    private static void processCommandLineOptions(String[] args) {
    	final String INPUT = "input";
    	final String OUTPUT = "output";
    	final String INPUT_FILE_NAME = "input file name";
    	final String OUTPUT_FILE_NAME = "output file name";

        // Create the Options object
        Options options = new Options();

        // Add input and output options
        options.addOption(INPUT, true, INPUT_FILE_NAME);
        options.addOption(OUTPUT, true, OUTPUT_FILE_NAME);

        CommandLineParser commandLineParser = new BasicParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

    	String inputFile = null;
    	String outputFile = null;

        inputFile = commandLine.getOptionValue(INPUT);
        outputFile = commandLine.getOptionValue(OUTPUT);

        if((inputFile == null) || (outputFile == null)) {
            showUsageInfo();
        }
    }

    private static void showUsageInfo() {
        System.err.println("You must specify an input file as the first argument and the output file as the second argument.");
        System.exit(1);
    }
    */
    /* COMMONS_CLI_END */

    /* EMBEDDED_JETTY_START */
    /* Example Jetty server */
    /*
    public void startServerAndBlock(Injector injector) {
        final String webXmlLocation = getWarUri(injector) + "/WEB-INF/web.xml";

        // Create an embedded Jetty server on port 8080
        Server server = new Server(8080);

        // Create a handler that works for our GWT code
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setResourceBase(getWarUri(injector));
        webAppContext.setDescriptor(webXmlLocation);
        webAppContext.setContextPath("/");
        webAppContext.setParentLoaderPriority(true);

        // Add Guice in via GuiceFilter
        webAppContext.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));

        // Set the handler
        server.setHandler(webAppContext);

        // And start it up
        try {
            server.start();
        } catch (BindException e) {
            String errorMessage = "The application is already running in another terminal.";

            System.out.println(errorMessage);
            System.err.println(errorMessage);

            System.exit(-1);
        }

        server.join();
    }
    */

    /**
     * Returns a URI that points inside the JAR so we can fetch resources from it (like the HTML)
     *
     * @param injector
     * @return
     */
    /*
    public static String getWarUri(Injector injector) {
        Class clazz = injector.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
        URL resource = classLoader.getResource("war");

        String resourceBase;

        // Did we find the resource?
        if (resource != null) {
            // Yes, we are inside of a JAR file
            String externalForm = resource.toExternalForm();
            resourceBase = externalForm;
        } else {
            // No, we are debugging
            resourceBase = "./war";
        }

        return resourceBase;
    }
    */
    /* EMBEDDED_JETTY_END */
}

