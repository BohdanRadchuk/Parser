import entity.ExchangeCourse;
import service.json.JsonParser;
import service.json.JsonToString;
import service.xml.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ALL_PEOPLE_FILE_PATH = "d:\\notebook.xml";
    private static final String REACH_PEOPLE_FILE_PATH = "d:\\reach_notebook.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XmlWriter xmlWriter = new XmlWriter();
        PersonSorter personSorter = new PersonSorter();
     /*   Parser parser;
        System.out.println("print \"y\" if you want to use DOM parser, otherwise SAX parser would be used");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            parser = new DomParser();
        } else {
            parser = new SaxParser();
        }

        xmlWriter.createXmlFile(xmlWriter.createPersonsList(), ALL_PEOPLE_FILE_PATH);

        List<Person> persons = parser.parse(ALL_PEOPLE_FILE_PATH);

        persons = personSorter.choosePersonsWithMoreCash(persons, 10000);
        xmlWriter.createXmlFile(persons, REACH_PEOPLE_FILE_PATH);
        System.out.println(persons);*/

        JsonParser jsonParser = new JsonParser();
        JsonToString jsonToString = new JsonToString();
        List<ExchangeCourse> courses = jsonParser.parseToCollection(jsonToString.readStringFromJson(
                "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20180725&json"));
        System.out.println(courses);
    }
}
