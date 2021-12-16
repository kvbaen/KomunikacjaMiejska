package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Klienci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlienciRepository extends JpaRepository<Klienci, Integer> {
}
