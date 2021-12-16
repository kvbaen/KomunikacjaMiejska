package com.BD.Komunikacja.miejska.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "CENTRALA")
public class Centrala {
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
}
