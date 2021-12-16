package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Wypozyczenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WypozyczeniaRepository extends JpaRepository<Wypozyczenia, Integer> {
}
