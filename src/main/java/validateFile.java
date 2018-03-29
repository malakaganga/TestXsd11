import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by malaka on 3/27/18.
 */
public class validateFile {
    private static void validateFile(File xmlFile, File xsdFile) throws SAXException, IOException {
        // 1. Lookup a factory for the W3C XML Schema language
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");

        // 2. Compile the schema.
        File schemaLocation = xsdFile;
        Schema schema = factory.newSchema(schemaLocation);

        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();

        // 4. Parse the document you want to check.
        Source source = new StreamSource(xmlFile);

        // 5. Check the document
        try {
            validator.validate(source);
            System.out.println(xmlFile.getName() + " is valid.");
        } catch (SAXException ex) {
            System.out.println(xmlFile.getName() + " is not valid because ");
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] a) throws IOException, SAXException {
        String schemaName = "/home/malaka/MyFolder/esb_patch_2/HMRC_XSD/XSD1.1-Example/LicenceTransfer.xsd";
        String xmlName = "/home/malaka/MyFolder/esb_patch_2/HMRC_XSD/XSD1.1-Example/licenseTransfer.xml";
        validateFile(new File(xmlName), new File(schemaName));

    }

}
