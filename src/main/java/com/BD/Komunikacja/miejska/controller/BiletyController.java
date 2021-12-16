package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Bilety;
import com.BD.Komunikacja.miejska.request.AutobusyRequest;
import com.BD.Komunikacja.miejska.request.BiletyRequest;
import com.BD.Komunikacja.miejska.response.BiletyResponse;
import com.BD.Komunikacja.miejska.service.BiletyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BiletyController {
    @Autowired
    private BiletyService biletyService;

    @GetMapping("/bilety")
    public ResponseEntity<BiletyResponse> bilet() {
        BiletyResponse biletResponse = new BiletyResponse();
        List<Bilety> biletList =  biletyService.getAll();
        biletResponse.setBiletyList(biletList);
        return ResponseEntity.ok(biletResponse);
    }

    @PostMapping("/bilety")
    public ResponseEntity<String> biletP(@RequestBody BiletyRequest request) {
        biletyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/bilety/edit/{id}")
    public ResponseEntity<String> biletyE(@PathVariable int id, @RequestBody BiletyRequest request){
        biletyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/bilety/delete/{id}")
    public ResponseEntity<String> biletD(@PathVariable int id){
        biletyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
