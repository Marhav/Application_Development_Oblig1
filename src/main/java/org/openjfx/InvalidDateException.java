package org.openjfx;

public class InvalidDateException extends IllegalArgumentException {

    public InvalidDateException(String meldig){
        super(meldig);
    }
}

