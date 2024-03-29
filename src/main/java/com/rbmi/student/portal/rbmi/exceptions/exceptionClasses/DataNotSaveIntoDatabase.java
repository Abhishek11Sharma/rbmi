package com.rbmi.student.portal.rbmi.exceptions.exceptionClasses;

public class DataNotSaveIntoDatabase extends RuntimeException {

    public DataNotSaveIntoDatabase() {
        super("Data did't save into database");
    }

    public DataNotSaveIntoDatabase(String message) {
        super(message);
    }
}