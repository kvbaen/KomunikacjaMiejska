package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Klienci;
import com.BD.Komunikacja.miejska.repository.KlienciRepository;
import com.BD.Komunikacja.miejska.request.KlienciRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlienciService {
    private final KlienciRepository klienciRepository;

    public KlienciService(KlienciRepository klienciRepository) {
        this.klienciRepository = klienciRepository;
    }

    public void add(KlienciRequest request){
        Klienci klient = new Klienci();
        klient.setImie(request.getImie());
        klient.setNazwisko(request.getNazwisko());
        klient.setId_e_karty(request.getId_e_karty());
        klient.setId_centrali(request.getId_centrali());
        klienciRepository.saveAndFlush(klient);
    }

    public void edit (int klientId, KlienciRequest request){
        Klienci klient = klienciRepository.findById(klientId).orElseThrow(()-> new RuntimeException("Nie znalazło parkingu"));
        klient.setImie(request.getImie());
        klient.setNazwisko(request.getNazwisko());
        klient.setId_e_karty(request.getId_e_karty());
        klient.setId_centrali(request.getId_centrali());
        klienciRepository.saveAndFlush(klient);
    }

    public void delete(int klientId){
        Klienci deleteId = klienciRepository.findById(klientId).orElseThrow(()-> new RuntimeException("Nie znalazło klienta"));
        klienciRepository.delete(deleteId);
    }

    public List<Klienci> getAll(){
        return klienciRepository.findAll();
    }
}
