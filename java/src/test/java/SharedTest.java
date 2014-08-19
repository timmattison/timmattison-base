package PACKAGE_NAME;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;

public class SharedTest {

   /**
    * Reads a file as a string from the test-files directory.  Can be used inside a JAR.
    * 
    * @param inputFile
    * @return
    * @throws IOException
    */
    private static String readFileAsString(String inputFile) throws IOException {
        return IOUtils.toString(new InputStreamReader(inputFile.getClass().getResourceAsStream(inputFile)));
    }

    /* MULTIBINDER_EXAMPLE_START */
    /* Example of getting a multibinder for a test */
    /*
    private static void getMultibinder(Injector injector) {
        TypeLiteral<Set<YourInterface>> yourInterfaceTypeLiteral = new TypeLiteral<Set<YourInterface>>() {
        };

        // Get the multibinding from Guice for Set<YourInterface>
        return injector.getInstance(Key.get(yourInterfaceTypeLiteral));
    }
    */
    /* MULTIBINDER_EXAMPLE_END */
}
