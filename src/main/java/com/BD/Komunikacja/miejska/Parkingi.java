package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Parkingi {
    private int id;
    private String nazwa;
    private String adres;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nazwa", nullable = false, length = 50)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "Adres", nullable = false, length = 100)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parkingi parkingi = (Parkingi) o;
        return id == parkingi.id && Objects.equals(nazwa, parkingi.nazwa) && Objects.equals(adres, parkingi.adres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, adres);
    }
}
