package service.xml;

import entity.Person;
import entity.PersonBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter {
    private static final String CATALOG = "catalog";
    private static final String NOTEBOOK = "notebook";
    private static final String PERSON = "person";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String CASH = "cash";
    private static final String EDUCATION = "education";

    public void createXmlFile(List<Person> personList, String fileName) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement(CATALOG);
            doc.appendChild(rootElement);
            Element notebook = doc.createElement(NOTEBOOK);
            rootElement.appendChild(notebook);

            for (int i = 0; i < personList.size(); i++) {
                Element person = doc.createElement(PERSON);
                notebook.appendChild(person);
                person.setAttribute(ID, String.valueOf(i + 1));

                Element name = doc.createElement(NAME);
                name.appendChild(doc.createTextNode(personList.get(i).getName()));
                person.appendChild(name);
                Element address = doc.createElement(ADDRESS);
                address.appendChild(doc.createTextNode(personList.get(i).getAddress()));
                person.appendChild(address);
                Element cash = doc.createElement(CASH);
                cash.appendChild(doc.createTextNode(String.valueOf(personList.get(i).getCash())));
                person.appendChild(cash);
                if (personList.get(i).getEducation() != null) {
                    Element education = doc.createElement(EDUCATION);
                    education.appendChild(doc.createTextNode(personList.get(i).getEducation()));
                    person.appendChild(education);
                }
            }
            writeToFile(doc, fileName);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(Document doc, String fileName) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);
    }

    public ArrayList<Person> createPersonsList() {
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new PersonBuilder().setName("John")
                .setAddress("glib str 29")
                .setCash(new BigDecimal(100000))
                .setEducation("National University")
                .createPerson());
        persons.add(new PersonBuilder()
                .setName("AAaa")
                .setAddress("harkisvska str 22")
                .setCash(new BigDecimal(2000))
                .setEducation("National Academy")
                .createPerson());
        persons.add(new PersonBuilder()
                .setName("AAasdadsaa")
                .setAddress("harka str 22")
                .setCash(new BigDecimal(20000))
                .setEducation("National GFD Academy")
                .createPerson());
        persons.add(new PersonBuilder()
                .setName("Dgasdas")
                .setAddress("Jonkd str 22")
                .setCash(new BigDecimal(10000))
                .setEducation("National Asd Academy")
                .createPerson());
        return persons;
    }


}
