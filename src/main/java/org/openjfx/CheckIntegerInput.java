package org.openjfx;

public class CheckIntegerInput {


    //Sjekker input av tallverdier.

    public static int day(int day) throws InvalidDateException {

        if(day < 1 || day > 31){
            throw new InvalidDateException("Invalid date");
        }
        return day;
    }

    public static boolean dayBoolean(int day){
        return (day >= 1 && 31 >= day);
    }

    public static int month(int month) throws InvalidDateException {

        if(month < 1 || month > 12){
            throw new InvalidDateException("Invalid date");
        }
        return month;
    }

    public static boolean MonthBoolean(int month){
        return (month >= 1 && 12 >= month);
    }

    public static int year(int year) throws InvalidDateException {

        if(year < 1900 || year > 2020){
            throw new InvalidDateException("Invalid date");
        }
        return year;
    }

    public static boolean yearBoolean(int year){
        return (year >= 1900 && 2020 >= year);
    }
}
