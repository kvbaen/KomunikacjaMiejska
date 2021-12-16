package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Umowy;
import com.BD.Komunikacja.miejska.model.Wypozyczenia;
import com.BD.Komunikacja.miejska.request.UmowyRequest;
import com.BD.Komunikacja.miejska.request.WypozyczeniaRequest;
import com.BD.Komunikacja.miejska.response.UmowyResponse;
import com.BD.Komunikacja.miejska.response.WypozyczeniaResponse;
import com.BD.Komunikacja.miejska.service.WypozyczeniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WypozyczeniaController {
    private final WypozyczeniaService wypozyczeniaService;

    public WypozyczeniaController(WypozyczeniaService wypozyczeniaService) {
        this.wypozyczeniaService = wypozyczeniaService;
    }


    @GetMapping("/wypozyczenia")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<WypozyczeniaResponse> wypozyczenia() {
        WypozyczeniaResponse wypozyczeniaResponse = new WypozyczeniaResponse();
        List<Wypozyczenia> wypozyczeniaList = wypozyczeniaService.getAll();
        wypozyczeniaResponse.setWypozyczeniaList(wypozyczeniaList);
        return ResponseEntity.ok(wypozyczeniaResponse);
    }

    @PostMapping("/wypozyczenia")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> wypozyczeniaP(@RequestBody WypozyczeniaRequest request) {
        wypozyczeniaService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/wypozyczenia/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> wypozyczeniaE(@PathVariable int id, @RequestBody WypozyczeniaRequest request){
        wypozyczeniaService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/wypozyczenia/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> wypozyczeniaD(@PathVariable int id){
        wypozyczeniaService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
