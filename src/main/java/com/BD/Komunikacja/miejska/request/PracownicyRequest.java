package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PracownicyRequest {
    private String imie;
    private String nazwisko;
    private int wynagrodzenie;
    private int id_stanowiska;
    private int id_centrala_komunikacji_miejskiej;
}
