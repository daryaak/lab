package com.example.lab.jpa;

import com.example.lab.jpa.model.FutureIdEntity;
import com.example.lab.jpa.model.ResultOfDivideEntity;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FutureIdRepository extends JpaRepository<FutureIdEntity, Integer> {

}