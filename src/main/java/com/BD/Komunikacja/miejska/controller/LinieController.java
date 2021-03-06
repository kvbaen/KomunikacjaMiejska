package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Linie;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.response.LinieResponse;
import com.BD.Komunikacja.miejska.service.LinieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LinieController {
    private final LinieService linieService;

    public LinieController(LinieService linieService) {
        this.linieService = linieService;
    }

    @GetMapping("/linie")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<LinieResponse> linie() {
        LinieResponse linieResponse = new LinieResponse();
        List<Linie> linieList = linieService.getAll();
        linieResponse.setLinieList(linieList);
        return ResponseEntity.ok(linieResponse);
    }

    @PostMapping("/linie")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> linieP(@RequestBody LinieRequest request) {
        linieService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/linie/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> linieE(@PathVariable int id, @RequestBody LinieRequest request){
        linieService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/linie/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> linieD(@PathVariable int id){
        linieService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
