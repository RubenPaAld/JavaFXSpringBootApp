package com.codetreatise.controller;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.codetreatise.bean.*;
import com.codetreatise.parameters.EntregaParameters;
import com.codetreatise.parameters.LocalDateIntervalParameter;
import com.codetreatise.parameters.PedidoParameters;
import com.codetreatise.service.*;
import com.codetreatise.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController implements Initializable {

	@FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label lblLogin;
    
    @Autowired
    private UserService userService;

    @Autowired
	private CampanaService campanaService;

	@Autowired
	private CadenaService cadenaService;

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private PedidoService pedidoService;

    @Lazy
    @Autowired
    private StageManager stageManager;

	@FXML
    private void login(ActionEvent event) throws IOException{
    	if(userService.authenticate(getUsername(), getPassword())){
    		    		
    		stageManager.switchScene(FxmlView.USER);
    		
    	}else{
    		lblLogin.setText("Login Failed.");
    	}
    }
	
	public String getPassword() {
		return password.getText();
	}

	public String getUsername() {
		return username.getText();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		List<Pedido> pedidos = pedidoService.findByCriteria(null,null);

		System.out.println(pedidos.size());

		for (Pedido pedido: pedidos)
			System.out.println(pedido.toString() + '\n');
	}

}
