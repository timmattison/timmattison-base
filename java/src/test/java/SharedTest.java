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
}
