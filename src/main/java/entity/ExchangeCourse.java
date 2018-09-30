package entity;

import java.util.Objects;

public class ExchangeCourse {
    private String r030;
    private String txt;
    private String rate;
    private String cc;
    private String exchangedate;


    public ExchangeCourse() {
    }

    public ExchangeCourse(String r030, String txt, String rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public String getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public String getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeCourse that = (ExchangeCourse) o;
        return Objects.equals(r030, that.r030) &&
                Objects.equals(txt, that.txt) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(cc, that.cc) &&
                Objects.equals(exchangedate, that.exchangedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(r030, txt, rate, cc, exchangedate);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "r030='" + r030 + '\'' +
                ", txt='" + txt + '\'' +
                ", rate='" + rate + '\'' +
                ", cc='" + cc + '\'' +
                ", exchangedate='" + exchangedate + '\'' +
                '}';
    }
}