package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KlienciRequest {
    private String imie;
    private String nazwisko;
    private int id_e_karty;
    private int id_centrala_komunikacji_miejskiej;
}