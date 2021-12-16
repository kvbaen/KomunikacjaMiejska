package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Wypozyczenia;
import com.BD.Komunikacja.miejska.repository.WypozyczeniaRepository;
import com.BD.Komunikacja.miejska.request.WypozyczeniaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WypozyczeniaService {
    private final WypozyczeniaRepository wypozyczeniaRepository;

    public WypozyczeniaService(WypozyczeniaRepository wypozyczeniaRepository) {
        this.wypozyczeniaRepository = wypozyczeniaRepository;
    }

    public void add(WypozyczeniaRequest request){
        Wypozyczenia wypozyczenie = new Wypozyczenia();
        wypozyczenie.setId_pracownika(request.getId_pracownika());
        wypozyczenie.setId_autobusu(request.getId_autobusu());
        wypozyczenie.setId_linii(request.getId_linii());
        wypozyczeniaRepository.saveAndFlush(wypozyczenie);
    }

    public void edit (int wypozyczenieId, WypozyczeniaRequest request){
        Wypozyczenia wypozyczenie = wypozyczeniaRepository.findById(wypozyczenieId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        wypozyczenie.setId_pracownika(request.getId_pracownika());
        wypozyczenie.setId_autobusu(request.getId_autobusu());
        wypozyczenie.setId_linii(request.getId_linii());
        wypozyczeniaRepository.saveAndFlush(wypozyczenie);
    }

    public void delete (int wypozyczenieId){
        Wypozyczenia deleteId = wypozyczeniaRepository.findById(wypozyczenieId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        wypozyczeniaRepository.delete(deleteId);
    }

    public List<Wypozyczenia> getAll() {
        return wypozyczeniaRepository.findAll();
    }
}
