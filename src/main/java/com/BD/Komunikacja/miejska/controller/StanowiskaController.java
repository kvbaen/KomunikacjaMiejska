package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Stanowiska;
import com.BD.Komunikacja.miejska.request.PracownicyRequest;
import com.BD.Komunikacja.miejska.request.StanowiskaRequest;
import com.BD.Komunikacja.miejska.response.StanowiskaResponse;
import com.BD.Komunikacja.miejska.service.StanowiskaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class StanowiskaController {
    @Autowired
    private StanowiskaService stanowiskaService;

    @GetMapping("/stanowiska")
    public ResponseEntity<StanowiskaResponse> stanowiska() {
        StanowiskaResponse stanowiskaResponse = new StanowiskaResponse();
        List<Stanowiska> stanowiskaList= stanowiskaService.getAll();
        stanowiskaResponse.setStanowiskaList(stanowiskaList);
        return ResponseEntity.ok(stanowiskaResponse);
    }

    @PostMapping("/stanowiska")
    public ResponseEntity<String> stanowiskaP(@RequestBody StanowiskaRequest request) {
        stanowiskaService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/stanowiska/edit/{id}")
    public ResponseEntity<String> pracownicyE(@PathVariable int id, @RequestBody StanowiskaRequest request){
        stanowiskaService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/stanowiska/delete/{id}")
    public ResponseEntity<String> stanowiskaD(@PathVariable int id){
        stanowiskaService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
