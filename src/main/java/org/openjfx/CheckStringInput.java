package org.openjfx;

public class CheckStringInput {

    //Angir regexkode for navn.
    private final static String NAME_PATTERN = "[A-ZÆØÅ][-a-zæøå]*";
    //Angir regexkode for mail.
    //Regexkode hentet fra https://emailregex.com/
    private final static String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
            "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]" +
            "?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-" +
            "\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    //Angir regexkode for telefon.
    private final static String PHONENR_PATTERN = /*"[\\+]{1}?[0-9]{2}?*/"[0-9]{8}";


    public static String name(String name){
        if(name.matches(NAME_PATTERN)){
            return name;
        } else {
            throw new InvalidStringException("Invalid navn");
        }
    }
    public static String eMail(String eMail){
        if(eMail.matches(EMAIL_PATTERN)){
            return eMail;
        } else{
            throw new InvalidStringException("Invalid email");
        }
    }
    public static String phoneNr(String phoneNr){
        if(phoneNr.matches(PHONENR_PATTERN)){
            return phoneNr;
        } else {
            throw new InvalidStringException("Invalid phone number");
        }
    }
}
