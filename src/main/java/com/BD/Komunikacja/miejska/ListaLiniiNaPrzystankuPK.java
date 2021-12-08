package com.BD.Komunikacja.miejska;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ListaLiniiNaPrzystankuPK implements Serializable {
    private int idLinii;
    private int idPrzystanku;

    @Column(name = "Id_linii", nullable = false)
    @Id
    public int getIdLinii() {
        return idLinii;
    }

    public void setIdLinii(int idLinii) {
        this.idLinii = idLinii;
    }

    @Column(name = "Id_przystanku", nullable = false)
    @Id
    public int getIdPrzystanku() {
        return idPrzystanku;
    }

    public void setIdPrzystanku(int idPrzystanku) {
        this.idPrzystanku = idPrzystanku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaLiniiNaPrzystankuPK that = (ListaLiniiNaPrzystankuPK) o;
        return idLinii == that.idLinii && idPrzystanku == that.idPrzystanku;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLinii, idPrzystanku);
    }
}
