package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Umowy;
import com.BD.Komunikacja.miejska.request.StanowiskaRequest;
import com.BD.Komunikacja.miejska.request.UmowyRequest;
import com.BD.Komunikacja.miejska.response.UmowyResponse;
import com.BD.Komunikacja.miejska.service.UmowyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UmowyController {
    @Autowired
    private UmowyService umowyService;

    @GetMapping("/umowy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<UmowyResponse> umowy() {
        UmowyResponse umowyResponse = new UmowyResponse();
        List<Umowy> umowyList = umowyService.getAll();
        umowyResponse.setUmowyList(umowyList);
        return ResponseEntity.ok(umowyResponse);
    }

    @PostMapping("/umowy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> umowyP(@RequestBody UmowyRequest request) {
        umowyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/umowy/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> umowyE(@PathVariable int id, @RequestBody UmowyRequest request){
        umowyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/umowy/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> umowyD(@PathVariable int id){
        umowyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}

