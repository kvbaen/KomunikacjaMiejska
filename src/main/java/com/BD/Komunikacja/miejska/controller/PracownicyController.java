package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Pracownicy;
import com.BD.Komunikacja.miejska.request.PracownicyRequest;
import com.BD.Komunikacja.miejska.response.PracownicyResponse;
import com.BD.Komunikacja.miejska.service.PracownicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PracownicyController {
    private final PracownicyService pracownicyService;

    public PracownicyController(PracownicyService pracownicyService) {
        this.pracownicyService = pracownicyService;
    }

    @GetMapping("/pracownicy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<PracownicyResponse> pracownicy() {
        PracownicyResponse pracownicyResponse = new PracownicyResponse();
        List<Pracownicy> pracownicyList= pracownicyService.getAll();
        pracownicyResponse.setPracownicyList(pracownicyList);
        return ResponseEntity.ok(pracownicyResponse);
    }

    @PostMapping("/pracownicy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> pracownicyP(@RequestBody PracownicyRequest request) {
        pracownicyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/pracownicy/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> pracownicyE(@PathVariable int id, @RequestBody PracownicyRequest request){
        pracownicyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/pracownicy/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> pracownicyD(@PathVariable int id){
        pracownicyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }

    @PostMapping("/pracownicy/setBusy/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> pracownicySB(@PathVariable int id){
        pracownicyService.setBusy(id);
        return ResponseEntity.ok("isBusy = 1");
    }

    @PostMapping("/pracownicy/setNotBusy/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> pracownicySNB(@PathVariable int id){
        pracownicyService.setNotBusy(id);
        return ResponseEntity.ok("isBusy = 0");
    }


}
