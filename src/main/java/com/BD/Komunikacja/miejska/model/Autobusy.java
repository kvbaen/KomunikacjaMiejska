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
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Numer_boczny", nullable = false)
    private int numerBoczny;
    @Column(name = "Marka", nullable = false, length = 30)
    private String marka;
    @Column(name = "Model", nullable = false, length = 30)
    private String model;
    @Column(name = "ISBUSY")
    private int isBusy = 0;
    @Column(name = "ID_PARKINGU", nullable = false)
    private int id_parkingu;
    @Column(name = "ID_CENTRALI", nullable = false)
    private int id_centrali;
}
