package com.BD.Komunikacja.miejska.service;


import com.BD.Komunikacja.miejska.model.Stanowiska;
import com.BD.Komunikacja.miejska.model.Strefy;
import com.BD.Komunikacja.miejska.repository.StanowiskaRepository;
import com.BD.Komunikacja.miejska.request.StanowiskaRequest;
import com.BD.Komunikacja.miejska.request.StrefyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StanowiskaService {
    private final StanowiskaRepository stanowiskaRepository;

    public StanowiskaService(StanowiskaRepository stanowiskaRepository) {
        this.stanowiskaRepository = stanowiskaRepository;
    }

    public void add(StanowiskaRequest request){
        Stanowiska stanowisko = new Stanowiska();
        stanowisko.setNazwa(request.getNazwa());
        stanowiskaRepository.saveAndFlush(stanowisko);
    }

    public void edit (int stanowiskoId, StanowiskaRequest request){
        Stanowiska stanowisko = stanowiskaRepository.findById(stanowiskoId).orElseThrow(()-> new RuntimeException("Nie znalazło strefy"));
        stanowisko.setNazwa(request.getNazwa());
        stanowiskaRepository.saveAndFlush(stanowisko);
    }

    public void delete(int stanowiskoId){
        Stanowiska deleteId = stanowiskaRepository.findById(stanowiskoId).orElseThrow(()-> new RuntimeException("Nie znalazło stanowiska"));
        stanowiskaRepository.delete(deleteId);
    }

    public List<Stanowiska>  getAll(){
        return stanowiskaRepository.findAll();
    }
}
