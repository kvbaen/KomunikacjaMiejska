package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrzystankiLinieRequest {
    private int id_linii;
    private int id_przystanku;
}
