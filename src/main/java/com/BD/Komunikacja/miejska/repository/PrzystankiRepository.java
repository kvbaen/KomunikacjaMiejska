package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Przystanki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzystankiRepository extends JpaRepository<Przystanki, Integer> {
}
