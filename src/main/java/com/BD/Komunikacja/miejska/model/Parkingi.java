package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "PARKINGI")
public class Parkingi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Nazwa", nullable = false, length = 50)
    private String nazwa;
    @Column(name = "Adres", nullable = false, length = 100)
    private String adres;
}
