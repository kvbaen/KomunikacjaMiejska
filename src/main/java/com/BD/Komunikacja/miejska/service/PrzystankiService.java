package com.BD.Komunikacja.miejska.service;


import com.BD.Komunikacja.miejska.model.Linie;
import com.BD.Komunikacja.miejska.model.Przystanki;
import com.BD.Komunikacja.miejska.repository.PrzystankiRepository;
import com.BD.Komunikacja.miejska.request.PrzystankiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrzystankiService {
    private final PrzystankiRepository przystankiRepository;
    private final LinieService linieService;

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

    public void addLinia(int id_przystanku, int id_linii) {
        Przystanki przystanek = przystankiRepository.findById(id_przystanku).orElseThrow(()-> new RuntimeException("Nie znalazło przystanku"));
        Linie linia = linieService.getOne(id_linii);
        przystanek.addLinia(linia);
        przystankiRepository.saveAndFlush(przystanek);
    }

//    public Przystanki getPrzystanek (int przystanekId){
//        return przystankiRepository.findById(przystanekId).orElseThrow();
//    }
//    public List<Przystanki> getPrzystanki (){
//        return przystankiRepository.findAll();
//    }

}
