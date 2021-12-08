package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Wypozyczenia {
    private int id;
    private Date dataOd;
    private Date dataDo;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Data_od", nullable = true)
    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    @Basic
    @Column(name = "Data_do", nullable = true)
    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wypozyczenia that = (Wypozyczenia) o;
        return id == that.id && Objects.equals(dataOd, that.dataOd) && Objects.equals(dataDo, that.dataDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataOd, dataDo);
    }
}
