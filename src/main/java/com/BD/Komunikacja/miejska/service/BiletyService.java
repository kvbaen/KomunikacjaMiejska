package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Bilety;
import com.BD.Komunikacja.miejska.repository.BiletyRepository;
import com.BD.Komunikacja.miejska.request.BiletyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiletyService {
    private final BiletyRepository biletyRepository;

    public BiletyService(BiletyRepository biletyRepository) {
        this.biletyRepository = biletyRepository;
    }

    public void add(BiletyRequest request){
        Bilety bilet = new Bilety();
        bilet.setRodzaj(request.getRodzaj());
        bilet.setKoszt(request.getKoszt());
        bilet.setId_klienta(request.getId_klienta());
        biletyRepository.saveAndFlush(bilet);
    }

    public void edit (int biletId, BiletyRequest request){
        Bilety bilet = biletyRepository.findById(biletId).orElseThrow(()-> new RuntimeException("Nie znalazło biletu"));
        bilet.setRodzaj(request.getRodzaj());
        bilet.setKoszt(request.getKoszt());
        bilet.setId_klienta(request.getId_klienta());
        biletyRepository.saveAndFlush(bilet);
    }

    public void delete(int biletId){
        Bilety deleteId = biletyRepository.findById(biletId).orElseThrow(()-> new RuntimeException("Nie znalazło biletu"));
        biletyRepository.delete(deleteId);
    }

    public List<Bilety> getAll(){
        return biletyRepository.findAll();
    }
}
