package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "E_KARTY")
public class EKarty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Nazwa", nullable = false, length = 40)
    private String nazwa;
    @Column(name = "ID_BILETU", nullable = false)
    private int id_biletu;
}
