package com.BD.Komunikacja.miejska.service;


import com.BD.Komunikacja.miejska.model.Przystanki;
import com.BD.Komunikacja.miejska.repository.PrzystankiRepository;
import com.BD.Komunikacja.miejska.request.PrzystankiRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrzystankiService {
    private final PrzystankiRepository przystankiRepository;

    public PrzystankiService(PrzystankiRepository przystankiRepository) {
        this.przystankiRepository = przystankiRepository;
    }

    public void add(PrzystankiRequest request){
        Przystanki przystanek = new Przystanki();
        przystanek.setNazwa(request.getNazwa());
        przystanek.setUlica(request.getUlica());
        przystanek.setId_strefy(request.getId_strefy());
        przystankiRepository.saveAndFlush(przystanek);
    }

    public void edit (int przystanekId, PrzystankiRequest request){
        Przystanki przystanek = przystankiRepository.findById(przystanekId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        przystanek.setNazwa(request.getNazwa());
        przystanek.setUlica(request.getUlica());
        przystanek.setId_strefy(request.getId_strefy());
        przystankiRepository.saveAndFlush(przystanek);
    }

    public void delete (int przystanekId){
        Przystanki deleteId = przystankiRepository.findById(przystanekId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        przystankiRepository.delete(deleteId);
    }

    public List<Przystanki> getAll() {
        return przystankiRepository.findAll();
    }

//    public Przystanki getPrzystanek (int przystanekId){
//        return przystankiRepository.findById(przystanekId).orElseThrow();
//    }
//    public List<Przystanki> getPrzystanki (){
//        return przystankiRepository.findAll();
//    }

}
