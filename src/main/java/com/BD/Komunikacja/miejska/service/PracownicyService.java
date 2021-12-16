package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Pracownicy;
import com.BD.Komunikacja.miejska.repository.PracownicyRepository;
import com.BD.Komunikacja.miejska.request.PracownicyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracownicyService {
    private final PracownicyRepository pracownicyRepository;

    public PracownicyService(PracownicyRepository pracownicyRepository) {
        this.pracownicyRepository = pracownicyRepository;
    }

    public void add(PracownicyRequest request){
        Pracownicy pracownik = new Pracownicy();
        pracownik.setImie(request.getImie());
        pracownik.setNazwisko(request.getNazwisko());
        pracownik.setWynagrodzenie(request.getWynagrodzenie());
        pracownik.setId_stanowiska(request.getId_stanowiska());
        pracownik.setId_centrali(request.getId_centrali());
        pracownicyRepository.saveAndFlush(pracownik);
    }

    public void edit (int pracownikId, PracownicyRequest request){
        Pracownicy pracownik = pracownicyRepository.findById(pracownikId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        pracownik.setImie(request.getImie());
        pracownik.setNazwisko(request.getNazwisko());
        pracownik.setWynagrodzenie(request.getWynagrodzenie());
        pracownik.setId_stanowiska(request.getId_stanowiska());
        pracownik.setId_centrali(request.getId_centrali());
        pracownicyRepository.saveAndFlush(pracownik);
    }

    public void delete (int pracownikId){
        Pracownicy deleteId = pracownicyRepository.findById(pracownikId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        pracownicyRepository.delete(deleteId);
    }

    public void setBusy(int pracownikId){
        Pracownicy setBusy1 = pracownicyRepository.findById(pracownikId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        setBusy1.setIsBusy(1);
        pracownicyRepository.save(setBusy1);
    }

    public void setNotBusy(int pracownikId){
        Pracownicy setBusy0 = pracownicyRepository.findById(pracownikId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        setBusy0.setIsBusy(0);
        pracownicyRepository.save(setBusy0);
    }

    public List<Pracownicy> getAll() {
        return pracownicyRepository.findAll();
    }
}
