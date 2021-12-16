package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Pracownicy;
import com.BD.Komunikacja.miejska.model.Umowy;

import com.BD.Komunikacja.miejska.repository.UmowyRepository;
import com.BD.Komunikacja.miejska.request.PracownicyRequest;
import com.BD.Komunikacja.miejska.request.UmowyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmowyService {
    private final UmowyRepository umowyRepository;

    public UmowyService(UmowyRepository umowyRepository) {
        this.umowyRepository = umowyRepository;
    }

    public void add(UmowyRequest request){
        Umowy umowa = new Umowy();
        umowa.setRodzajUmowy(request.getRodzajUmowy());
        umowa.setOkres(request.getOkres());
        umowa.setDataZawarcia(request.getDataZawarcia());
        umowa.setDataRozwiązania(request.getDataRozwiązania());
        umowa.setId_pracownika(request.getId_pracownika());
        umowyRepository.saveAndFlush(umowa);
    }

    public void edit (int umowaId, UmowyRequest request){
        Umowy umowa = umowyRepository.findById(umowaId).orElseThrow(()-> new RuntimeException("Nie znalazło umowy"));
        umowa.setRodzajUmowy(request.getRodzajUmowy());
        umowa.setOkres(request.getOkres());
        umowa.setDataZawarcia(request.getDataZawarcia());
        umowa.setDataRozwiązania(request.getDataRozwiązania());
        umowa.setId_pracownika(request.getId_pracownika());
        umowyRepository.saveAndFlush(umowa);
    }

    public void delete(int umowaId){
        Umowy deleteId = umowyRepository.findById(umowaId).orElseThrow(()-> new RuntimeException("Nie znalazło umowy"));
        umowyRepository.delete(deleteId);
    }

    public List<Umowy> getAll(){
        return umowyRepository.findAll();
    }
}
