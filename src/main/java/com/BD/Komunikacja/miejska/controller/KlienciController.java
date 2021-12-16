package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Klienci;
import com.BD.Komunikacja.miejska.model.Linie;
import com.BD.Komunikacja.miejska.request.EKartyRequest;
import com.BD.Komunikacja.miejska.request.KlienciRequest;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.response.KlienciResponse;
import com.BD.Komunikacja.miejska.response.LinieResponse;
import com.BD.Komunikacja.miejska.service.KlienciService;
import com.BD.Komunikacja.miejska.service.LinieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class KlienciController {
    @Autowired
    private KlienciService klienciService;

    @GetMapping("/klienci")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<KlienciResponse> klienci() {
        KlienciResponse klienciResponse = new KlienciResponse();
        List<Klienci> klienciList = klienciService.getAll();
        klienciResponse.setKlienciList(klienciList);
        return ResponseEntity.ok(klienciResponse);
    }

    @PostMapping("/klienci")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> klienciP(@RequestBody KlienciRequest request) {
        klienciService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/klienci/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> klienciE(@PathVariable int id, @RequestBody KlienciRequest request){
        klienciService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/klienci/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> klienciD(@PathVariable int id){
        klienciService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
