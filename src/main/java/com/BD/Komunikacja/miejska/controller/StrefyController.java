package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Strefy;
import com.BD.Komunikacja.miejska.request.StrefyRequest;
import com.BD.Komunikacja.miejska.response.StrefyResponse;
import com.BD.Komunikacja.miejska.service.StrefyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class StrefyController {
    @Autowired
    private StrefyService strefyService;

    @GetMapping("/strefy")
    public ResponseEntity<StrefyResponse> strefy() {
        StrefyResponse strefyResponse = new StrefyResponse();
        List<Strefy> strefyList = strefyService.getAll();
        strefyResponse.setStrefyList(strefyList);
        return ResponseEntity.ok(strefyResponse);
    }

    @PostMapping("/strefy")
    public ResponseEntity<String> strefyP(@RequestBody StrefyRequest request) {
        strefyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/strefy/delete/{id}")
    public ResponseEntity<String> strefyD(@PathVariable int id){
        strefyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
