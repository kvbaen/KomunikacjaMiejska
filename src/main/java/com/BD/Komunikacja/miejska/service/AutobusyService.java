package com.BD.Komunikacja.miejska.service;

import com.BD.Komunikacja.miejska.model.Autobusy;
import com.BD.Komunikacja.miejska.repository.AutobusyRepository;
import com.BD.Komunikacja.miejska.request.AutobusyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusyService {
    private final AutobusyRepository autobusyRepository;

    public AutobusyService(AutobusyRepository autobusyRepository) {
        this.autobusyRepository = autobusyRepository;
    }

    public void add(AutobusyRequest request){
        Autobusy autobus = new Autobusy();
        autobus.setNumerBoczny(request.getNumerBoczny());
        autobus.setMarka(request.getMarka());
        autobus.setModel(request.getModel());
        autobus.setId_parkingu(request.getId_parkingu());
        autobus.setId_centrali(request.getId_centrali());
        autobusyRepository.saveAndFlush(autobus);
    }

    public void edit (int autobusId, AutobusyRequest request) {
        Autobusy autobus = autobusyRepository.findById(autobusId).orElseThrow(() -> new RuntimeException("Nie znalazło autobusu"));
        autobus.setNumerBoczny(request.getNumerBoczny());
        autobus.setMarka(request.getMarka());
        autobus.setModel(request.getModel());
        autobus.setId_parkingu(request.getId_parkingu());
        autobus.setId_centrali(request.getId_centrali());
        autobusyRepository.saveAndFlush(autobus);
    }

    public void delete(int autobusId){
        Autobusy deleteId = autobusyRepository.findById(autobusId).orElseThrow(()-> new RuntimeException("Nie znalazło autobusu"));
        autobusyRepository.delete(deleteId);
    }

    public void setBusy(int autobusId){
        Autobusy setBusy1 = autobusyRepository.findById(autobusId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        setBusy1.setIsBusy(1);
        autobusyRepository.save(setBusy1);
    }

    public void setNotBusy(int autobusId){
        Autobusy setBusy0 = autobusyRepository.findById(autobusId).orElseThrow(()-> new RuntimeException("Nie znalazło użytkownika"));
        setBusy0.setIsBusy(0);
        autobusyRepository.save(setBusy0);
    }

    public List<Autobusy> getAll(){
        return autobusyRepository.findAll();
    }
}
