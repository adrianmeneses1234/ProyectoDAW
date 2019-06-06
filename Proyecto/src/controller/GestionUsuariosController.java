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
/**declaracion de la clase GestionUsuariosController
 * 
 * @author Adrian y Samuel
 *@version 06/06/19
 */
public class GestionUsuariosController implements Initializable {
	 //declaracion de los atributos privados
	/**
	 * Declaracion de los atributos privados de FXML
	 * 
	 */	
	
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
	/**
	    * Declaracion de los atributos privados de la clase que no corresponden con
	    * el FXML y llamar a la clase jdbcLoginDAO
	    */
	private ObservableList<LoginDTO> itemsTable;
	private jdbcLoginDAO base;
	private int posicionTabla;
	 /**
     * creacion del constructor por defecto de la clase
     */
	public GestionUsuariosController() {
		this.base= new jdbcLoginDAO();
		this.tabla=new TableView<LoginDTO>();
		this.itemsTable=FXCollections.observableArrayList(new LoginDTO());
		this.identificador= new TableColumn<String,Integer>();
		this.nombre=new TableColumn<String, String>();
		this.contrasenya = new TableColumn<String, String>();
		this.rol= new TableColumn<String, String>();
	}
	/**
	 * El metodo AdministradorInput en el cual al dar click a su opcion se limpia el textField rolInput y se pone Administrador
	 * @param event tipo ActionEvent
	 */
	@FXML
	private void AdministradorInput(ActionEvent event) {
		rolInput.clear();
		rolInput.setText("Administrador");
	}
	/**
	 * El metodo ProfesorInput en el cual al dar click a su opcion se limpia el textField rolInput y se pone Profesor
	 * @param event tipo ActionEvent
	 */
	@FXML
	private void ProfesorInput(ActionEvent event) {
		rolInput.clear();
		rolInput.setText("Profesor");
	}
	/**
	 * El metodo TecnicoInput en el cual al dar click a su opcion se limpia el textField rolInput y se pone Tecnico
	 * @param event tipo ActionEvent
	 */
	@FXML
	private void TecnicoInput(ActionEvent event) {
		rolInput.clear();
		rolInput.setText("Tecnico");
	}
	 /**
     * Creacion del metodo Anyadir donde al hacer click se realiza la acción de 
     * recoger los datos de sus respectivos TextFields y crea un objeto LoginDTO en el cual quedará 
     * guardado en el SQL y la tabla TableView con SetItems.
     * @param event tipo ActionEvent
     */

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
	/**Creacion del metodo Eliminar donde se selecciona un objeto de la tabla
     * y al hacer click en el boton event se elimina el objeto LoginDTO del SQL y de la tabla
     * 
     * @param event tipo ActionEvent
     */
	@FXML
    private void Eliminar(ActionEvent event) {
		LoginDTO seleccion = tabla.getSelectionModel().getSelectedItem();
		base.Eliminar(seleccion);
		tabla.getItems().remove(seleccion);

		
			}
	 /**Creacion del metodo Modificar en el cual coge los datos recogidos en los 
     * TextFields y si coinciden el codigo se modifican los demas parametros del objeto
     * LoginDTO. Estas modificaciones se guardan en la tabla Tableview y en el SQL
     * 
     * @param event tipo ActionEvent
     */

	@FXML
    private void Modificar(ActionEvent event) {
		LoginDTO l = new LoginDTO(Integer.parseInt(identificadorInput.getText()), nombreInput.getText(), contrasenyaInput.getText(), rolInput.getText());
		base.Modificar(l);
		itemsTable.set(posicionTabla, l);
		
		
	}
	 /**Creacion del metodo Atras en el cual al dar al boton se activa el evento
     * en el cual llama al FXML guardado en el package view y monta una nueva ventana 
     * con el nuevo FXML cerrando la ventana anterior en el proceso.
     * @param event tipo ActionEvent
     * @throws IOException
     */
	@FXML
	private void Atras(ActionEvent event) throws IOException {
		Parent log =  FXMLLoader.load(getClass().getResource("/view/selectorMenu.fxml"));
	    Scene principal = new Scene(log);
	    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    PrimaryStage.hide(); 
	    PrimaryStage.setScene(principal);
	    PrimaryStage.show();  



	}
	
	/**
	 * El metodo mostrar recoge los datos de la tabla Empleado de nuestro SQL, crea objetos HardwareDTO con esos datos
	 *  y los pega al TableView tabla
	 */
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
	/**
	  * El metodo initialize recoge los datos que queremos mostrar al
	  * entrar en el controlador GestionUsuariosController
	  */
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
	 /**
	    * El constructor ListChangeListener recoge un objeto LoginDTO y sus datos varian dependiendo del seleccionado
	    * llamando al metodo ponerLoginSeleccionado
	    */
	private final ListChangeListener<LoginDTO> seleccionar =
			new ListChangeListener<LoginDTO>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends LoginDTO> l) {
			ponerLoginSeleccionado();
		}
	};
	/**
	    * El metodo seleccion recoge un elemento LoginDTO selecionado de la tabla y
	    * si no hay elementos LoginDTO en la tabla devuelve null
	    * @return LoginDTO competicionSeleccionada or null
	    */
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


/**
 * El metodo ponerLoginSeleccionado recoge los datos del LoginDTO recogido del metodo seleccion descrito
 * anteriormente y pone sus datos en sus respectivos TextFields
 */
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