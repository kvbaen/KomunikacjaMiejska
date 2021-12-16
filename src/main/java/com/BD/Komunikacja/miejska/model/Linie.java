package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "LINIE")
public class Linie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Numer_linii", nullable = false)
    private int numerLinii;

    @ManyToMany(mappedBy = "linie")
    Set<Przystanki> przystanki;
}
