package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Linie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinieRepository extends JpaRepository<Linie, Integer> {
}
