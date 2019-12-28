package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Dom4jUtils {
    public  static final String PATH="F:\\XML\\xml\\src\\xmla\\p1.xml";
    //返回document
    public static org.dom4j.Document getDocumment(String path){
        SAXReader saxReader=new SAXReader();
        try {
            Document document=saxReader.read(path);
            return  document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //回写xml
    public  static void  xmlWriters(String path,Document document){
        try {
            OutputFormat format=OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(path),format);
                  xmlWriter.write(document);
                  xmlWriter.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
