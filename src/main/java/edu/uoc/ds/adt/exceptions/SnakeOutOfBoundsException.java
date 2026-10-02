package edu.uoc.ds.adt.exceptions;

public class SnakeOutOfBoundsException extends Exception {
    public static final String ERROR_OUT_OF_BOUNDS = "[ERROR] Snake is out of bounds!!";

    public SnakeOutOfBoundsException(String msg) {
        super(msg);
    }
}
