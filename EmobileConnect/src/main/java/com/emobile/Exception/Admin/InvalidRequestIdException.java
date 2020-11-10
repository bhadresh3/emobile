package com.emobile.Exception.Admin;

public class InvalidRequestIdException extends RuntimeException {
    public InvalidRequestIdException(String request_id_is_invalid) {
        super(request_id_is_invalid);
    }
}
