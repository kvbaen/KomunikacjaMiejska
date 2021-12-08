package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Linie {
    private int id;
    private int numerLinii;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Numer_linii", nullable = false)
    public int getNumerLinii() {
        return numerLinii;
    }

    public void setNumerLinii(int numerLinii) {
        this.numerLinii = numerLinii;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linie linie = (Linie) o;
        return id == linie.id && numerLinii == linie.numerLinii;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numerLinii);
    }
}
