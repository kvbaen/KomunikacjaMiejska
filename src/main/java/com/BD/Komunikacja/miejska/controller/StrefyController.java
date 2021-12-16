package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Strefy;
import com.BD.Komunikacja.miejska.request.StrefyRequest;
import com.BD.Komunikacja.miejska.response.StrefyResponse;
import com.BD.Komunikacja.miejska.service.StrefyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StrefyController {
    private final StrefyService strefyService;

    public StrefyController(StrefyService strefyService) {
        this.strefyService = strefyService;
    }

    @GetMapping("/strefy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<StrefyResponse> strefy() {
        StrefyResponse strefyResponse = new StrefyResponse();
        List<Strefy> strefyList = strefyService.getAll();
        strefyResponse.setStrefyList(strefyList);
        return ResponseEntity.ok(strefyResponse);
    }

    @PostMapping("/strefy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> strefyP(@RequestBody StrefyRequest request) {
        strefyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/strefy/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> strefyE(@PathVariable int id, @RequestBody StrefyRequest request){
        strefyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/strefy/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> strefyD(@PathVariable int id){
        strefyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
