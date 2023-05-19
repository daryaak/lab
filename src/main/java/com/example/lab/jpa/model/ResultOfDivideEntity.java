package com.example.lab.jpa.model;

import com.example.lab.entity.ResultOfDivide;
import jakarta.persistence.*;

@Entity
@Table(name = "divide", schema = "javalab")
public class ResultOfDivideEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "future_id")
    private int futureId;
    @Column(name = "dividend")
    private int dividend;
    @Column(name = "divisor")
    private int divisor;
    @Column(name = "quotient")
    private int quotient;
    @Column(name = "remainder")
    private int remainder;

    public ResultOfDivideEntity( int dividend, int divisor, int quotient, int remainder) {
        this.futureId = 0;
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public ResultOfDivideEntity() {
        this.id = (long)0;
        this.futureId = 0;
        this.dividend = 0;
        this.divisor = 0;
        this.quotient = 0;
        this.remainder = 0;
    }

    public ResultOfDivideEntity(ResultOfDivide resultOfDivide) {
        this.futureId = 0;
        this.dividend = resultOfDivide.getDividend();
        this.divisor = resultOfDivide.getDivisor();
        this.quotient = resultOfDivide.getQuotient();
        this.remainder = resultOfDivide.getRemainder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }


    public int getFutureId() {
        return futureId;
    }

    public void setFutureId(int future_id) {
        this.futureId = future_id;
    }
}

