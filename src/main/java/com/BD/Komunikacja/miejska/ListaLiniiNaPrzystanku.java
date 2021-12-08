package com.BD.Komunikacja.miejska;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lista_linii_na_przystanku", schema = "sql11452112", catalog = "")
@IdClass(ListaLiniiNaPrzystankuPK.class)
public class ListaLiniiNaPrzystanku {
    private int idLinii;
    private int idPrzystanku;

    @Id
    @Column(name = "Id_linii", nullable = false)
    public int getIdLinii() {
        return idLinii;
    }

    public void setIdLinii(int idLinii) {
        this.idLinii = idLinii;
    }

    @Id
    @Column(name = "Id_przystanku", nullable = false)
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
        ListaLiniiNaPrzystanku that = (ListaLiniiNaPrzystanku) o;
        return idLinii == that.idLinii && idPrzystanku == that.idPrzystanku;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLinii, idPrzystanku);
    }
}
