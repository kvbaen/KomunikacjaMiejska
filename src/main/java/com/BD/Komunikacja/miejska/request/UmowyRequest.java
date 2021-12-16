package com.BD.Komunikacja.miejska.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UmowyRequest {
    private String rodzajUmowy;
    private int okres;
    private Date dataZawarcia;
    private Date dataRozwiązania;
    private int id_pracownika;
}
