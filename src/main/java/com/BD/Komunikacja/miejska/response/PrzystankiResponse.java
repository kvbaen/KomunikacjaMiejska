package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Przystanki;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrzystankiResponse {
    List<Przystanki> przystankiList;
}
