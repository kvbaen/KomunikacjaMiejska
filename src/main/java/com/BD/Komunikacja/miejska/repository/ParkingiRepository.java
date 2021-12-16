package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Parkingi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingiRepository extends JpaRepository<Parkingi, Integer> {
}
