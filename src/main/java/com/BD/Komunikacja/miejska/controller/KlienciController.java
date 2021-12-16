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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class KlienciController {
    @Autowired
    private KlienciService klienciService;

    @GetMapping("/klienci")
    public ResponseEntity<KlienciResponse> klienci() {
        KlienciResponse klienciResponse = new KlienciResponse();
        List<Klienci> klienciList = klienciService.getAll();
        klienciResponse.setKlienciList(klienciList);
        return ResponseEntity.ok(klienciResponse);
    }

    @PostMapping("/klienci")
    public ResponseEntity<String> klienciP(@RequestBody KlienciRequest request) {
        klienciService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/klienci/edit/{id}")
    public ResponseEntity<String> biletyE(@PathVariable int id, @RequestBody KlienciRequest request){
        klienciService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/klienci/delete/{id}")
    public ResponseEntity<String> klienciD(@PathVariable int id){
        klienciService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
