package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WypozyczeniaRequest {
    private int id_pracownika;
    private int id_autobusu;
    private int id_linii;
}
