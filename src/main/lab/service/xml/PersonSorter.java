package service.xml;

import entity.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PersonSorter {
    public List<Person> choosePersonsWithMoreCash(List<Person> persons, int cahs) {
        ArrayList<Person> reachPersons = new ArrayList<>();
        for (Person person : persons) {
            int comparingResult = person.getCash().compareTo(new BigDecimal(cahs));
            if (comparingResult == 1 || comparingResult == 0) {
                reachPersons.add(person);
            }
        }
        return reachPersons;
    }
}
