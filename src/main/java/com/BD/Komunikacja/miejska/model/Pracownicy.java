package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "PRACOWNICY")
public class Pracownicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Imie", nullable = false, length = 20)
    private String imie;
    @Column(name = "Nazwisko", nullable = false, length = 30)
    private String nazwisko;
    @Column(name = "Wynagrodzenie", nullable = false)
    private int wynagrodzenie;
    @Column(name = "ID_STANOWISKA", nullable = false)
    private int id_stanowiska;
    @Column(name = "ID_CENTRALA_KOMUNIKACJI_MIEJSKIEJ", nullable = false)
    private int id_centrala_komunikacji_miejskiej;
}
