package com.example.lab.entity;

import com.example.lab.jpa.model.FutureIdEntity;

public class FutureResponse {
    private FutureIdEntity id;
    private String message;

    public FutureResponse() {
        id = null;
        message = null;
    }

    public FutureResponse(FutureIdEntity id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setFutureId(FutureIdEntity id) {
        this.id=id;
    }

    public FutureIdEntity getFutureId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}