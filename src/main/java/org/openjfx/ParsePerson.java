package org.openjfx;

public class ParsePerson {

    public static Person parsePerson(String str) throws InvalidPersonException {
        String[] strings = str.split(PersonFormater.DELIMITER);
        if(strings.length != 6) {
            throw new InvalidPersonException("DELIMITER Error");
        }

        String name = strings[0];
        String eMail = strings[1];
        String phoneNr = strings[2];
        int day, month, year;
        try {
            day = Integer.parseInt(strings[3]);
        } catch(NumberFormatException e) {
            throw new InvalidPersonException("Invalid day");
        }
        try {
            month = Integer.parseInt(strings[4]);
        } catch(NumberFormatException e) {
            throw new InvalidPersonException("Invalid month");
        }
        try {
            year = Integer.parseInt(strings[5]);
        } catch(NumberFormatException e) {
            throw new InvalidPersonException("Invalid year");
        }

        return new Person(name, eMail, phoneNr, day, month, year);
    }
}
