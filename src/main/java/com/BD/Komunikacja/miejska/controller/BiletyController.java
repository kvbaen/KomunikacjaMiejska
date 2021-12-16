package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Bilety;
import com.BD.Komunikacja.miejska.request.AutobusyRequest;
import com.BD.Komunikacja.miejska.request.BiletyRequest;
import com.BD.Komunikacja.miejska.response.BiletyResponse;
import com.BD.Komunikacja.miejska.service.BiletyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BiletyController {
    @Autowired
    private BiletyService biletyService;

    @GetMapping("/bilety")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<BiletyResponse> bilety() {
        BiletyResponse biletyResponse = new BiletyResponse();
        List<Bilety> biletyList =  biletyService.getAll();
        biletyResponse.setBiletyList(biletyList);
        return ResponseEntity.ok(biletyResponse);
    }

    @PostMapping("/bilety")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> biletyP(@RequestBody BiletyRequest request) {
        biletyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/bilety/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> biletyE(@PathVariable int id, @RequestBody BiletyRequest request){
        biletyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/bilety/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> biletyD(@PathVariable int id){
        biletyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
