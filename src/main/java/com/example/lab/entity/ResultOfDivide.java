package com.example.lab.entity;

import com.example.lab.jpa.model.ResultOfDivideEntity;

import java.util.Objects;

public class ResultOfDivide {

    private int dividend;
    private int divisor;
    private int remainder;
    private int quotient;

    public ResultOfDivide() {
        this.dividend = 0;
        this.divisor = 0;
        this.remainder = 0;
        this.quotient = 0;
    }

    public ResultOfDivide( int dividend, int divisor, int remainder, int quotient) {

        this.dividend = dividend;
        this.divisor = divisor;
        this.remainder = remainder;
        this.quotient = quotient;
    }

    public ResultOfDivide(ResultOfDivideEntity resultOfDivideEntity) {
        this.dividend = resultOfDivideEntity.getDividend();
        this.divisor = resultOfDivideEntity.getDivisor();
        this.quotient = resultOfDivideEntity.getQuotient();
        this.remainder = resultOfDivideEntity.getRemainder();
    }

    public int getRemainder(){
        return remainder; }
    public int getQuotient() {
        return quotient;
    }
    public int getDividend() {
        return dividend;
    }
    public int getDivisor() {
        return divisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultOfDivide that = (ResultOfDivide) o;
        return  dividend == that.dividend && divisor == that.divisor && remainder == that.remainder && quotient == that.quotient;
    }

    @Override
    public int hashCode() {
        return Objects.hash( dividend, divisor, remainder, quotient);
    }

}
