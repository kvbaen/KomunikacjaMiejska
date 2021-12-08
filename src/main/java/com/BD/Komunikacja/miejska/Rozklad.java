package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Rozklad {
    private int id;
    private Time godzinaPrzyjazdu;
    private Integer dzienTygodnia;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Godzina_przyjazdu", nullable = false)
    public Time getGodzinaPrzyjazdu() {
        return godzinaPrzyjazdu;
    }

    public void setGodzinaPrzyjazdu(Time godzinaPrzyjazdu) {
        this.godzinaPrzyjazdu = godzinaPrzyjazdu;
    }

    @Basic
    @Column(name = "Dzien_tygodnia", nullable = true)
    public Integer getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(Integer dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rozklad rozklad = (Rozklad) o;
        return id == rozklad.id && Objects.equals(godzinaPrzyjazdu, rozklad.godzinaPrzyjazdu) && Objects.equals(dzienTygodnia, rozklad.dzienTygodnia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, godzinaPrzyjazdu, dzienTygodnia);
    }
}
