package com.codetreatise.parameters;

import com.codetreatise.utils.Constantes;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class LocalDateIntervalParameter {

    private final ObjectProperty<LocalDate> desde;
    private final ObjectProperty<LocalDate> hasta;

    public LocalDateIntervalParameter(ObjectProperty<LocalDate> desde, ObjectProperty<LocalDate> hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    public LocalDate getDesde() {
        return desde.get();
    }

    public ObjectProperty<LocalDate> desdeProperty() {
        return desde;
    }

    public LocalDate getHasta() {
        return hasta.get();
    }

    public ObjectProperty<LocalDate> hastaProperty() {
        return hasta;
    }

    @Override
    public String toString() {
        return "LocalDateIntervalParameter{" +
                "desde=" + desde.getValue() +
                ", hasta=" + hasta.getValue() +
                '}';
    }
}
