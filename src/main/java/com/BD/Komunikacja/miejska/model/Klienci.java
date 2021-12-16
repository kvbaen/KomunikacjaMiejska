package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "KLIENCI")
public class Klienci {
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Imie", nullable = false, length = 20)
    private String imie;
    @Column(name = "Nazwisko", nullable = false, length = 40)
    private String nazwisko;
    @Column(name = "ID_E_KARTY", nullable = false)
    private int id_e_karty;
    @Column(name = "ID_CENTRALI", nullable = false)
    private int id_centrali;
}
