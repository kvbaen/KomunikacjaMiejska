package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "BILETY")
public class Bilety {
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Rodzaj", nullable = false, length = 50)
    private String rodzaj;
    @Column(name = "Koszt", nullable = false)
    private int koszt;
    @Column(name = "ID_KLIENTA", nullable = false)
    private int id_klienta;

}
