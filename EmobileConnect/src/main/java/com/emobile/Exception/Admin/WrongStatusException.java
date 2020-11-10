package com.emobile.Exception.Admin;

public class WrongStatusException extends RuntimeException {
    public WrongStatusException(String request_status_is_not_valid) {
        super(request_status_is_not_valid);
    }
}
