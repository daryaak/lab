package com.example.lab.entity;

public class Result {
    private ValidationNumberError errors;
    private ResultOfDivide resultOfDivide;
    public Result() {
        this.errors = new ValidationNumberError();
        this.resultOfDivide = new ResultOfDivide(0,0,0,0);
    }

    public Result(ValidationNumberError errors, ResultOfDivide resultOfDivide) {
        this.errors = errors;
        this.resultOfDivide = resultOfDivide;
    }

    public ValidationNumberError getErrors() {
        return errors;
    }

    public void setErrors(ValidationNumberError errors) {
        this.errors = errors;
    }

    public ResultOfDivide getResultOfDivide() {
        return resultOfDivide;
    }

    public void setResultOfDivide(ResultOfDivide result) {
        this.resultOfDivide = result;
    }

}
