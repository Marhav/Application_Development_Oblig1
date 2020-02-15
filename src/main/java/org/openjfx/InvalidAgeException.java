package org.openjfx;

public class InvalidAgeException extends IllegalArgumentException {

    public InvalidAgeException(String meldig){
        super(meldig);
    }
}
