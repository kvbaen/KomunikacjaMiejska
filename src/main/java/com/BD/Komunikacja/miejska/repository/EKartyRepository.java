package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.EKarty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EKartyRepository extends JpaRepository<EKarty, Integer> {
}
