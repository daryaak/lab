package com.example.lab.entity;

import com.example.lab.jpa.model.FutureIdEntity;

public class FutureResponse {
    private FutureIdEntity futureId;
    private String message;

    public FutureResponse() {
        futureId = null;
        message = null;
    }

    public FutureResponse(FutureIdEntity id, String message) {
        this.futureId = id;
        this.message = message;
    }

    public void setFutureId(FutureIdEntity id) {
        this.futureId=id;
    }

    public FutureIdEntity getFutureId() {
        return futureId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}