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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AutobusyController {
    @Autowired
    private AutobusyService autobusyService;

    @GetMapping("/autobusy")
    public ResponseEntity<AutobusyResponse> autobusy() {
        AutobusyResponse autobusyResponse = new AutobusyResponse();
        List<Autobusy> autobusyList = autobusyService.getAll();
        autobusyResponse.setAutobusyList(autobusyList);
        return ResponseEntity.ok(autobusyResponse);
    }

    @PostMapping("/autobusy")
    public ResponseEntity<String> autobusyP(@RequestBody AutobusyRequest request) {
        autobusyService.add(request);
        return ResponseEntity.ok("dodano");
    }

    @PostMapping("/autobusy/edit/{id}")
    public ResponseEntity<String> autobusyE(@PathVariable int id, @RequestBody AutobusyRequest request){
        autobusyService.edit(id, request);
        return ResponseEntity.ok("edytowano");
    }

    @PostMapping("/autobusy/delete/{id}")
    public ResponseEntity<String> autobusyD(@PathVariable int id){
        autobusyService.delete(id);
        return ResponseEntity.ok("usunieto");
    }
}
