package org.openjfx;

import static org.junit.jupiter.api.Assertions.*;

class CheckStringInputTest {

    @org.junit.jupiter.api.Test
    void navn() {
        CheckStringInput.name("Marius");


        assertThrows(InvalidStringException.class, () -> CheckStringInput.name("Marius%¤/"));
    }

    @org.junit.jupiter.api.Test
    void ePost() {
        CheckStringInput.eMail("abc@abc.abc");

        assertThrows(InvalidStringException.class, () -> CheckStringInput.eMail("@abc.no"));
    }

    @org.junit.jupiter.api.Test
    void telefonNr() {
        CheckStringInput.phoneNr("12121212");

        assertThrows(InvalidStringException.class, () -> CheckStringInput.phoneNr("345dv234"));
    }
}