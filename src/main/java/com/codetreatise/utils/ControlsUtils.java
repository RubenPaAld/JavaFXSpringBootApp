package com.codetreatise.utils;

import com.codetreatise.bean.Destino;
import com.codetreatise.bean.EntregaPedido;
import com.codetreatise.bean.TipoEstadoEntrega;
import com.codetreatise.bean.TipoTransporte;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.StringConverter;
import org.controlsfx.control.PopOver;

public class ControlsUtils {

    private ControlsUtils(){}

    public static Label getLabel(String value) {
        Label label = new Label(value);
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 15px");
        label.setPadding(new Insets(5,0,2.5,5));

        return label;
    }

    public static TextArea getTextArea(String value, int rows) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setText(value);
        textArea.setPrefRowCount(rows);

        return textArea;
    }

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

            if (hover.getValue() && popOver.isShowing())
                return;

            if (!hover.getValue() && !popOver.isShowing())
                return;

            if (hover.getValue()) {
                if (popOver.isShowing())
                    popOver.hide();
                popOver.show(label);
            } else if (!hover.getValue() && popOver.isShowing()) {
                popOver.hide();
            }
        });
    }

    public static void txtfieldNumber(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
                return;
            }

            try {
                Integer.parseInt(newValue);
            } catch (Exception e) {
                textField.setText(oldValue);
            }
        });
    }

    public static void initOperatorsField(ComboBox<Constantes.OPERATORS> cmb, TextField textField) {

        final ObservableList<Constantes.OPERATORS> operadores = FXCollections.observableArrayList(Constantes.OPERATORS.getAll());

        cmb.getItems().addAll(operadores);

        cmb.setConverter(new StringConverter<Constantes.OPERATORS>() {
            @Override
            public String toString(Constantes.OPERATORS object) {
                return object.getTxt();
            }

            @Override
            public Constantes.OPERATORS fromString(String string) {
                return null;
            }
        });

        textField.setDisable(true);

        cmb.valueProperty().addListener(event -> {
            if (textField.isDisabled() && cmb.getValue() != Constantes.OPERATORS.NOTHING)
                textField.setDisable(false);
            else if (!textField.isDisabled() && cmb.getValue() == Constantes.OPERATORS.NOTHING)
                textField.setDisable(true);
        });

        ControlsUtils.txtfieldNumber(textField);
    }

    public static TableView<EntregaPedido> getTableEntregaPedido(ObservableList<EntregaPedido> entregaPedidos) {

        TableView<EntregaPedido> tabla = new TableView<>();

        TableColumn cNumero = new TableColumn("Numero");
        cNumero.setStyle( "-fx-alignment: CENTER-RIGHT;");

        TableColumn cTipoTransporte = new TableColumn("Transporte");
        cTipoTransporte.setStyle( "-fx-alignment: CENTER;");

        TableColumn cDestino = new TableColumn("Destino");
        cDestino.setStyle( "-fx-alignment: CENTER;");

        TableColumn cMetros = new TableColumn("Metros");
        cMetros.setStyle( "-fx-alignment: CENTER-RIGHT;");

        TableColumn cFechaSalida = new TableColumn("Fecha Salida");
        cFechaSalida.setStyle( "-fx-alignment: CENTER;");

        TableColumn cFechaEstimada = new TableColumn("Fecha Estimada");
        cFechaEstimada.setStyle( "-fx-alignment: CENTER;");

        TableColumn cFechaLlegada = new TableColumn("Fecha Llegada");
        cFechaLlegada.setStyle( "-fx-alignment: CENTER;");

        TableColumn cObservaciones = new TableColumn("Observaciones");
        cObservaciones.setStyle( "-fx-alignment: CENTER;");

        TableColumn cTipoEstado = new TableColumn("Estado");
        cTipoEstado.setStyle( "-fx-alignment: CENTER;");

        tabla.getColumns().addAll(cNumero,cTipoTransporte,cDestino,cMetros,cFechaSalida,cFechaEstimada,cFechaLlegada,cObservaciones,cTipoEstado);

        tabla.setPrefWidth(1175);
        tabla.setPrefHeight(50 + (25 * entregaPedidos.size()));

        if (entregaPedidos.isEmpty())
            return tabla;

        cNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        cTipoTransporte.setCellValueFactory(new PropertyValueFactory<>("tipoTransporte"));
        cTipoTransporte.setCellFactory(tc -> { TableCell cell = new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {

                    if (item != null) {
                        TipoTransporte t = (TipoTransporte) item;
                        Image image = GraphicsUtils.getImageTipoTransporte(((TipoTransporte) item).getNumero());

                        ImageView imageView = new ImageView();
                        imageView.setFitWidth(25);
                        imageView.setFitHeight(25);
                        imageView.setImage(image);

                        setGraphic(new Label(t.getNombre(),imageView));
                    }
                    super.updateItem(item, empty);
                }
            };
            return cell ;
        });
        cDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        cDestino.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Destino>() {
            @Override
            public String toString(Destino destino) {
                return destino.getNombre();
            }

            @Override
            public Destino fromString(String string) {
                return null;
            }
        }));
        cMetros.setCellValueFactory(new PropertyValueFactory<>("metros"));
        cFechaSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        cFechaEstimada.setCellValueFactory(new PropertyValueFactory<>("fechaEstimada"));
        cFechaLlegada.setCellValueFactory(new PropertyValueFactory<>("fechaLlegada"));
        cObservaciones.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        cMetros.setCellValueFactory(new PropertyValueFactory<>("metros"));
        cTipoEstado.setCellValueFactory(new PropertyValueFactory<>("tipoEstadoEntrega"));
        cTipoEstado.setCellFactory(tc -> { TableCell cell = new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {

                    if (item != null) {
                        TipoEstadoEntrega t = (TipoEstadoEntrega) item;
                        Circle circle = GraphicsUtils.getEstadoEntrega(t.getNumero());
                        setGraphic(new Label(t.getNombre(),circle));
                    }
                    super.updateItem(item, empty);
                }
            };
            return cell ;
        });
        tabla.setItems(entregaPedidos);
        return tabla;
    }
}
