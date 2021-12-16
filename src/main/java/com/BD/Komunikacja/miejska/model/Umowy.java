package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "UMOWY")
public class Umowy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Rodzaj_umowy", nullable = false, length = 20)
    private String rodzajUmowy;
    @Column(name = "Okres", nullable = false)
    private int okres;
    @Column(name = "Data_zawarcia", nullable = false)
    private Date dataZawarcia;
    @Column(name = "Data_rozwiązania", nullable = false)
    private Date dataRozwiązania;
    @Column(name = "ID_PRACOWNIKA", nullable = false)
    private int id_pracownika;
}
