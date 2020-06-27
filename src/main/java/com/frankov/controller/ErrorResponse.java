package com.frankov.controller;

public class ErrorResponse implements Response {

    private String status;

    public ErrorResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
