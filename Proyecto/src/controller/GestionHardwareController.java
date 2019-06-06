package controller;
 
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
 
import dto.HardwareDTO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.conexion;
import model.jdbcHardwareDAO;
 /**declaracion de la clase GestionHardwareController
  * 
  * @author Adrian y Samuel
  *@version 31/05/19
  */
public class GestionHardwareController implements Initializable {
   
   //declaracion de los atributos privados
	/**
	 * Declaracion de los atributos privados de FXML
	 * 
	 */
    @FXML
    private TextField codigoInput;
    @FXML
    private TextField nombreInput;
    @FXML
    private TextField descripcionInput;
    @FXML
    private TextField anyoInput;
    @FXML
    private TextField precioInput;
    @FXML
    private TextField unidadesInput;
 
    @FXML
    private Button anyadir;
    @FXML
    private Button modificar;
    @FXML
    private Button eliminar;
    @FXML
    private Button atras;
    @FXML
    private Button masPrecio;
    @FXML
    private Button menosPrecio;
    @FXML
    private Button masUnidades;
    @FXML
    private Button menosUnidades;
    @FXML
    private Button limpiar;

   
    @FXML
    private TableView<HardwareDTO> tabla;
    @FXML
    private TableColumn<String,Integer> codigo;
    @FXML
    private TableColumn<String, String> nombre;
    @FXML
    private TableColumn<String, String> descripcion;
    @FXML
    private TableColumn<String, Integer> anyo;
    @FXML
    private TableColumn<String, Integer> precio;
   
    @FXML
    private TableColumn<String, Integer> unidades;
   
   /**
    * Declaracion de los atributos privados de la clase que no corresponden con
    * el FXML y llamar a la clase jdbcHardwareDAO
    */
    private ObservableList<HardwareDTO> itemsTable;
    private int posicionTabla;
    private jdbcHardwareDAO base;
    
    /**
     * creacion del constructor por defecto de la clase
     */
   
    public GestionHardwareController() {
        this.base= new jdbcHardwareDAO();
        this.tabla= new TableView<HardwareDTO>();
        this.itemsTable=FXCollections.observableArrayList(new HardwareDTO());
        this.codigo= new TableColumn<String,Integer>();
        this.nombre= new TableColumn<String,String>();
        this.descripcion= new TableColumn<String,String>();
        this.anyo= new TableColumn<String,Integer>();
        this.precio= new TableColumn<String,Integer>();
        this.unidades= new TableColumn<String,Integer>();
    }
    /**
     * Creacion del metodo Anyadir donde al hacer click se realiza la acción de 
     * recoger los datos de sus respectivos TextFields y crea un objeto HardwareDTO en el cual quedará 
     * guardado en el SQL y la tabla TableView con SetItems.
     * @param event tipo ActionEvent
     */
       
    @FXML
    private void Anyadir(ActionEvent event) {
        HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(anyoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText()));
        if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("") && !descripcionInput.getText().equals("") && !anyoInput.getText().equals("") && !precioInput.getText().equals("") && !unidades.getText().equals(""))
        {
        base.Anyadir(h);
        itemsTable.add(h);
        codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
        nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        anyo.setCellValueFactory(new PropertyValueFactory("Anyo"));
        precio.setCellValueFactory(new PropertyValueFactory("Precio"));
        unidades.setCellValueFactory(new PropertyValueFactory("Unidades"));
        tabla.setItems(itemsTable);
 
 
        }
       
                 
            }
    /**Creacion del metodo Eliminar donde se selecciona un objeto de la tabla
     * y al hacer click en el boton event se elimina el objeto del SQL y de la tabla
     * 
     * @param event tipo ActionEvent
     */
    @FXML
private void Eliminar(ActionEvent event) {
                HardwareDTO seleccion = tabla.getSelectionModel().getSelectedItem();
                base.Eliminar(seleccion);
                tabla.getItems().remove(seleccion);
 
       
    }
    /**Creacion del metodo Modificar en el cual coge los datos recogidos en los 
     * TextFields y si coinciden el codigo se modifican los demas parametros del objeto
     * HardwareDTO. Estas modificaciones se guardan en la tabla Tableview y en el SQL
     * 
     * @param event tipo ActionEvent
     */
 
    @FXML
private void Modificar(ActionEvent event) {
        HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(anyoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText()));     
        base.Modificar(h);
    itemsTable.set(posicionTabla, h);
    }
    /**Creacion del metodo Atras en el cual al dar al boton se activa el evento
     * en el cual llama al FXML guardado en el package view y monta una nueva ventana 
     * con el nuevo FXML cerrando la ventana anterior en el proceso.
     * @param event tipo ActionEvent
     * @throws IOException
     */
    @FXML
    private void Atras(ActionEvent event) throws IOException {
        Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector_Inventario.fxml"));
        Scene principal = new Scene(log);
        Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        PrimaryStage.hide();
        PrimaryStage.setScene(principal);
        PrimaryStage.show();  
 
 
 
    }
    /**
     * Creacion del metodo Limpiar en el cual limpia los Textfields .
     * @param event tipo ActionEvent
     * @throws IOException
     */
    @FXML
	private void Limpiar(ActionEvent event) throws IOException {
		codigoInput.clear();
		nombreInput.clear();
		descripcionInput.clear();
		anyoInput.clear();		
		precioInput.clear();
		unidadesInput.clear();
	}
/**
 * El metodo mostrar recoge los datos de la tabla Hardware de nuestro SQL, crea objetos HardwareDTO con esos datos
 *  y los pega al TableView tabla
 */
    public void mostrar() {
        PreparedStatement ps = null;
       
        try {
            ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Hardware");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                itemsTable.add(new HardwareDTO(rs.getInt("CodigoHW"), rs.getString("Nombre"),rs.getString("Descripcion"), rs.getInt("Anyo"), rs.getInt("Precio"), rs.getInt("Unidades")));
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
  * entrar en el controlador GestionHardwareController
  */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
        nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        anyo.setCellValueFactory(new PropertyValueFactory("Anyo"));
        precio.setCellValueFactory(new PropertyValueFactory("Precio"));
        unidades.setCellValueFactory(new PropertyValueFactory("Unidades"));
        mostrar();
       
        final ObservableList<HardwareDTO> tablaSel= tabla.getSelectionModel().getSelectedItems();
        tablaSel.addListener(seleccionar);
 
    }
   /**
    * El constructor ListChangeListener recoge un objeto HardwareDTO y sus datos varian dependiendo del seleccionado
    * llamando al metodo ponerHardwareSeleccionado
    */
    private final ListChangeListener<HardwareDTO> seleccionar =
            new ListChangeListener<HardwareDTO>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends HardwareDTO> c) {
            ponerHardwareSeleccionado();
        }
    };
   /**
    * El metodo seleccion recoge un elemento HardwareDTO sellecionado de la tabla y
    * si no hay elementos HardwareDTO en la tabla devuelve null
    * @return HardwareDTO competicionSeleccionada or null
    */
public HardwareDTO seleccion() {
    if(tabla !=null) {
        List<HardwareDTO> TABLA = (List<HardwareDTO>) tabla.getSelectionModel().getSelectedItems();
        if(TABLA.size()==1) {
            final HardwareDTO competicionSeleccionada = TABLA.get(0);
            return competicionSeleccionada;
        }
    }
    return null;
}
/**
 * El metodo ponerHardwareSeleccionado recoge los datos del HardwareDTO recogido del metodo seleccion descrito
 * anteriormente y pone sus datos en sus respectivos TextFields
 */
public void ponerHardwareSeleccionado() {
    final HardwareDTO hardwaredto = seleccion();
    posicionTabla = itemsTable.indexOf(hardwaredto);
    if (hardwaredto !=null) {
       
        codigoInput.setText(Integer.toString(hardwaredto.getCodigo()));
        nombreInput.setText(hardwaredto.getNombre());
        descripcionInput.setText(hardwaredto.getDescripcion());
        anyoInput.setText(Integer.toString(hardwaredto.getAnyo()));
        precioInput.setText(Integer.toString(hardwaredto.getPrecio()));
        unidadesInput.setText(Integer.toString(hardwaredto.getUnidades()));
    }
   
}
/**
 * Creacion del metodo sumarPrecio en el cual al hacer click en el boton se añade +1 al Integer precio en el TextField precioInput
 * @param event tipo ActionEvent
 */
 
@FXML
public void sumarPrecio(ActionEvent event) {
    HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(anyoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText()));     
    precioInput.clear();
    h.sumarPrecio();
    precioInput.setText(Integer.toString(h.getPrecio()));
   
}
/**
 * Creacion del metodo restarPrecio en el cual al hacer click en el boton se resta 1 al Integer precio en el TextField precioInput
 * @param event tipo ActionEvent
 */
@FXML
public void restarPrecio(ActionEvent event) {
    HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(anyoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText()));     
    precioInput.clear();
    h.restarPrecio();
    precioInput.setText(Integer.toString(h.getPrecio()));
   
}
/**
 * Creacion del metodo sumarUnidades en el cual al hacer click en el boton se añade +1 al Integer unidades en el TextField unidadesInput
 * @param event tipo ActionEvent
 */
@FXML
public void sumarUnidades(ActionEvent event) {
    HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(anyoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText()));     
    unidadesInput.clear();
    h.sumarUnidades();
    unidadesInput.setText(Integer.toString(h.getUnidades()));
   
}
/**
 * Creacion del metodo restarUnidades en el cual al hacer click en el boton se resta 1 al Integer unidades en el TextField unidadesInput
 * @param event tipo ActionEvent
 */
@FXML
public void restarUnidades(ActionEvent event) {
    HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(anyoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText()));     
    unidadesInput.clear();
    h.restarUnidades();
    unidadesInput.setText(Integer.toString(h.getUnidades()));
   
}
 
 
 
 
 
}
