package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "AUTOBUSY")
public class Autobusy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Numer_boczny", nullable = false)
    private int numerBoczny;
    @Column(name = "Marka", nullable = false, length = 30)
    private String marka;
    @Column(name = "Model", nullable = false, length = 30)
    private String model;
    @Column(name = "ID_PARKINGU", nullable = false)
    private int id_parkingu;
    @Column(name = "ID_CENTRALA_KOMUNIKACJI_MIEJSKIEJ", nullable = false)
    private int id_centrala_komunikacji_miejskiej;
}
