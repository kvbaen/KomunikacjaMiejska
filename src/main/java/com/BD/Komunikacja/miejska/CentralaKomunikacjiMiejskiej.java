package com.BD.Komunikacja.miejska;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "centrala_komunikacji_miejskiej", schema = "sql11452112", catalog = "")
public class CentralaKomunikacjiMiejskiej {
    private int id;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentralaKomunikacjiMiejskiej that = (CentralaKomunikacjiMiejskiej) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
