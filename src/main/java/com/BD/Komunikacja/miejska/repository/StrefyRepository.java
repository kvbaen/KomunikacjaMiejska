package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Strefy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrefyRepository extends JpaRepository<Strefy, Integer> {
}
