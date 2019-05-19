package com.codetreatise.parameters;

import com.codetreatise.utils.Constantes.OPERATORS;

public class ComparatorParameter {

    private final Comparable object;
    private final OPERATORS operator;

    public ComparatorParameter(Comparable object, OPERATORS operator) {
        this.object = object;
        this.operator = operator;
    }

    public Comparable getObject() {
        return object;
    }

    public OPERATORS getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "ComparatorParameter{" +
                "object=" + object +
                ", operator=" + operator +
                '}';
    }
}
