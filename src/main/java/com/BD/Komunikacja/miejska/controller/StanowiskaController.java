package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Stanowiska;
import com.BD.Komunikacja.miejska.request.StanowiskaRequest;
import com.BD.Komunikacja.miejska.response.StanowiskaResponse;
import com.BD.Komunikacja.miejska.service.StanowiskaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StanowiskaController {
    private final StanowiskaService stanowiskaService;

    public StanowiskaController(StanowiskaService stanowiskaService) {
        this.stanowiskaService = stanowiskaService;
    }

    @GetMapping("/stanowiska")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<StanowiskaResponse> stanowiska() {
        StanowiskaResponse stanowiskaResponse = new StanowiskaResponse();
        List<Stanowiska> stanowiskaList= stanowiskaService.getAll();
        stanowiskaResponse.setStanowiskaList(stanowiskaList);
        return ResponseEntity.ok(stanowiskaResponse);
    }

    @PostMapping("/stanowiska")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> stanowiskaP(@RequestBody StanowiskaRequest request) {
        stanowiskaService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/stanowiska/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> stanowiskaE(@PathVariable int id, @RequestBody StanowiskaRequest request){
        stanowiskaService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/stanowiska/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> stanowiskaD(@PathVariable int id){
        stanowiskaService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
