package com.codetreatise.controller;

import com.codetreatise.bean.*;
import com.codetreatise.service.*;
import com.codetreatise.utils.Constantes;
import com.codetreatise.utils.ControlsUtils;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.PopOver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sun.security.krb5.internal.crypto.Des;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class GEController implements Initializable {

	@FXML
	private ToolBar toolBarFirst;

	@FXML
	private ComboBox<Cadena> cmbCadena;

	@FXML
	private CheckComboBox<Campana> cmbCampana;

	@FXML
	private Label lblCountCampanas;

	@FXML
	private CheckComboBox<Destino> cmbDestinos;

	@FXML
	private Label lblCountDestinos;

	@FXML
	private CheckComboBox<Proveedor> cmbProveedor;

	@FXML
	private TextField txtPedido;

	@FXML
	private Label lblCountProveedores;

	@FXML
	private ComboBox cmbOp;

	@FXML
	private TextField txtMetros;

	@FXML
	private Button btnLimpar;

	@FXML
	private Button btnBuscar;

	@FXML
	private TableView<Entrega> tablePedidos;

	@FXML
	private TableColumn<Entrega,Integer> tableColumNumero;

	@FXML
	private TableColumn<Entrega,Tipo> tableColumTipo;

	@FXML
	private TableColumn<Entrega,Campana> tableColumCampana;

	@FXML
	private TableColumn<Entrega,Cadena> tableColumComprador;

	@FXML
	private TableColumn<Entrega,Destino> tableColumDestino;

	@FXML
	private TableColumn<Entrega,Proveedor> tableColumProveedor;

	@FXML
	private TableColumn<Entrega,Integer> tableColumCalidad;

	@FXML
	private TableColumn<Entrega,String> tableColumDescripcion;

	@FXML
	private TableColumn<Entrega,Integer> tableColumMetrosPedidos;

	@FXML
	private TableColumn<Entrega,Integer> tableColumMetrosEntrados;

	@FXML
	private TableColumn<Entrega,Integer> tableColumMetrosPendientes;

	@FXML
	private TableColumn<Entrega, Timestamp> tableColumFechaDisponible;

	@FXML
	private ButtonBar btnBar;

	@FXML
	private Button btnHelp;

	@FXML
	private Button btnNew;

	@Autowired
	private EntregaService entregaService;

	@Autowired
	private CadenaService cadenaService;

	@Autowired
	private CampanaService campanaService;

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private ProveedorService proveedorService;

	private ObservableList<Entrega> entregas;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initCadenas();
		initCampanas();
		initDestino();
		initPedido();
		initProveedor();
		initMetros();
		initLimpar();
		initBuscar();
		initTable();

		entregas = FXCollections.observableArrayList();
	}

	private void initCadenas() {

		final ObservableList<Cadena> cadenas = FXCollections.observableArrayList(cadenaService.findAll());

		cmbCadena.setItems(cadenas);

		cmbCadena.setCellFactory(new Callback<ListView<Cadena>,ListCell<Cadena>>(){

			@Override
			public ListCell<Cadena> call(ListView<Cadena> p) {
				return new ListCell<Cadena>(){
					@Override
					protected void updateItem(Cadena t, boolean bln) {
						super.updateItem(t, bln);

						if(t != null){
							setAlignment(Pos.CENTER_LEFT);
							setText(t.getNombre());
						}else{
							setText(null);
						}
					}
				};
			}
		});
		cmbCadena.setButtonCell(new ListCell<Cadena>() {
			@Override
			protected void updateItem(Cadena t, boolean bln) {
				super.updateItem(t, bln);
				if (t != null) {
					setText(t.getNombre());
				} else {
					setText(null);
				}

			}
		});
		cmbCadena.getSelectionModel().selectFirst();


	}

	private void initCampanas() {

		final ObservableList<Campana> campanas = FXCollections.observableArrayList(campanaService.findAll());

		cmbCampana.getItems().addAll(campanas);
		cmbCampana.getCheckModel().check(cmbCampana.getItems().size() - 1);

		cmbCampana.setConverter(new StringConverter<Campana>() {
			@Override
			public String toString(Campana object) {
				return object.getNombre();
			}

			@Override
			public Campana fromString(String string) {
				return null;
			}
		});

		lblCountCampanas.textProperty().bind(Bindings.size(cmbCampana.getCheckModel().getCheckedIndices()).asString());

		//cmbCampana.getCheckModel().getCheckedItems().addListener((ListChangeListener<Campana>) c -> System.out.println(cmbCampana.getCheckModel().getCheckedItems()));

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (Campana camp: cmbCampana.getCheckModel().getCheckedItems()) {
				sb.append(" ");
				sb.append(camp.getNombre());
			}

			return sb.toString();
		}  ,cmbCampana.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.TOP_CENTER);

		ControlsUtils.addPopOver(lblCountCampanas,popOver);
	}

	private void initDestino() {

		final ObservableList<Destino> destinos = FXCollections.observableArrayList(destinoService.findAll());

		cmbDestinos.getItems().addAll(destinos);

		cmbDestinos.setConverter(new StringConverter<Destino>() {
			@Override
			public String toString(Destino object) {
				return object.getNombre();
			}

			@Override
			public Destino fromString(String string) {
				return null;
			}
		});

		lblCountDestinos.textProperty().bind(Bindings.size(cmbDestinos.getCheckModel().getCheckedIndices()).asString());

		//cmbDestinos.getCheckModel().getCheckedItems().addListener((ListChangeListener<Destino>) c -> System.out.println(cmbDestinos.getCheckModel().getCheckedItems()));

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (Destino camp: cmbDestinos.getCheckModel().getCheckedItems()) {
				sb.append(" ");
				sb.append(camp.getNombre());
			}

			return sb.toString();
		}  ,cmbDestinos.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.TOP_CENTER);

		ControlsUtils.addPopOver(lblCountDestinos,popOver);
	}

	private void initPedido() {
		ControlsUtils.txtfieldNumber(txtPedido);
	}

	private void initProveedor() {

		final ObservableList<Proveedor> proveedores = FXCollections.observableArrayList(proveedorService.findAll());

		cmbProveedor.getItems().addAll(proveedores);

		cmbProveedor.setConverter(new StringConverter<Proveedor>() {
			@Override
			public String toString(Proveedor object) {
				return object.getNombre();
			}

			@Override
			public Proveedor fromString(String string) {
				return null;
			}
		});

		lblCountProveedores.textProperty().bind(Bindings.size(cmbProveedor.getCheckModel().getCheckedIndices()).asString());

		//cmbDestinos.getCheckModel().getCheckedItems().addListener((ListChangeListener<Destino>) c -> System.out.println(cmbDestinos.getCheckModel().getCheckedItems()));

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (Proveedor pro: cmbProveedor.getCheckModel().getCheckedItems()) {
				sb.append(" |");
				sb.append(pro.getNombre());
				sb.append("| ");
			}

			return sb.toString();
		}  ,cmbProveedor.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.LEFT_CENTER);

		ControlsUtils.addPopOver(lblCountProveedores,popOver);
	}

	private void initMetros() {

		final ObservableList<String> operadores = FXCollections.observableArrayList(Constantes.getOperadores());

		cmbOp.getItems().addAll(operadores);

		txtMetros.setDisable(true);

		cmbOp.valueProperty().addListener(event -> {
			if (txtMetros.isDisabled() && !cmbOp.getValue().equals(""))
				txtMetros.setDisable(false);
			else if (!txtMetros.isDisabled() && cmbOp.getValue() != null && cmbOp.getValue().equals(""))
				txtMetros.setDisable(true);
		});

		ControlsUtils.txtfieldNumber(txtMetros);
	}

	private void initLimpar() {

		btnLimpar.setOnMouseClicked(event -> {
			txtMetros.clear();
			txtPedido.clear();
			cmbOp.getSelectionModel().clearSelection();
			cmbDestinos.getCheckModel().clearChecks();
			cmbProveedor.getCheckModel().clearChecks();
			cmbCampana.getCheckModel().clearChecks();
			cmbCampana.getCheckModel().check(cmbCampana.getItems().size() - 1);
			cmbCadena.getSelectionModel().selectFirst();
		});
	}

	private void initBuscar() {
		btnBuscar.setOnMouseClicked(event -> {
			List<Entrega> entregas = entregaService.findAll();
			System.out.println(entregas);
			this.entregas.setAll(entregas);
			tablePedidos.setItems(this.entregas);
		});
	}

	private void initTable() {

		tableColumNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tableColumTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tableColumTipo.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Tipo>() {

			@Override
			public String toString(Tipo tipo) {
				return tipo.getNombre();
			}

			@Override
			public Tipo fromString(String string) {
				return null;
			}
		}));

		tableColumCampana.setCellValueFactory(new PropertyValueFactory<>("campana"));
		tableColumCampana.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Campana>() {

			@Override
			public String toString(Campana campana) {
				return campana.getNombre();
			}

			@Override
			public Campana fromString(String string) {
				return null;
			}
		}));

		tableColumComprador.setCellValueFactory(new PropertyValueFactory<>("comprador"));
		tableColumComprador.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Cadena>() {

			@Override
			public String toString(Cadena cadena) {
				return cadena.getNombre();
			}

			@Override
			public Cadena fromString(String string) {
				return null;
			}
		}));

		tableColumDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
		tableColumDestino.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Destino>() {

			@Override
			public String toString(Destino destino) {
				return destino.getNombre();
			}

			@Override
			public Destino fromString(String string) {
				return null;
			}
		}));

		tableColumProveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
		tableColumProveedor.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Proveedor>() {

			@Override
			public String toString(Proveedor proveedor) {
				return proveedor.getNombre();
			}

			@Override
			public Proveedor fromString(String string) {
				return null;
			}
		}));

		tableColumCalidad.setCellValueFactory(new PropertyValueFactory<>("calidad"));
		tableColumDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		tableColumMetrosPedidos.setCellValueFactory(new PropertyValueFactory<>("metrosPedidos"));
		tableColumMetrosEntrados.setCellValueFactory(new PropertyValueFactory<>("metrosEntrados"));
		tableColumMetrosPendientes.setCellValueFactory(new PropertyValueFactory<>("metrosPendientes"));

		tableColumFechaDisponible.setCellValueFactory(new PropertyValueFactory<>("fDisponible"));

		tablePedidos.setItems(entregas);
	}
}
