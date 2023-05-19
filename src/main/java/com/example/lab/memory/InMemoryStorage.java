package com.example.lab.memory;

import com.example.lab.entity.ResultOfDivide;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class InMemoryStorage
{
    private Map<Integer,ResultOfDivide> map = new HashMap<Integer,ResultOfDivide>();

    public InMemoryStorage(Map<Integer,ResultOfDivide> map) {
        this.map = map;
    }

    public Map<Integer,ResultOfDivide> getMap() {
        return map;
    }

    public void setMap(Map<Integer,ResultOfDivide> map) {
        this.map = map;
    }

    public void addToMemoryStorage(int id, ResultOfDivide resultOfDivide) {
        map.put(id, resultOfDivide);
    }

    public ResultOfDivide getResultById(int id){
        ResultOfDivide resultOfDivide = map.get(id);
        return resultOfDivide;
    }
    public boolean containsResponse(int id){
        return map.containsKey(id);
    }
    public Integer size(){
        return (Integer)map.size();
    }
}
