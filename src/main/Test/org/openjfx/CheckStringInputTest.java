package org.openjfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckStringInputTest {
    @Test
    void name() {
        CheckStringInput.name("Marius Havnaas");
        CheckStringInput.name("Marius Aleksander Østenby Havnaas");
        CheckStringInput.name("Anne-Marte Moberg");
        CheckStringInput.name("Ærling-Åse Østen");


        assertThrows(InvalidStringException.class, () -> CheckStringInput.name("Marius%¤/"));
    }

    @Test
    void eMail() {
    }

    @org.junit.jupiter.api.Test
    void phoneNr() {
        CheckStringInput.phoneNr("12233212");
        CheckStringInput.phoneNr("+4712233212");
        CheckStringInput.phoneNr("+47 12233212");
        CheckStringInput.phoneNr("(+47)12233212");
        CheckStringInput.phoneNr("(+47) 12233212");
        CheckStringInput.phoneNr("(+47) 12 23 32 12");
        CheckStringInput.phoneNr("07911 123456");
        CheckStringInput.phoneNr("+44 7911 123456");
        CheckStringInput.phoneNr("754-3010");
        CheckStringInput.phoneNr("(541) 754-3010");
        CheckStringInput.phoneNr("+1-541-754-3010");
        CheckStringInput.phoneNr("1-541-754-3010");
        CheckStringInput.phoneNr("001-541-754-3010");

        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr(""));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("Not a number"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("-231"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("123-norway"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("1-541-æøå-3010"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("1-541-abc-3010"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("!%&/"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("123 123     123 12"));
    }

    /*@org.junit.jupiter.api.Test
    void navn() {
        CheckStringInput.name("Marius");


        assertThrows(InvalidStringException.class, () -> CheckStringInput.name("Marius%¤/"));
    }

    @org.junit.jupiter.api.Test
    void eMail() {
        CheckStringInput.eMail("abc@abc.abc");
        CheckStringInput.eMail("abc@abc.ab.bc");

        assertThrows(InvalidStringException.class, () -> CheckStringInput.eMail("@abc.no"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.eMail("abc@.no"));
    }

    @org.junit.jupiter.api.Test
    void phoneNr() {
        CheckStringInput.phoneNr("12233212");
        CheckStringInput.phoneNr("+4712233212");
        //CheckStringInput.phoneNr("+47 12233212");
        CheckStringInput.phoneNr("(+47)12233212");
        CheckStringInput.phoneNr("(+47) 12233212");
        CheckStringInput.phoneNr("(+47) 12 23 32 12");
        CheckStringInput.phoneNr("07911 123456");
        CheckStringInput.phoneNr("+44 7911 123456");
        CheckStringInput.phoneNr("754-3010");
        CheckStringInput.phoneNr("(541) 754-3010");
        CheckStringInput.phoneNr("+1-541-754-3010");
        CheckStringInput.phoneNr("1-541-754-3010");
        CheckStringInput.phoneNr("001-541-754-3010");

        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr(""));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("Not a number"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("-231"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("123-norway"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("1-541-æøå-3010"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("1-541-abc-3010"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("!%&/"));
        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("123 123     123 12"));*/
    }
