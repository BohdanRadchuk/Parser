package service.xml;

import entity.Person;
import entity.PersonBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaxParser extends DefaultHandler implements Parser {
    private List<Person> persons = new ArrayList<>();
    private String tmpValue;
    private Person person;

    @Override
    public List<Person> parse(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(filePath, this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
        if (elementName.equalsIgnoreCase(PERSON)) {
            person = new PersonBuilder().createPerson();
        }
    }

    @Override
    public void endElement(String s, String s1, String element) throws SAXException {
        if (element.equals(PERSON)) {
            persons.add(person);
        }
        if (element.equalsIgnoreCase(NAME)) {
            person.setName(tmpValue);
        }
        if (element.equalsIgnoreCase(ADDRESS)) {
            person.setAddress(tmpValue);
        }
        if (element.equalsIgnoreCase(CASH)) {
            person.setCash(new BigDecimal(tmpValue));
        }
    }

    @Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
}
