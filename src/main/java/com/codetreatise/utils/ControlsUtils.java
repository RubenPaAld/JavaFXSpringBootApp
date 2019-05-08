package com.codetreatise.utils;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.PopOver;

public class ControlsUtils {

    private ControlsUtils(){}

    public static PopOver getPopOver(ObservableValue<? extends String> value, PopOver.ArrowLocation arrowLocation) {
        PopOver popOver = new PopOver();

        Label label = new Label();
        label.setPadding(new Insets(5));
        label.textProperty().bind(value);

        popOver.setContentNode(label);
        popOver.setOpacity(0.7);
        popOver.setAutoHide(true);

        popOver.setArrowLocation(arrowLocation);

        return popOver;
    }

    public static void addPopOver(Label label, PopOver popOver) {

        label.hoverProperty().addListener(event -> {

            ReadOnlyBooleanProperty hover = (ReadOnlyBooleanProperty) event;

            if (hover.getValue() && !label.textProperty().get().equals("0"))
                popOver.show(label);
            else if (popOver.isShowing())
                popOver.hide();

        });
    }

    public static void txtfieldNumber(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
