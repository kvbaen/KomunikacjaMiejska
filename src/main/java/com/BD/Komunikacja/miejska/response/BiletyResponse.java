package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Bilety;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BiletyResponse {
    List<Bilety> biletyList;
}
