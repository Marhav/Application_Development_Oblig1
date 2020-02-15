package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty name, eMail, phoneNr;
    private SimpleIntegerProperty day, month, year;

    public Person(String name, String eMail, String phoneNr, int day, int month, int year){
        this.name = new SimpleStringProperty(name);
        this.eMail = new SimpleStringProperty(eMail);
        this.phoneNr = new SimpleStringProperty(phoneNr);
        this.day = new SimpleIntegerProperty(day);
        this.month = new SimpleIntegerProperty(month);
        this.year = new SimpleIntegerProperty(year);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEMail() {
        return eMail.getValue();
    }

    public void seteMail(String eMail) {
        this.eMail.set(eMail);
    }

    public String getPhoneNr() {
        return phoneNr.getValue();
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr.set(phoneNr);
    }

    public int getDay() {
        return day.getValue();
    }

    public void setDay(int day) {
        this.day.set(day);
    }

    public int getMonth() {
        return month.getValue();
    }

    public void setMonth(int month) {
        this.month.set(month);
    }

    public int getYear() {
        return year.getValue();
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String toString(){
        return String.format("Name: %s; Phone: %s; Email: %s; Day: %s; Month: %s; Year: %s;",
                name, phoneNr, eMail, day, month, year);
    }

}
