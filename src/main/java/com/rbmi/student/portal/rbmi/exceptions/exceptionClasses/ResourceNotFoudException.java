package com.rbmi.student.portal.rbmi.exceptions.exceptionClasses;

public class ResourceNotFoudException extends RuntimeException {

    public ResourceNotFoudException() {
        super("No resource is available");
    }

    public ResourceNotFoudException(String msg) {
        super(msg);
    }
}