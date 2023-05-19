package com.example.lab.service;

import com.example.lab.entity.ResultOfDivide;
import com.example.lab.jpa.FutureIdRepository;
import com.example.lab.jpa.model.FutureIdEntity;
import com.example.lab.jpa.model.ResultOfDivideEntity;
import com.example.lab.jpa.ResultOfDivideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class DataBaseService {

    @Autowired
    private ResultOfDivideRepository repository;

    @Autowired
    private FutureIdRepository futureIdRepository;


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

    public void saveFuture(ResultOfDivide resultOfDivide) {
        ResultOfDivideEntity entity = new ResultOfDivideEntity (resultOfDivide.getDividend(),resultOfDivide.getDivisor()
        ,resultOfDivide.getQuotient(),resultOfDivide.getRemainder());
        List<FutureIdEntity> futureIds = futureIdRepository.findAll();
        int max = futureIds.stream().mapToInt(FutureIdEntity::getId).max().getAsInt();
        entity.setFutureId(max);
        repository.save(entity);
    }

    public ResultOfDivideEntity findByFutureId(int id) {
        return repository.findByFutureId(id);
    }

    public void saveFutureId(FutureIdEntity id) {
        futureIdRepository.save(id);
    }
}

