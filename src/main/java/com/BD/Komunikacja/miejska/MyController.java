package com.BD.Komunikacja.miejska;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    BiletRepository biletRepository;

    @GetMapping("/test")
    public String test() {

        List<BiletM> bilet = biletRepository.findAll();
        return bilet.size() + "";
    }
}