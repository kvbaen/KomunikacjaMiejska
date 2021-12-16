package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Stanowiska;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StanowiskaResponse {
    List<Stanowiska> stanowiskaList;
}
