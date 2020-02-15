package org.openjfx;

import java.io.IOException;

public class InvalidPersonException extends IOException {

    public InvalidPersonException(String msg){

        super(msg);
    }
}
