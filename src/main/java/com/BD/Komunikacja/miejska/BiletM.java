package com.BD.Komunikacja.miejska;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class BiletM {
    @Id
    private int id;
    @Column(length = 50)
    private String rodzaj;
    @Column(length = 3)
    private int koszt;
}
