package com.example.lab.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="future", schema = "javalab")
public class FutureIdEntity {
    @Id
    @Column(name = "futureId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public void setId(Integer id) {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }
}