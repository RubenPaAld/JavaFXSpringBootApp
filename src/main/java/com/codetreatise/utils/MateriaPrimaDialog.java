package com.codetreatise.utils;

import com.codetreatise.bean.MateriaPrima;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MateriaPrimaDialog extends Stage {

    public MateriaPrimaDialog(Stage owner, MateriaPrima materiaPrima) {
        super();
        setResizable(false);
        initOwner(owner);
        setTitle("Materia Prima");
        initModality(Modality.APPLICATION_MODAL);
        Group root = new Group();
        Scene scene = new Scene(root, 500, 300, Color.WHITE);
        setScene(scene);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-focus-color: transparent");
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(5,5,5,5));
        vbox.setAlignment(Pos.TOP_LEFT);


        Label titulo = new Label(materiaPrima.getNumero() + " "
                                    + materiaPrima.getTipoMateria().getNombre().toUpperCase() + " "
                                    + materiaPrima.getCalidad().getNombre().toUpperCase() + " "
                                    + materiaPrima.getColor().getNombre().toUpperCase()
                                );
        titulo.setGraphic(GraphicsUtils.getCircleById(10,materiaPrima.getColor().getNumero()));
        titulo.setStyle("-fx-font-weight: bold; -fx-font-size: 15px");
        titulo.setPadding(new Insets(5));

        Separator separator = new Separator();

        Label tituloNombre = ControlsUtils.getLabel("Nombre");
        TextArea txtAreaNombre = ControlsUtils.getTextArea(materiaPrima.getNombre(),3);

        Label tituloDescripcion = ControlsUtils.getLabel("Descripción");
        TextArea txtAreaDescripcion = ControlsUtils.getTextArea(materiaPrima.getDescripcion(),5);

        vbox.getChildren().addAll(titulo,separator,tituloNombre,txtAreaNombre,tituloDescripcion,txtAreaDescripcion);
        scrollPane.setContent(vbox);
        scene.setRoot(scrollPane);
    }
}
