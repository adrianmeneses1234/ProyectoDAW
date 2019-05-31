package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import dto.HardwareDTO;
import dto.LoginDTO;
import dto.SoftwareDTO;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.conexion;
import model.jdbcLoginDAO;

public class GestionUsuariosController implements Initializable {
		
	
	@FXML
	private TextField identificadorInput;
	@FXML
	private TextField nombreInput;
	@FXML
	private TextField contrasenyaInput;
	@FXML
	private TextField rolInput;
	@FXML
	private MenuButton selector;
	@FXML
	private MenuItem administrador;
	@FXML
	private MenuItem profesor;
	@FXML
	private MenuItem tecnico;
	
	
	@FXML
	private Button anyadir;
	@FXML
	private Button modificar;
	@FXML
	private Button eliminar;
	@FXML
	private Button atras;

	
	@FXML
	private TableView<LoginDTO> tabla;

	@FXML
	private TableColumn<String, Integer> identificador;
	@FXML
	private TableColumn<String, String> nombre;
	@FXML
	private TableColumn<String, String> contrasenya;
	@FXML
	private TableColumn<String, String> rol;

	private ObservableList<LoginDTO> itemsTable;
	private jdbcLoginDAO base;
	private int posicionTabla;
	
	public GestionUsuariosController() {
		this.base= new jdbcLoginDAO();
		this.tabla=new TableView<LoginDTO>();
		this.itemsTable=FXCollections.observableArrayList(new LoginDTO());
		this.identificador= new TableColumn<String,Integer>();
		this.nombre=new TableColumn<String, String>();
		this.contrasenya = new TableColumn<String, String>();
		this.rol= new TableColumn<String, String>();
	}
	@FXML
	private void AdministradorInput(ActionEvent event) {
		rolInput.clear();
		rolInput.setText("Administrador");
	}
	@FXML
	private void ProfesorInput(ActionEvent event) {
		rolInput.clear();
		rolInput.setText("Profesor");
	}
	@FXML
	private void TecnicoInput(ActionEvent event) {
		rolInput.clear();
		rolInput.setText("Tecnico");
	}
	

	@FXML
	private void Anyadir(ActionEvent event) {
		
		
		LoginDTO l = new LoginDTO(Integer.parseInt(identificadorInput.getText()), nombreInput.getText(), contrasenyaInput.getText(), rolInput.getText());
		if(!identificadorInput.getText().equals("") && !nombreInput.getText().equals("") && !contrasenyaInput.getText().equals("") && !rolInput.getText().equals("")) 
		{
			base.Anyadir(l);
			itemsTable.add(l);
			identificador.setCellValueFactory(new PropertyValueFactory("identificador"));
			nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
			contrasenya.setCellValueFactory(new PropertyValueFactory("contrasenya"));
			rol.setCellValueFactory(new PropertyValueFactory("rol"));
			tabla.setItems(itemsTable);
			
		}

					
	}
	@FXML
    private void Eliminar(ActionEvent event) {
		LoginDTO seleccion = tabla.getSelectionModel().getSelectedItem();
		base.Eliminar(seleccion);
		tabla.getItems().remove(seleccion);

		
			}

	@FXML
    private void Modificar(ActionEvent event) {
		LoginDTO l = new LoginDTO(Integer.parseInt(identificadorInput.getText()), nombreInput.getText(), contrasenyaInput.getText(), rolInput.getText());
		base.Modificar(l);
		itemsTable.set(posicionTabla, l);
		
		
	}
	@FXML
	private void Atras(ActionEvent event) throws IOException {
		Parent log =  FXMLLoader.load(getClass().getResource("/view/selectorMenu.fxml"));
	    Scene principal = new Scene(log);
	    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    PrimaryStage.hide(); 
	    PrimaryStage.setScene(principal);
	    PrimaryStage.show();  



	}
	public void mostrar() {
		PreparedStatement ps = null;
		
		try {
			ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Empleado");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				itemsTable.add(new LoginDTO(rs.getInt("identificador"),rs.getString("nombre"), rs.getString("contrasenya"),rs.getString("rol") ));
				tabla.setItems(itemsTable);
				
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		identificador.setCellValueFactory(new PropertyValueFactory("identificador"));
		nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
		contrasenya.setCellValueFactory(new PropertyValueFactory("contrasenya"));
		rol.setCellValueFactory(new PropertyValueFactory("rol"));
		mostrar();
		
		final ObservableList<LoginDTO> tablaSel= tabla.getSelectionModel().getSelectedItems();
		tablaSel.addListener(seleccionar);

	}
	
	private final ListChangeListener<LoginDTO> seleccionar =
			new ListChangeListener<LoginDTO>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends LoginDTO> l) {
			ponerLoginSeleccionado();
		}
	};
	
public LoginDTO seleccion() {
	if(tabla !=null) {
		List<LoginDTO> TABLA = (List<LoginDTO>) tabla.getSelectionModel().getSelectedItems();
		if(TABLA.size()==1) {
			final LoginDTO competicionSeleccionada = TABLA.get(0);
			return competicionSeleccionada;
		}
	}
	return null;
}
public void ponerLoginSeleccionado() {
	final LoginDTO logindto = seleccion();
	posicionTabla = itemsTable.indexOf(logindto);
	if (logindto !=null) {
		
		identificadorInput.setText(Integer.toString(logindto.getIdentificador()));
		nombreInput.setText(logindto.getNombre());
		contrasenyaInput.setText(logindto.getContrasenya());
		rolInput.setText(logindto.getRol());
			}
	




}
}