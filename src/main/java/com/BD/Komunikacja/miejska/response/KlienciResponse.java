package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Klienci;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KlienciResponse {
    List<Klienci> klienciList;
}
