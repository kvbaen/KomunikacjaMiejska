package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.EKarty;
import com.BD.Komunikacja.miejska.model.Klienci;
import com.BD.Komunikacja.miejska.repository.EKartyRepository;
import com.BD.Komunikacja.miejska.request.EKartyRequest;
import com.BD.Komunikacja.miejska.request.KlienciRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EKartyService {
    private final EKartyRepository eKartyRepository;

    public EKartyService(EKartyRepository eKartyRepository) {
        this.eKartyRepository = eKartyRepository;
    }

    public void add(EKartyRequest request){
        EKarty eKarta = new EKarty();
        eKarta.setNazwa(request.getNazwa());
        eKarta.setId_biletu(request.getId_biletu());
        eKartyRepository.saveAndFlush(eKarta);
    }

    public void edit (int eKartaId, EKartyRequest request){
        EKarty eKarta = eKartyRepository.findById(eKartaId).orElseThrow(()-> new RuntimeException("Nie znalazło ekarty"));
        eKarta.setNazwa(request.getNazwa());
        eKarta.setId_biletu(request.getId_biletu());
        eKartyRepository.saveAndFlush(eKarta);
    }

    public void delete(int eKartaId){
        EKarty deleteId = eKartyRepository.findById(eKartaId).orElseThrow(()-> new RuntimeException("Nie znalazło ekarty"));
        eKartyRepository.delete(deleteId);
    }

    public List<EKarty> getAll(){
        return eKartyRepository.findAll();
    }

}
