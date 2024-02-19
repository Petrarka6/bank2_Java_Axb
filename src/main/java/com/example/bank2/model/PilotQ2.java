package com.example.bank2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

private String Firstname, LastName;

}
