package service.xml;

import entity.Person;

import java.util.List;

public interface Parser {
    String PERSON = "person";
    String NAME = "name";
    String ADDRESS = "address";
    String CASH = "cash";

    List<Person> parse(String filePath);
}
