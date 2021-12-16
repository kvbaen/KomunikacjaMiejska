package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Pracownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownicyRepository extends JpaRepository<Pracownicy, Integer> {
    Pracownicy getPracownicyByImie(String imie);
}
