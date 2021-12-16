package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Parkingi;
import com.BD.Komunikacja.miejska.request.ParkingiRequest;
import com.BD.Komunikacja.miejska.response.ParkingiResponse;
import com.BD.Komunikacja.miejska.service.ParkingiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ParkingiController {
    private final ParkingiService parkingiService;

    public ParkingiController(ParkingiService parkingiService) {
        this.parkingiService = parkingiService;
    }

    @GetMapping("/parkingi")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<ParkingiResponse> parkingi() {
        ParkingiResponse parkingiResponse = new ParkingiResponse();
        List<Parkingi> parkingiList = parkingiService.getAll();
        parkingiResponse.setParkingiList(parkingiList);
        return ResponseEntity.ok(parkingiResponse);
    }

    @PostMapping("/parkingi")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> parkingiP(@RequestBody ParkingiRequest request) {
        parkingiService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/parkingi/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> parkingiE(@PathVariable int id, @RequestBody ParkingiRequest request){
        parkingiService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/parkingi/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> parkingiD(@PathVariable int id){
        parkingiService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
