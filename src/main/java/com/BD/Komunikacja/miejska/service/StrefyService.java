package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Strefy;
import com.BD.Komunikacja.miejska.model.Umowy;
import com.BD.Komunikacja.miejska.repository.StrefyRepository;
import com.BD.Komunikacja.miejska.request.StrefyRequest;
import com.BD.Komunikacja.miejska.request.UmowyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrefyService {
    private final StrefyRepository strefyRepository;

    public StrefyService(StrefyRepository strefyRepository) {
        this.strefyRepository = strefyRepository;
    }

    public void add(StrefyRequest request){
        Strefy strefa = new Strefy();
        strefa.setNazwa(request.getNazwa());
        strefyRepository.saveAndFlush(strefa);
    }

    public void edit (int strefaId, StrefyRequest request){
        Strefy strefa = strefyRepository.findById(strefaId).orElseThrow(()-> new RuntimeException("Nie znalazło strefy"));
        strefa.setNazwa(request.getNazwa());
        strefyRepository.saveAndFlush(strefa);
    }

    public void delete(int strefaId){
        Strefy deleteId = strefyRepository.findById(strefaId).orElseThrow(()-> new RuntimeException("Nie znalazło strefy"));
        strefyRepository.delete(deleteId);
    }

    public List<Strefy> getAll(){
        return strefyRepository.findAll();
    }
}
