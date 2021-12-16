package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Parkingi;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.request.ParkingiRequest;
import com.BD.Komunikacja.miejska.response.ParkingiResponse;
import com.BD.Komunikacja.miejska.service.ParkingiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ParkingiController {
    @Autowired
    private ParkingiService parkingiService;

    @GetMapping("/parkingi")
    public ResponseEntity<ParkingiResponse> parkingi() {
        ParkingiResponse parkingiResponse = new ParkingiResponse();
        List<Parkingi> parkingiList = parkingiService.getAll();
        parkingiResponse.setParkingiList(parkingiList);
        return ResponseEntity.ok(parkingiResponse);
    }

    @PostMapping("/parkingi")
    public ResponseEntity<String> parkingiP(@RequestBody ParkingiRequest request) {
        parkingiService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/parkingi/edit/{id}")
    public ResponseEntity<String> linieE(@PathVariable int id, @RequestBody ParkingiRequest request){
        parkingiService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/parkingi/delete/{id}")
    public ResponseEntity<String> parkingiD(@PathVariable int id){
        parkingiService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
