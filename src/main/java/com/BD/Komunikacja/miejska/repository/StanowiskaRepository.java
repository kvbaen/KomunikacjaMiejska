package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Stanowiska;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StanowiskaRepository extends JpaRepository<Stanowiska, Integer> {
}
