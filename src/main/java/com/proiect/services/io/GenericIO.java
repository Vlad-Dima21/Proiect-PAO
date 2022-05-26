package com.proiect.services.io;

import java.util.List;

class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

public interface GenericIO<T> {
    List<T> getAllFromCSV() throws CustomException;
}

