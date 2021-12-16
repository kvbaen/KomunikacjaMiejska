package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "WYPOZYCZENIA")
public class Wypozyczenia {
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "ID_PRACOWNIKA", nullable = false)
    private int id_pracownika;
    @Column(name = "ID_AUTOBUSU", nullable = false)
    private int id_autobusu;
    @Column(name = "ID_LINII", nullable = false)
    private int id_linii;

}
