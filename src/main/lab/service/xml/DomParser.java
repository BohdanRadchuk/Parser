package service.xml;

import entity.Person;
import entity.PersonBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    @Override
    public List<Person> parse(String filePath) {
        File file = new File(filePath);
        ArrayList<Person> persons = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList listOfPersons = document.getElementsByTagName(PERSON);
            for (int s = 0; s < listOfPersons.getLength(); s++) {
                Node personNode = listOfPersons.item(s);
                if (personNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) personNode;
                    persons.add(getPersonFromElement(element));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private Person getPersonFromElement(Element element) {
        String name = getPersonFieldFromNode(element, NAME);
        String address = getPersonFieldFromNode(element, ADDRESS);
        BigDecimal cash = new BigDecimal(getPersonFieldFromNode(element, CASH));
        return new PersonBuilder().setName(name).setAddress(address).setCash(cash).createPerson();
    }

    private String getPersonFieldFromNode(Element personElement, String fieldToSearch) {
        Element firstNameElement = (Element) personElement.getElementsByTagName(fieldToSearch).item(0);
        NodeList nameList = firstNameElement.getChildNodes();
        return (nameList.item(0)).getNodeValue().trim();
    }
}
