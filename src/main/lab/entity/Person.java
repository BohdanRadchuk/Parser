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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cash=" + cash +
                ", education='" + education + '\'' +
                '}';
    }
}
