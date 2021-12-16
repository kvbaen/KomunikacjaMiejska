package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Linie;
import com.BD.Komunikacja.miejska.request.KlienciRequest;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.response.LinieResponse;
import com.BD.Komunikacja.miejska.service.LinieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class LinieController {
    @Autowired
    private LinieService linieService;

    @GetMapping("/linie")
    public ResponseEntity<LinieResponse> linie() {
        LinieResponse linieResponse = new LinieResponse();
        List<Linie> linieList = linieService.getAll();
        linieResponse.setLinieList(linieList);
        return ResponseEntity.ok(linieResponse);
    }

    @PostMapping("/linie")
    public ResponseEntity<String> linieP(@RequestBody LinieRequest request) {
        linieService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/linie/edit/{id}")
    public ResponseEntity<String> linieE(@PathVariable int id, @RequestBody LinieRequest request){
        linieService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/linie/delete/{id}")
    public ResponseEntity<String> linieD(@PathVariable int id){
        linieService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
