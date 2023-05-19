package com.example.lab.service;

import com.example.lab.entity.BulkParam;
import com.example.lab.entity.Result;
import com.example.lab.entity.ResultOfDivide;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class FindResult {

    public int findRemainder(int first, int second)
    {
        return first%second;
    }
    public int findQuotient(int first, int second)
    {
        return first/second;
    }
    public ResultOfDivide div(int first, int second)
    {
        int remainder=findRemainder(first, second);

        int quotient=findQuotient(first,second);

        if (remainder==13) throw new RuntimeException("13 - значение запрещенное");
        return new ResultOfDivide( first, second, remainder, quotient);
    }

    public Integer maxDividend(List<BulkParam> paramList){
        return paramList.stream().mapToInt(BulkParam::getDividendToInt).max().getAsInt();
    }
    public Integer minDividend(List<BulkParam> paramList){
        return paramList.stream().mapToInt(BulkParam::getDividendToInt).min().getAsInt();
    }
    public Double averageDividend(List<BulkParam> paramList){
        return paramList.stream().mapToInt(BulkParam::getDividendToInt).average().getAsDouble();
    }
    public Integer maxDivisor(List<BulkParam> paramList){
        return paramList.stream().mapToInt(BulkParam::getDivisorToInt).max().getAsInt();
    }
    public Integer minDivisor(List<BulkParam> paramList){
        return paramList.stream().mapToInt(BulkParam::getDivisorToInt).min().getAsInt();
    }
    public Double averageDivisor(List<BulkParam> paramList){
        return paramList.stream().mapToInt(BulkParam::getDivisorToInt).average().getAsDouble();
    }
}
