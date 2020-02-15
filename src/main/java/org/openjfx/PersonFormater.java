package org.openjfx;

import java.util.List;

public class PersonFormater {
    public static String DELIMITER = ";";

    public static String formatPerson(Person p){
        return p.getName() + DELIMITER  + p.getEMail() + DELIMITER + p.getPhoneNr() + DELIMITER + p.getDay()+ DELIMITER +p.getMonth()+ DELIMITER +p.getYear();
    }

    public static String formatPeople(List<Person> people){
        StringBuilder str = new StringBuilder();
        for(Person p : people){
            str.append(formatPerson(p));
            str.append("\n");
        }
        return str.toString();
    }

}
