package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutobusyRequest {
    private int numerBoczny;
    private String marka;
    private String model;
    private int id_parkingu;
    private int id_centrali;
}
