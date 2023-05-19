package com.example.lab.jpa;

import jakarta.annotation.Nullable;
import com.example.lab.jpa.model.ResultOfDivideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultOfDivideRepository extends JpaRepository<ResultOfDivideEntity, Long> {
    @Nullable
    ResultOfDivideEntity findByDividendAndDivisor(int dividend, int divisor);
}