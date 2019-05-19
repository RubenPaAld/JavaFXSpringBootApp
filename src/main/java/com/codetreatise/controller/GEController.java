package com.codetreatise.controller;

import com.codetreatise.bean.*;
import com.codetreatise.config.StageManager;
import com.codetreatise.parameters.*;
import com.codetreatise.service.*;
import com.codetreatise.utils.Constantes;
import com.codetreatise.utils.ControlsUtils;
import com.codetreatise.utils.GraphicsUtils;
import com.codetreatise.utils.MateriaPrimaDialog;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ListBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.table.TableRowExpanderColumn;
import org.fxmisc.easybind.EasyBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

@Controller
public class GEController implements Initializable {

	/**
	 *---------------FILTROS DE PEDIDOS -------------------
	 */

	@FXML
	private Accordion accordion;

	@FXML
	private TitledPane paneFiltros;

	@FXML
	private CheckComboBox<Cadena> cmbCadenas;

	@FXML
	private Label lblCountCadenas;

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
	private Label lblCountProveedores;

	@FXML
	private ComboBox<Constantes.OPERATORS> cmbOpMetrosPedido;

	@FXML
	private TextField txtMetrosPedido;

	@FXML
	private DatePicker dpFechaPedidoDesde;

	@FXML
	private DatePicker dpFechaPedidoHasta;

	@FXML
	private CheckComboBox<MateriaPrima> cmbMateriasPrimas;

	@FXML
	private Label lblCountMateriasPrimas;

	/**
	 *--------------- FILTROS DE ENTREGAS -------------------
	 */

	@FXML
	private CheckComboBox<TipoTransporte> cmbTransportes;

	@FXML
	private Label lblCountTransportes;

	@FXML
	private CheckComboBox<TipoEstadoEntrega> cmbEstadosEntregas;

	@FXML
	private Label lblCountEstadosEntregas;

	@FXML
	private ComboBox<Constantes.OPERATORS> cmbOpMetrosEntrega;

	@FXML
	private TextField txtMetrosEntrega;

	@FXML
	private DatePicker dpFechaSalidaDesde;

	@FXML
	private DatePicker dpFechaSalidaHasta;

	@FXML
	private DatePicker dpFechaEstimadaDesde;

	@FXML
	private DatePicker dpFechaEstimadaHasta;

	@FXML
	private DatePicker dpFechaLlegadaDesde;

	@FXML
	private DatePicker dpFechaLlegadaHasta;

	/**
	 *--------------- BOTONES DE FILTROS -------------------
	 */

	@FXML
	private Button btnLimpar;

	@FXML
	private Button btnBuscar;

	/**
	 *--------------- TABLA -------------------
	 */

	@FXML
	private TableView<Pedido> tablePedidos;

	@FXML
	private TableColumn tableColumCheck;

	@FXML
	private TableColumn<Pedido,Integer> tableColumNumero;

	@FXML
	private TableColumn<Pedido,Campana> tableColumCampana;

	@FXML
	private TableColumn<Pedido,Cadena> tableColumCadena;

	@FXML
	private TableColumn<Pedido,Destino> tableColumDestino;

	@FXML
	private TableColumn<Pedido,Proveedor> tableColumProveedor;

	@FXML
	private TableColumn<Pedido,Integer> tableColumMetros;

	@FXML
	private TableColumn<Pedido,MateriaPrima> tableColumMateriaPrima;

	@FXML
	private TableColumn<Pedido, Timestamp> tableColumFechaPedido;

	/**
	 *--------------- BOTONES INFERIORES -------------------
	 */

	@FXML
	private ButtonBar btnBar;

	/*@FXML
	private Button btnHelp;*/

	@FXML
	private Button btnNew;

	@FXML
	private Label lblSelect;

	/**
	 *--------------- SERVICIOS -------------------
	 */

	@Autowired
	private CadenaService cadenaService;

	@Autowired
	private CampanaService campanaService;

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private MateriaPrimaService materiaPrimaService;

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private TipoTransporteService tipoTransporteService;

	@Autowired
	private TipoEstadoEntregaService tipoEstadoEntregaService;

	@Autowired
	private PedidoService pedidoService;

	/**
	 *--------------- CAMPOS -------------------
	 */

	private ObservableList<Pedido> pedidos;

	private PedidoParameters pedidoParameters = new PedidoParameters();

	private EntregaParameters entregaParameters = new EntregaParameters();


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pedidos = FXCollections.observableArrayList();

		initPedidos();
		initEntregas();
		initBotonoes();
		initTable();
		initPabelBottom();

		accordion.setExpandedPane(paneFiltros);
	}

	private void initPedidos() {
		initCadenas();
		initCampanas();
		initProveedor();
		initMetrosPedido();
		initFechaPedido();
		initMateriasPrimas();
	}

	private void initEntregas() {
		initTransporte();
		initEstadosEntrega();
		initDestino();
		initMetrosEntrega();
		initFechaSalida();
		initFechaEstimada();
		initFechaLlegada();
	}

	private void initBotonoes() {

		initBuscar();
		initLimpar();
	}

	private void initPabelBottom() {
		initSeleccionados();
	}

	/**
	 *--------------- INICIALIZACION FILTROS PEDIDOS -------------------
	 */

	private void initCadenas() {

		final ObservableList<Cadena> cadenas = FXCollections.observableArrayList(cadenaService.findAll());

		cmbCadenas.getItems().addAll(cadenas);

		cmbCadenas.setConverter(new StringConverter<Cadena>() {
			@Override
			public String toString(Cadena object) {
				return object.getNombre();
			}

			@Override
			public Cadena fromString(String string) {
				return null;
			}
		});

		lblCountCadenas.textProperty().bind(Bindings.size(cmbCadenas.getCheckModel().getCheckedIndices()).asString());

		//cmbCampana.getCheckModel().getCheckedItems().addListener((ListChangeListener<Campana>) c -> System.out.println(cmbCampana.getCheckModel().getCheckedItems()));

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (Cadena camp: cmbCadenas.getCheckModel().getCheckedItems()) {
				sb.append(" ");
				sb.append(camp.getNombre());
			}

			return sb.toString();
		}  ,cmbCadenas.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.TOP_CENTER);

		ControlsUtils.addPopOver(lblCountCadenas,popOver);

		pedidoParameters.setCadenas(cmbCadenas.getCheckModel().getCheckedItems());
	}

	private void initCampanas() {

		final ObservableList<Campana> campanas = FXCollections.observableArrayList(campanaService.findAll());

		cmbCampana.getItems().addAll(campanas);

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

		pedidoParameters.setCampanas(cmbCampana.getCheckModel().getCheckedItems());
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

		pedidoParameters.setProveedores(cmbProveedor.getCheckModel().getCheckedItems());
	}

	private void initMetrosPedido() {
		ControlsUtils.initOperatorsField(cmbOpMetrosPedido,txtMetrosPedido);

		StringComparableParameter scp = new StringComparableParameter(txtMetrosPedido.textProperty(), cmbOpMetrosPedido.getSelectionModel().selectedItemProperty());

		pedidoParameters.setMetrosPedido(scp);
	}

	private void initFechaPedido() {
		LocalDateIntervalParameter ldp = new LocalDateIntervalParameter(dpFechaPedidoDesde.valueProperty(),dpFechaPedidoHasta.valueProperty());

		pedidoParameters.setFechaPedido(ldp);
	}

	private void initMateriasPrimas() {
		final ObservableList<MateriaPrima> materiaPrimas = FXCollections.observableArrayList(materiaPrimaService.findAll());

		cmbMateriasPrimas.getItems().addAll(materiaPrimas);

		cmbMateriasPrimas.setConverter(new StringConverter<MateriaPrima>() {
			@Override
			public String toString(MateriaPrima object) {
				return object.getNombre();
			}

			@Override
			public MateriaPrima fromString(String string) {
				return null;
			}
		});

		lblCountMateriasPrimas.textProperty().bind(Bindings.size(cmbMateriasPrimas.getCheckModel().getCheckedIndices()).asString());

		//cmbDestinos.getCheckModel().getCheckedItems().addListener((ListChangeListener<Destino>) c -> System.out.println(cmbDestinos.getCheckModel().getCheckedItems()));

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (MateriaPrima pro: cmbMateriasPrimas.getCheckModel().getCheckedItems()) {
				sb.append(" |");
				sb.append(pro.getNombre());
				sb.append("| ");
			}

			return sb.toString();
		}  ,cmbMateriasPrimas.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.LEFT_CENTER);

		ControlsUtils.addPopOver(lblCountMateriasPrimas,popOver);

		pedidoParameters.setMateriasPrimas(cmbMateriasPrimas.getCheckModel().getCheckedItems());
	}

	/**
	 *--------------- INICIALIZACION FILTROS ENTREGAS -------------------
	 */

	private void initTransporte() {

		final ObservableList<TipoTransporte> tipoTransportes = FXCollections.observableArrayList(tipoTransporteService.findAll());

		cmbTransportes.getItems().addAll(tipoTransportes);

		cmbTransportes.setConverter(new StringConverter<TipoTransporte>() {
			@Override
			public String toString(TipoTransporte object) {
				return object.getNombre();
			}

			@Override
			public TipoTransporte fromString(String string) {
				return null;
			}
		});

		lblCountTransportes.textProperty().bind(Bindings.size(cmbTransportes.getCheckModel().getCheckedIndices()).asString());

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (TipoTransporte transporte: cmbTransportes.getCheckModel().getCheckedItems()) {
				sb.append(" ");
				sb.append(transporte.getNombre());
			}
			return sb.toString();
		}  ,cmbTransportes.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.TOP_CENTER);

		ControlsUtils.addPopOver(lblCountTransportes,popOver);

		entregaParameters.setTipoTransportes(cmbTransportes.getCheckModel().getCheckedItems());
	}

	private void initEstadosEntrega() {

		final ObservableList<TipoEstadoEntrega> tipoEstadoEntregas = FXCollections.observableArrayList(tipoEstadoEntregaService.findAll());

		cmbEstadosEntregas.getItems().addAll(tipoEstadoEntregas);

		cmbEstadosEntregas.setConverter(new StringConverter<TipoEstadoEntrega>() {
			@Override
			public String toString(TipoEstadoEntrega object) {
				return object.getNombre();
			}

			@Override
			public TipoEstadoEntrega fromString(String string) {
				return null;
			}
		});

		lblCountEstadosEntregas.textProperty().bind(Bindings.size(cmbEstadosEntregas.getCheckModel().getCheckedIndices()).asString());

		PopOver popOver = ControlsUtils.getPopOver(Bindings.createStringBinding( () -> {

			StringBuilder sb = new StringBuilder();

			for (TipoEstadoEntrega estadoEntrega: cmbEstadosEntregas.getCheckModel().getCheckedItems()) {
				sb.append(" ");
				sb.append(estadoEntrega.getNombre());
			}
			return sb.toString();
		}  ,cmbEstadosEntregas.getCheckModel().getCheckedItems()), PopOver.ArrowLocation.TOP_CENTER);

		ControlsUtils.addPopOver(lblCountEstadosEntregas,popOver);

		entregaParameters.setTipoEstadoEntregas(cmbEstadosEntregas.getCheckModel().getCheckedItems());
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

		entregaParameters.setDestinos(cmbDestinos.getCheckModel().getCheckedItems());
	}

	private void initMetrosEntrega() {
		ControlsUtils.initOperatorsField(cmbOpMetrosEntrega,txtMetrosEntrega);

		StringComparableParameter scp = new StringComparableParameter(txtMetrosEntrega.textProperty(), cmbOpMetrosEntrega.getSelectionModel().selectedItemProperty());

		entregaParameters.setMetrosEntrega(scp);
	}

	private void initFechaSalida() {
		LocalDateIntervalParameter ldp = new LocalDateIntervalParameter(dpFechaSalidaDesde.valueProperty(),dpFechaSalidaHasta.valueProperty());
		entregaParameters.setFechaSalida(ldp);
	}

	private void initFechaEstimada() {
		LocalDateIntervalParameter ldp = new LocalDateIntervalParameter(dpFechaEstimadaDesde.valueProperty(),dpFechaEstimadaHasta.valueProperty());
		entregaParameters.setFechaEstimada(ldp);
	}

	private void initFechaLlegada() {
		LocalDateIntervalParameter ldp = new LocalDateIntervalParameter(dpFechaLlegadaDesde.valueProperty(),dpFechaLlegadaHasta.valueProperty());
		entregaParameters.setFechaLlegada(ldp);
	}

	/**
	 *--------------- INICIALIZACION BOTONES FILTROS -------------------
	 */

	private void initLimpar() {

		btnLimpar.setOnMouseClicked(event -> {
			cmbCampana.getCheckModel().clearChecks();
			cmbCadenas.getCheckModel().clearChecks();
			cmbProveedor.getCheckModel().clearChecks();
			cmbOpMetrosPedido.getSelectionModel().clearSelection();
			txtMetrosPedido.clear();
			dpFechaPedidoDesde.getEditor().clear();

			cmbTransportes.getCheckModel().clearChecks();
			cmbEstadosEntregas.getCheckModel().clearChecks();
			cmbDestinos.getCheckModel().clearChecks();
			cmbOpMetrosEntrega.getSelectionModel().clearSelection();
			txtMetrosEntrega.clear();
			dpFechaSalidaDesde.getEditor().clear();
			dpFechaEstimadaDesde.getEditor().clear();
			dpFechaLlegadaDesde.getEditor().clear();
		});
	}

	private void initBuscar() {
		btnBuscar.setOnMouseClicked(event -> {
			//pedidos.clear()
			pedidos.setAll(pedidoService.findByCriteria(pedidoParameters,entregaParameters));
			paneFiltros.setExpanded(false);
			tablePedidos.refresh();
		});
	}

	/**
	 *--------------- INICIALIZACION TABLA -------------------
	 */

	private ScrollPane createEditor(TableRowExpanderColumn.TableRowDataFeatures param) {

		Pedido pedido = (Pedido) param.getValue();

		ScrollPane pane = new ScrollPane();
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(5,5,5,75));
		vbox.getChildren().add(ControlsUtils.getTableEntregaPedido(FXCollections.observableList(pedido.getEntregaPedidos())));

		pane.setContent(vbox);

		return pane;
	}

	private void initTable() {

		tablePedidos.setSelectionModel(null);

		tableColumCheck.setCellValueFactory(new PropertyValueFactory<>("selected"));
		tableColumCheck.setCellFactory(tc -> { TableCell cell = new TableCell() {

			@Override
			protected void updateItem(Object item, boolean empty) {

				Pedido pedido = (Pedido) this.getTableRow().getItem();

				if (pedido == null || item == null || empty)
					return;

				CheckBox checkBox = new CheckBox();

				checkBox.selectedProperty().bindBidirectional(pedido.selectedProperty());

				/*if (checkBox.isSelected())
					this.getTableRow().setStyle("-fx-background-color: red");
				else
					this.getTableRow().setStyle("-fx-background-color: transparent");*/

				setGraphic(checkBox);

				if (lblSelect.textProperty().isBound())
					lblSelect.textProperty().unbind();

				lblSelect.textProperty().bind(Bindings.size(pedidos.filtered(Pedido::isSelected)).asString().concat(" seleccionados"));

			}};
			return cell ;
		});

		TableRowExpanderColumn expanderColumn = new TableRowExpanderColumn<>(this::createEditor);
		expanderColumn.setStyle( "-fx-alignment: TOP-CENTER;");
		expanderColumn.setText("Entregas");

		tablePedidos.getColumns().add(1,expanderColumn);

		tableColumNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

		tableColumCadena.setCellValueFactory(new PropertyValueFactory<>("cadena"));

		tableColumCadena.setCellFactory(tc -> { TableCell cell = new TableCell() {
			@Override
			protected void updateItem(Object item, boolean empty) {

				if (item != null) {
					Cadena cadena = (Cadena) item;
					//Circle circle = GraphicsUtils.getEstadoEntrega(t.getNumero());
					//setGraphic(new Label(t.getNombre(),circle));
					ImageView imageView = GraphicsUtils.getImageCadena(cadena.getNumero());
					setPadding(new Insets(5));
					setGraphic(imageView);
				}
				super.updateItem(item, empty);
			}};
			return cell ;
		});

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

		tableColumMateriaPrima.setCellValueFactory(new PropertyValueFactory<>("materiaPrima"));
		tableColumMateriaPrima.setCellFactory(tc -> { TableCell cell = new TableCell() {
			@Override
			protected void updateItem(Object item, boolean empty) {

				if (item != null) {
					MateriaPrima materiaPrima = (MateriaPrima) item;
					setText(materiaPrima.getNombre());
				}

				super.updateItem(item, empty);
			}};

			cell.setOnMouseClicked(event -> {
				if (! cell.isEmpty()) {
					MateriaPrima materiaPrima = (MateriaPrima) cell.getItem();

					Stage myDialog = new MateriaPrimaDialog(StageManager.primaryStage, materiaPrima);
					myDialog.sizeToScene();
					myDialog.show();
				}
			});

			return cell ;
		});

		tableColumMetros.setCellValueFactory(new PropertyValueFactory<>("metros"));
		tableColumFechaPedido.setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));

		tablePedidos.setItems(pedidos);
	}

	/**
	 *--------------- INICIALIZACION DE BOTONERA INFERIOR -------------------
	 */


	private void initSeleccionados() {

		//lblSelect.textProperty().bind(Bindings.size(EasyBind.includeWhen(Boo)).asString());
	}
}
