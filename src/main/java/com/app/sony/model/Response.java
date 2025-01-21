package com.app.sony.model;

public class Response {
    private String token;
    private User user;

    public Response(String token, User user) {
        this.token = token;
        this.user = user;
    }

    // Getters and setters
}