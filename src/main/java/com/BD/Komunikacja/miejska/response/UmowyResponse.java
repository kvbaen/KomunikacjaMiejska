package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Umowy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UmowyResponse {
    List<Umowy> umowyList;
}
