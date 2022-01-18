package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "KLIENCI")
public class Klienci {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Column(name = "IMIE", nullable = false, length = 20)
    private String imie;
    @Column(name = "NAZWISKO", nullable = false, length = 40)
    private String nazwisko;
    @Column(name = "ID_CENTRALI", nullable = false)
    private int id_centrali;

    @OneToMany(mappedBy = "klienci")
    private Set<Bilety> bilety;
}
