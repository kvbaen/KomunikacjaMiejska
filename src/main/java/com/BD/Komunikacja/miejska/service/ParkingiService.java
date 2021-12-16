package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Parkingi;
import com.BD.Komunikacja.miejska.model.Przystanki;
import com.BD.Komunikacja.miejska.repository.ParkingiRepository;
import com.BD.Komunikacja.miejska.request.ParkingiRequest;
import com.BD.Komunikacja.miejska.request.PrzystankiRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingiService {
    private final ParkingiRepository parkingiRepository;

    public ParkingiService(ParkingiRepository parkingiRepository) {
        this.parkingiRepository = parkingiRepository;
    }

    public void add(ParkingiRequest request){
        Parkingi parking = new Parkingi();
        parking.setNazwa(request.getNazwa());
        parking.setAdres(request.getAdres());
        parkingiRepository.saveAndFlush(parking);
    }

    public void edit (int parkingId, ParkingiRequest request){
        Parkingi parking = parkingiRepository.findById(parkingId).orElseThrow(()-> new RuntimeException("Nie znalazło parkingu"));
        parking.setNazwa(request.getNazwa());
        parking.setAdres(request.getAdres());
        parkingiRepository.saveAndFlush(parking);
    }

    public void delete(int parkingId){
        Parkingi deleteId = parkingiRepository.findById(parkingId).orElseThrow(()-> new RuntimeException("Nie znalazło parkingu"));
        parkingiRepository.delete(deleteId);
    }

    public List<Parkingi> getAll(){
        return parkingiRepository.findAll();
    }
}
