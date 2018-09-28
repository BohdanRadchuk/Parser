package entity;

import java.math.BigDecimal;

public class Person {

    private String name;
    private String address;
    private BigDecimal cash;
    private String education;

    public Person(String name, String address, BigDecimal cash, String education) {
        this.name = name;
        this.address = address;
        this.cash = cash;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public String getEducation() {
        return education;
    }
}
