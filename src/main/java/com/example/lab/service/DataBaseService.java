package com.example.lab.service;

import com.example.lab.entity.ResultOfDivide;
import com.example.lab.jpa.model.ResultOfDivideEntity;
import com.example.lab.jpa.ResultOfDivideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataBaseService {

    @Autowired
    private ResultOfDivideRepository repository;

    public void add(ResultOfDivide resultOfDivide) {
        ResultOfDivideEntity entity = new ResultOfDivideEntity(resultOfDivide);
        repository.save(entity);
    }

    public List<ResultOfDivideEntity> getData() {
        return repository.findAll();
    }

    public boolean containsResponse(int dividend, int divisor) {
        return getResponse(dividend, divisor) != null;
    }

    public ResultOfDivide getResponse(int dividend, int divisor)
    {
        ResultOfDivideEntity entity = repository.findByDividendAndDivisor(dividend, divisor);
        if (entity != null)
            return new ResultOfDivide(entity);

        return null;
    }
}

