package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.EKarty;
import com.BD.Komunikacja.miejska.request.BiletyRequest;
import com.BD.Komunikacja.miejska.request.EKartyRequest;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.response.EKartyResponse;
import com.BD.Komunikacja.miejska.service.EKartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class EKartyController {
    @Autowired
    private EKartyService eKartyService;

    @GetMapping("/ekarty")
    public ResponseEntity<EKartyResponse> eKarty() {
        EKartyResponse eKartyResponse = new EKartyResponse();
        List<EKarty> eKartyList = eKartyService.getAll();
        eKartyResponse.setEKartyList(eKartyList);
        return  ResponseEntity.ok(eKartyResponse);
    }

    @PostMapping("/ekarty")
    public ResponseEntity<String> eKartyP(@RequestBody EKartyRequest request) {
        eKartyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/ekarty/edit/{id}")
    public ResponseEntity<String> biletyE(@PathVariable int id, @RequestBody EKartyRequest request){
        eKartyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/ekarty/delete/{id}")
    public ResponseEntity<String> eKartyD(@PathVariable int id){
        eKartyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
