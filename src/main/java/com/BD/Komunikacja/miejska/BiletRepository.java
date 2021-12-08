package com.BD.Komunikacja.miejska;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiletRepository extends JpaRepository<BiletM, Integer> {
    public BiletM findBiletByRodzaj(String rodzaj);
}
