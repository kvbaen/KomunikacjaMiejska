package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Linie;
import com.BD.Komunikacja.miejska.model.Parkingi;
import com.BD.Komunikacja.miejska.repository.LinieRepository;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.request.ParkingiRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinieService {
    private final LinieRepository linieRepository;

    public LinieService(LinieRepository linieRepository) {
        this.linieRepository = linieRepository;
    }

    public void add(LinieRequest request){
        Linie linia = new Linie();
        linia.setNumerLinii(request.getNumerLinii());
        linia.getPrzystanki();
        linieRepository.saveAndFlush(linia);
    }

    public void edit (int liniaId, LinieRequest request){
        Linie linia = linieRepository.findById(liniaId).orElseThrow(()-> new RuntimeException("Nie znalazło parkingu"));
        linia.setNumerLinii(request.getNumerLinii());
        linieRepository.saveAndFlush(linia);
    }

    public void delete(int liniaId){
        Linie deleteId = linieRepository.findById(liniaId).orElseThrow(()-> new RuntimeException("Nie znalazło linii"));
        linieRepository.delete(deleteId);
    }

    public List<Linie> getAll(){
        return linieRepository.findAll();
    }
}
