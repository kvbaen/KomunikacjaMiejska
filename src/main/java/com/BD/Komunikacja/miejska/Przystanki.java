package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Przystanki {
    private int id;
    private String nazwa;
    private String ulica;

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
    @Column(name = "Ulica", nullable = false, length = 50)
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Przystanki that = (Przystanki) o;
        return id == that.id && Objects.equals(nazwa, that.nazwa) && Objects.equals(ulica, that.ulica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, ulica);
    }
}
