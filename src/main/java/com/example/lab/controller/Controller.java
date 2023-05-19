package com.example.lab.controller;
import com.example.lab.entity.BulkParam;
import com.example.lab.entity.BulkResponse;
import com.example.lab.entity.ResultOfDivide;
import com.example.lab.memory.InMemoryStorage;
import com.example.lab.service.Counter;
import com.example.lab.service.DataBaseService;
import com.example.lab.validation.Validator;
import com.example.lab.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab.service.FindResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/lab")
public class Controller {
    private Logger logger = LogManager.getLogger(Controller.class);
    private FindResult service;
    private Validator validator;
    private InMemoryStorage inMemoryStorage;

    private Counter counter;

    private DataBaseService dataBaseService;
    @Autowired
    public Controller(FindResult service, Validator validator, InMemoryStorage inMemoryStorage, Counter counter,
                      DataBaseService dataBaseService){
        this.service = service;
        this.validator = validator;
        this.inMemoryStorage = inMemoryStorage;
        this.counter = counter;
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/divide")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> divide(@RequestParam String param1, @RequestParam String param2){

        counter.syncIncrement();
        counter.unSyncIncrement();

        Result result = new Result();
        logger.info("1.Validation");
        result.setErrors(validator.validateParameter(param1, param2));
        if (!result.getErrors().getErrormessage().isEmpty())
        {
            result.getErrors().setStatus("BAD_REQUEST");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        ResultOfDivide resultOfDivide;
        String id = param1+param2;
        int checkId = Integer.parseInt(id);
        int value1 = Integer.parseInt(param1);
        int value2 = Integer.parseInt(param2);
        try
        {

            logger.info("2.Service FindResult");
            if (dataBaseService.containsResponse(value1, value2)) {
                result.setResultOfDivide(dataBaseService.getResponse(value1, value2));
                result.getErrors().setStatus("OK");
            }
            else {
                resultOfDivide = service.div(value1, value2);
                result.setResultOfDivide(resultOfDivide);

                inMemoryStorage.addToMemoryStorage(checkId,resultOfDivide);
                dataBaseService.add(resultOfDivide);
                result.getErrors().setStatus("OK");
            }
        }
        catch (RuntimeException exc)
        {
            result.getErrors().setStatus("INTERNAL_SERVER_ERROR");
            result.getErrors().addErrormessage(exc.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BulkResponse> postDivide(@RequestBody List<BulkParam> paramList){


        List<Result> resultList = new ArrayList<>();

        paramList.forEach(bulkParam -> {
            Result result = new Result();
            ResultOfDivide resultOfDivide = new ResultOfDivide();
            result.setErrors(validator.validateParameter(bulkParam.getDividend(), bulkParam.getDivisor()));

            if (!result.getErrors().getErrormessage().isEmpty()) {
                result.getErrors().setStatus("BAD_REQUEST");
            }else {
                String id = bulkParam.getDividend() + bulkParam.getDivisor();
                int checkId = Integer.parseInt(id);
                int value1 = Integer.parseInt(bulkParam.getDividend());
                int value2 = Integer.parseInt(bulkParam.getDivisor());
                try {
                    if (dataBaseService.containsResponse(value1, value2)) {
                        result.setResultOfDivide(dataBaseService.getResponse(value1, value2));
                        result.getErrors().setStatus("OK");
                    }
                    else {

                        resultOfDivide = service.div(value1, value2);
                        result.setResultOfDivide(resultOfDivide);
                        result.getErrors().setStatus("OK");
                        inMemoryStorage.addToMemoryStorage(checkId,resultOfDivide);
                        dataBaseService.add(resultOfDivide);
                    }
                }
                catch (RuntimeException exc)
                {
                    result.getErrors().setStatus("INTERNAL_SERVER_ERROR");
                    result.getErrors().addErrormessage(exc.getMessage());
                }

            }

            resultList.add(result);

        });

        BulkResponse bulkResponse = new BulkResponse(resultList, service.maxDividend(paramList),
                service.minDividend(paramList),service.maxDivisor(paramList),
                service.minDivisor(paramList),service.averageDividend(paramList),service.averageDivisor(paramList));

        return new ResponseEntity<>(bulkResponse, HttpStatus.CREATED);
    }

    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findResultHistory()
    {
        return new ResponseEntity<>(inMemoryStorage.getMap(), HttpStatus.OK);
    }

    @GetMapping("/history/size")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findResultHistorySize()
    {
        return new ResponseEntity<>(inMemoryStorage.size(), HttpStatus.OK);
    }

    @GetMapping("/counter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Counter(){
        logger.info("Return result of Counter");
        return new ResponseEntity<>(counter, HttpStatus.OK);
    }

    @GetMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllResultsData(){
        return new ResponseEntity<>(dataBaseService.getData(), HttpStatus.OK);
    }
}
