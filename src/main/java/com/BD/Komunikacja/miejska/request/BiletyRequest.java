package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BiletyRequest {
    private String rodzaj;
    private int koszt;
    private int id_klienta;
}
