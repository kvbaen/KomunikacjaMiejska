package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrzystankiRequest {
    private String nazwa;
    private String ulica;
    private int id_strefy;
}
