package com.gai_app.gai_notifications.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String description) {
        super(description);
    }
}
