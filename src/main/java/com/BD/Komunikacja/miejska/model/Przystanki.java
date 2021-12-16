package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "PRZYSTANKI")
public class Przystanki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Nazwa", nullable = false, length = 50)
    private String nazwa;
    @Column(name = "Ulica", nullable = false, length = 50)
    private String ulica;
    @Column(name = "ID_STREFY", nullable = false)
    private int id_strefy;

    @ManyToMany
    @JoinTable(
            name = "linie_x_przystanki",
            joinColumns = @JoinColumn(name="ID_PRZYSTANKU"),
            inverseJoinColumns = @JoinColumn(name="ID_LINII")
    )
    Set<Linie> linie;

}
