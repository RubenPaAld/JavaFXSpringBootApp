package com.codetreatise.parameters;

import com.codetreatise.utils.Constantes;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.StringProperty;

public class StringComparableParameter {

    private final StringProperty txt;
    private final ReadOnlyObjectProperty<Constantes.OPERATORS> operator;

    public StringComparableParameter(StringProperty txt, ReadOnlyObjectProperty<Constantes.OPERATORS> operator) {
        this.txt = txt;
        this.operator = operator;
    }

    public String getTxt() {
        return txt.get();
    }

    public StringProperty txtProperty() {
        return txt;
    }

    public Constantes.OPERATORS getOperator() {
        return operator.get();
    }

    public ReadOnlyObjectProperty<Constantes.OPERATORS> operatorProperty() {
        return operator;
    }

    @Override
    public String toString() {
        return "StringComparableParameter{" +
                "txt=" + txt.getValue() +
                ", operator=" + operator.getValue() +
                '}';
    }
}
