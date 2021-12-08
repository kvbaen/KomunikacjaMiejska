package com.BD.Komunikacja.miejska;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Umowy {
    private int id;
    private String rodzajUmowy;
    private int okres;
    private Date dataZawarcia;
    private Date dataRozwiązania;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Rodzaj_umowy", nullable = false, length = 20)
    public String getRodzajUmowy() {
        return rodzajUmowy;
    }

    public void setRodzajUmowy(String rodzajUmowy) {
        this.rodzajUmowy = rodzajUmowy;
    }

    @Basic
    @Column(name = "Okres", nullable = false)
    public int getOkres() {
        return okres;
    }

    public void setOkres(int okres) {
        this.okres = okres;
    }

    @Basic
    @Column(name = "Data_zawarcia", nullable = false)
    public Date getDataZawarcia() {
        return dataZawarcia;
    }

    public void setDataZawarcia(Date dataZawarcia) {
        this.dataZawarcia = dataZawarcia;
    }

    @Basic
    @Column(name = "Data_rozwiązania", nullable = false)
    public Date getDataRozwiązania() {
        return dataRozwiązania;
    }

    public void setDataRozwiązania(Date dataRozwiązania) {
        this.dataRozwiązania = dataRozwiązania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Umowy umowy = (Umowy) o;
        return id == umowy.id && okres == umowy.okres && Objects.equals(rodzajUmowy, umowy.rodzajUmowy) && Objects.equals(dataZawarcia, umowy.dataZawarcia) && Objects.equals(dataRozwiązania, umowy.dataRozwiązania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rodzajUmowy, okres, dataZawarcia, dataRozwiązania);
    }
}
