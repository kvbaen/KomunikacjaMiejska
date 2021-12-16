package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Wypozyczenia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WypozyczeniaResponse {
    List<Wypozyczenia> wypozyczeniaList;
}
