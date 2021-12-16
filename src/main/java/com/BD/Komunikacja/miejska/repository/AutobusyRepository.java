package com.BD.Komunikacja.miejska.repository;

import com.BD.Komunikacja.miejska.model.Autobusy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutobusyRepository extends JpaRepository<Autobusy, Integer> {
}
