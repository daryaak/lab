package com.example.lab.jpa;

import com.example.lab.jpa.model.FutureIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FutureIdRepository extends JpaRepository<FutureIdEntity, Integer> {

}