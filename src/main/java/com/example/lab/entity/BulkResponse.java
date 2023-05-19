package com.example.lab.entity;

import java.util.List;
import java.util.OptionalDouble;

public class BulkResponse {

    private List<Result> resultList;
    private Integer maxDividend;
    private Integer minDividend;
    private Double averageDividend;
    private Integer maxDivisor;
    private Integer minDivisor;
    private Double averageDivisor;

    public BulkResponse(List<Result> resultList, Integer maxDividend, Integer minDividend, Integer maxDivisor,
                        Integer minDivisor, Double averageDividend, Double averageDivisor) {
        this.resultList = resultList;
        this.maxDividend = maxDividend;
        this.minDividend = minDividend;
        this.maxDivisor = maxDivisor;
        this.minDivisor = minDivisor;
        this.averageDividend = averageDividend;
        this.averageDivisor = averageDivisor;
    }

    public BulkResponse() {
        this.resultList = null;
        this.maxDividend = 0;
        this.minDividend = 0;
        this.maxDivisor = 0;
        this.minDivisor = 0;
        this.averageDividend = Double.valueOf(0);
        this.averageDivisor = Double.valueOf(0);

    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public Integer getMaxDividend() {
        return maxDividend;
    }

    public void setMaxDividend(Integer maxDividend) {
        this.maxDividend = maxDividend;
    }

    public Integer getMinDividend() {
        return minDividend;
    }

    public void setMinDividend(Integer minDividend) {
        this.minDividend = minDividend;
    }

    public Integer getMaxDivisor() {
        return maxDivisor;
    }

    public void setMaxDivisor(Integer maxDivisor) {
        this.maxDivisor = maxDivisor;
    }

    public Integer getMinDivisor() {
        return minDivisor;
    }

    public void setMinDivisor(Integer minDivisor) {
        this.minDivisor = minDivisor;
    }

    public Double getAverageDividend() {
        return averageDividend;
    }

    public void setAverageDividend(Double averageDividend) {
        this.averageDividend = averageDividend;
    }

    public Double getAverageDivisor() {
        return averageDivisor;
    }

    public void setAverageDivisor(Double averageDivisor) {
        this.averageDivisor = averageDivisor;
    }
}
