package lab.xmlTest;

import entity.Person;
import entity.PersonBuilder;
import org.junit.Before;
import org.junit.Test;
import service.xml.DomParser;
import service.xml.Parser;
import service.xml.XmlWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DomParserTest {
    private static final String FILE_URL = "src/test/testdata.xml";
    private Parser parser = new DomParser();
    private ArrayList<Person> persons = new ArrayList<>();

    @Before
    public void initFile(){


        persons.add(new PersonBuilder().setName("John1")
                .setAddress("glib str 1")
                .setCash(new BigDecimal(100000))
                .setEducation("National University 1")
                .createPerson());
        persons.add(new PersonBuilder()
                .setName("John2")
                .setAddress("harkisvska str 2")
                .setCash(new BigDecimal(2000))
                .setEducation("National University 2")
                .createPerson());
        persons.add(new PersonBuilder()
                .setName("John3")
                .setAddress("harka str 3")
                .setCash(new BigDecimal(9999))
                .setEducation("National University 3")
                .createPerson());
        persons.add(new PersonBuilder()
                .setName("John4")
                .setAddress("Jonkd str 4")
                .setCash(new BigDecimal(10000))
                .setEducation("National University 4")
                .createPerson());
        XmlWriter writer = new XmlWriter();
        writer.createXmlFile(persons, FILE_URL);
    }


    @Test
    public void checkReadFromFileListSize() {
        List<Person> parsedData = parser.parse(FILE_URL);
        assertEquals(persons.size(), parsedData.size());
    }

    @Test
    public void checkReadFromFileListFields() {
        List<Person> parsedData = parser.parse(FILE_URL);
        assertEquals(persons.size(), parsedData.size());
        for (int i = 0; i < persons.size(); i++) {
            assertEquals(persons.get(i).getName(), parsedData.get(i).getName());
            assertEquals(persons.get(i).getAddress(), parsedData.get(i).getAddress());
            assertEquals(persons.get(i).getCash(), parsedData.get(i).getCash());
        }
    }
}
