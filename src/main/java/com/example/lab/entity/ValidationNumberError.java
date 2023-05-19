package com.example.lab.entity;

import java.util.ArrayList;
import java.util.List;

public class ValidationNumberError {
    private final List<String> errorMessages = new ArrayList<String>();
    private String status;

    public List<String> getErrormessage(){
        return errorMessages;
    }

    public void addErrormessage(String errormessage){
        this.errorMessages.add(errormessage);
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }
}
