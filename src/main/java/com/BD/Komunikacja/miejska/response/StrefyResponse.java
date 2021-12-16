package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Strefy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StrefyResponse {
    List<Strefy> strefyList;
}
