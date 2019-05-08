package com.codetreatise.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constantes {

    private Constantes() {}

    public static List<String> getOperadores() {
        return new ArrayList<>(Arrays.asList("","<","<=","=",">=",">"));
    }
}
