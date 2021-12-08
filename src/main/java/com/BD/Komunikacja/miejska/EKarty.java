package com.BD.Komunikacja.miejska;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "e_karty", schema = "sql11452112", catalog = "")
public class EKarty {
    private int id;
    private String nazwa;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nazwa", nullable = false, length = 40)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EKarty eKarty = (EKarty) o;
        return id == eKarty.id && Objects.equals(nazwa, eKarty.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa);
    }
}
