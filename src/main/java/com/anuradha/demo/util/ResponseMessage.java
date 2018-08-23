package com.anuradha.demo.util;

public enum ResponseMessage {
    MISSING_REQUIRED_FIELD("Missing required field."),
    EMAIL_ALREADY_EXISTS("Email already exists."),
    INVALID_EMAIL_ADDRESS("Invalid email address."),
    EMAIL_NOT_EXISTS("Email address does not exists."),
    INCORRECT_PASSWORD("Incorrect password."),
    RECORD_DOES_NOT_EXISTS("Record does not exists."),
    UNAUTHORIZED_REQUEST("Unauthorized request."),
    SOMETHING_WENT_WRONG("Something went wrong."),
    REST_API_ERROR("Rest api exception"),
    SUCCESSFULLY_ADDED("Successfully added."),
    SUCCESSFULLY_DELETED("Successfully deleted."),
    SUCCESSFULLY_UPDATED("Successfully updated.");
    private String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
