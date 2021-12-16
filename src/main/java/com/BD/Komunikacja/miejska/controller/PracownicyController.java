package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Pracownicy;
import com.BD.Komunikacja.miejska.request.PracownicyRequest;
import com.BD.Komunikacja.miejska.response.PracownicyResponse;
import com.BD.Komunikacja.miejska.service.PracownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PracownicyController {
    @Autowired
    private PracownicyService pracownicyService;

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


}
