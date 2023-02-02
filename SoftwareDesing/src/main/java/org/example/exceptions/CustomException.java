package org.example.exceptions;

public class CustomException extends Exception{
    private static final long serialVersionID = 700L;

    public CustomException(String message){
        super(message);
    }
}
