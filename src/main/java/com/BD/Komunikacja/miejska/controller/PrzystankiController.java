package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Przystanki;
import com.BD.Komunikacja.miejska.request.PrzystankiLinieRequest;
import com.BD.Komunikacja.miejska.request.PrzystankiRequest;
import com.BD.Komunikacja.miejska.response.PrzystankiResponse;
import com.BD.Komunikacja.miejska.service.PrzystankiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PrzystankiController {
    private final PrzystankiService przystankiService;

    public PrzystankiController(PrzystankiService przystankiService) {
        this.przystankiService = przystankiService;
    }

    @GetMapping("/przystanki")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<PrzystankiResponse> przystanki() {
        PrzystankiResponse przystankiResponse = new PrzystankiResponse();
        List<Przystanki> przystankiList = przystankiService.getAll();
        przystankiResponse.setPrzystankiList(przystankiList);
        return ResponseEntity.ok(przystankiResponse);
    }

    @PostMapping("/przystanki")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> przystankiP(@RequestBody PrzystankiRequest request) {
        przystankiService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/przystanki/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> przystankiE(@PathVariable int id, @RequestBody PrzystankiRequest request){
        przystankiService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/przystanki/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> przystankiD(@PathVariable int id){
        przystankiService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
    @PostMapping("/przystankilinie")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> przystankiLinie(@RequestBody PrzystankiLinieRequest request){
        przystankiService.addLinia(request.getId_przystanku(), request.getId_linii());
        return ResponseEntity.ok("dodano linie do przystanku");
    }
}
