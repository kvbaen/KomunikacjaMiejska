package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Linie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LinieResponse {
    List<Linie> linieList;
}
