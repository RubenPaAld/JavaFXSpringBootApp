package com.codetreatise.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constantes {

    private Constantes() {}

    public static List<String> getOperadores() {
        return new ArrayList<>(Arrays.asList("","<","<=","=",">=",">"));
    }

    public enum OPERATORS {
        NOTHING(""), LES("<"), LES_OR_EQUALS("<="), EQUALS("="), GREATER_OR_EQUALS(">="), GREATER(">");

        private String txt;

        OPERATORS(String s) {
            this.txt = s;
        }

        public String getTxt() {
            return this.txt;
        }

        public static List<OPERATORS> getAll() {
            return new ArrayList<>(Arrays.asList(OPERATORS.values()));
        }
    }
}
