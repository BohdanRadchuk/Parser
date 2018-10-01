import entity.Currency;
import entity.Person;
import entity.PersonBuilder;
import service.json.JsonParser;
import service.json.JsonToString;
import service.json.JsonWriter;
import service.xml.*;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    private static final String ALL_PEOPLE_FILE_PATH = "d:\\notebook.xml";
    private static final String REACH_PEOPLE_FILE_PATH = "d:\\reach_notebook.xml";
    private static final String JSON_FILE_PATH = "d:\\file1.txt";
    private static final String JSON_FILE_PATH_P = "d:\\file2.txt";
    private static final String BANK_JSON_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20180725&json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XmlWriter xmlWriter = new XmlWriter();
        PersonSorter personSorter = new PersonSorter();
        Set<String> requiredCurrencies = requiredCurrenciesGeneration();
        Parser parser;


        System.out.println("print \"y\" if you want to use DOM parser, otherwise SAX parser would be used");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            parser = new DomParser();
        } else {
            parser = new SaxParser();
        }

        xmlWriter.createXmlFile(createPersonsList(), ALL_PEOPLE_FILE_PATH);

        List<Person> persons = parser.parse(ALL_PEOPLE_FILE_PATH);

        persons = personSorter.choosePersonsWithMoreCash(persons, 10000);
        xmlWriter.createXmlFile(persons, REACH_PEOPLE_FILE_PATH);
        System.out.println(persons);

        JsonParser jsonParser = new JsonParser();
        JsonToString jsonToString = new JsonToString();

        List<Currency> courses = jsonParser.parseToCollection(jsonToString.readJsonFromURL(BANK_JSON_URL),
                requiredCurrencies);
        System.out.println("scanned from url " + courses);

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.writeJson(courses, JSON_FILE_PATH);
        List<Currency> fileCourses = jsonParser.parseToCollection(jsonToString.readJsonFromFile(JSON_FILE_PATH),
                requiredCurrencies);

        jsonWriter.writeJson(fileCourses, JSON_FILE_PATH_P);
        System.out.println("scanned from file " + fileCourses);
    }

    private static Set<String> requiredCurrenciesGeneration(){
        Set<String> requiredCurrencies =new HashSet<>();
        requiredCurrencies.add("USD");
        requiredCurrencies.add("EUR");
        requiredCurrencies.add("RUB");
        return requiredCurrencies;
    }

    private static ArrayList<Person> createPersonsList() {
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
