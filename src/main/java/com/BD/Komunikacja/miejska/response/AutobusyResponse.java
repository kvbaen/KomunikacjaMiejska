package com.BD.Komunikacja.miejska.response;

import com.BD.Komunikacja.miejska.model.Autobusy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutobusyResponse {
    List<Autobusy> autobusyList;
}
