import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;

public class XmlParser {
    public void parse (String filePath){
       
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new ByteArrayInputStream(body.getBytes()));

            NodeList nodeList = document.getElementsByTagName("Сотрудник");
            for(int x=0,size= nodeList.getLength(); x<size; x++) {
                System.out.println(nodeList.item(x).getAttributes().getNamedItem("Должность").getNodeValue())
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

}
