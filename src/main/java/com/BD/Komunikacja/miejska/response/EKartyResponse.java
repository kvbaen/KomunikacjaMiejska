package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.EKarty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EKartyResponse {
    List<EKarty> eKartyList;
}
