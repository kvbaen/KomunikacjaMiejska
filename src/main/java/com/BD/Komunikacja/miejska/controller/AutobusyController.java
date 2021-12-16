package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Autobusy;
import com.BD.Komunikacja.miejska.model.Linie;
import com.BD.Komunikacja.miejska.request.AutobusyRequest;
import com.BD.Komunikacja.miejska.request.LinieRequest;
import com.BD.Komunikacja.miejska.request.PracownicyRequest;
import com.BD.Komunikacja.miejska.response.AutobusyResponse;
import com.BD.Komunikacja.miejska.response.LinieResponse;
import com.BD.Komunikacja.miejska.service.AutobusyService;
import com.BD.Komunikacja.miejska.service.LinieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutobusyController {
    @Autowired
    private AutobusyService autobusyService;

    @GetMapping("/autobusy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<AutobusyResponse> autobusy() {
        AutobusyResponse autobusyResponse = new AutobusyResponse();
        List<Autobusy> autobusyList = autobusyService.getAll();
        autobusyResponse.setAutobusyList(autobusyList);
        return ResponseEntity.ok(autobusyResponse);
    }

    @PostMapping("/autobusy")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> autobusyP(@RequestBody AutobusyRequest request) {
        autobusyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/autobusy/edit/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> autobusyE(@PathVariable int id, @RequestBody AutobusyRequest request){
        autobusyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/autobusy/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> autobusyD(@PathVariable int id){
        autobusyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
