package com.example.lab.service;
import org.springframework.stereotype.Service;
@Service
public class Counter {


    Integer syncCount = Integer.valueOf(0);
    Integer unSyncCount = Integer.valueOf(0);

    public synchronized void syncIncrement (){
        syncCount++;
    }
    public void unSyncIncrement() {
        unSyncCount++;
    }
    public Integer getSyncCount() {
        return syncCount;
    }

    public Integer getUnSyncCount() {
        return unSyncCount;
    }
}
