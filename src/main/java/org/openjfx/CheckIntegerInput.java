package org.openjfx;

public class CheckIntegerInput {


    //Sjekker input av tallverdier.
    public static int age(int age) throws InvalidAgeException {

        if(age < 0 || age > 120){
            throw new InvalidAgeException("Age is either too low or too high");
        }
        return age;
    }

    public static int day(int day) throws InvalidDateException {

        if(day < 1 || day > 31){
            throw new InvalidDateException("Invalid date");
        }
        return day;
    }

    public static int month(int month) throws InvalidDateException {

        if(month < 1 || month > 12){
            throw new InvalidDateException("Invalid date");
        }
        return month;
    }

    public static int year(int year) throws InvalidDateException {

        if(year < 1900 || year > 2020){
            throw new InvalidDateException("Invalid date");
        }
        return year;
    }
}
