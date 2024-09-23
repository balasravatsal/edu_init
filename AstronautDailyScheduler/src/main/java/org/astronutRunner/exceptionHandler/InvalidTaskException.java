package org.astronutRunner.exceptionHandler;

public class InvalidTaskException extends Exception {
    // Constructor that accepts a message for the exception
    public InvalidTaskException(String message) {
        super(message);
    }
}
