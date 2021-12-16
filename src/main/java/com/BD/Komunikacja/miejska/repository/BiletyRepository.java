package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Bilety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiletyRepository extends JpaRepository<Bilety, Integer> {
}
