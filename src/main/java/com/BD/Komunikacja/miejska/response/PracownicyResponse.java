package com.BD.Komunikacja.miejska.response;


import com.BD.Komunikacja.miejska.model.Pracownicy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PracownicyResponse {
    List<Pracownicy> pracownicyList;
}
