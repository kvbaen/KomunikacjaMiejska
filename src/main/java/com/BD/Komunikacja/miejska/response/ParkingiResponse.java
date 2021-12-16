package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Parkingi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingiResponse {
    List<Parkingi> parkingiList;
}
