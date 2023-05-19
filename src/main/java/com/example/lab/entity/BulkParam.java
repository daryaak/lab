package com.example.lab.entity;

public class BulkParam {

    private String dividend;
    private String divisor;


    public String getDividend() {
        return dividend;
    }

    public void setDividend(String dividend) {
        this.dividend = dividend;
    }

    public Integer getDividendToInt() {
        Integer div;
        if(dividend.matches("-?\\d+")) {
            div = Integer.parseInt(this.dividend);
        }else div = 0;
        return div;
    }

    public String getDivisor() {
        return divisor;
    }
    public Integer getDivisorToInt() {
        Integer div;
        if(divisor.matches("-?\\d+")) {
            div = Integer.parseInt(this.divisor);
        }else div = 0;
        return div;
    }

    public void setDivisor(String divisor) {
        this.divisor = divisor;
    }
}
