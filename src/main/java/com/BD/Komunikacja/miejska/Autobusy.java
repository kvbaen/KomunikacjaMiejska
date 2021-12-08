package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Autobusy {
    private int id;
    private int numerBoczny;
    private String marka;
    private String model;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Numer_boczny", nullable = false)
    public int getNumerBoczny() {
        return numerBoczny;
    }

    public void setNumerBoczny(int numerBoczny) {
        this.numerBoczny = numerBoczny;
    }

    @Basic
    @Column(name = "Marka", nullable = false, length = 30)
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Basic
    @Column(name = "Model", nullable = false, length = 30)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autobusy autobusy = (Autobusy) o;
        return id == autobusy.id && numerBoczny == autobusy.numerBoczny && Objects.equals(marka, autobusy.marka) && Objects.equals(model, autobusy.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numerBoczny, marka, model);
    }
}
