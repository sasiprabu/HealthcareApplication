package com.user.usermodule.usermoduleapi.exception;

public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = -9079452349611061074L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
