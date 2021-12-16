package com.BD.Komunikacja.miejska.controller;

import com.BD.Komunikacja.miejska.model.Autobusy;
import com.BD.Komunikacja.miejska.request.AutobusyRequest;
import com.BD.Komunikacja.miejska.response.AutobusyResponse;
import com.BD.Komunikacja.miejska.service.AutobusyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutobusyController {
    private final AutobusyService autobusyService;

    public AutobusyController(AutobusyService autobusyService) {
        this.autobusyService = autobusyService;
    }

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

    @PostMapping("/autobusy/setBusy/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> autobusySB(@PathVariable int id){
        autobusyService.setBusy(id);
        return ResponseEntity.ok("isBusy = 1");
    }

    @PostMapping("/autobusy/setNotBusy/{id}")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> autobusySNB(@PathVariable int id){
        autobusyService.setNotBusy(id);
        return ResponseEntity.ok("isBusy = 0");
    }
}
