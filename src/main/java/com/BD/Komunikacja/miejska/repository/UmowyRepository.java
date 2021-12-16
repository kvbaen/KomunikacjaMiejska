package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Umowy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmowyRepository extends JpaRepository<Umowy, Integer> {
}
