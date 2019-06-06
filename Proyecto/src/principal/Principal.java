package principal;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * declaracion de la clase Principal que se extiende a Application
 * @author Adrian y Samuel
 * @version 6/06/19
 *
 */
public class Principal extends Application {
	/**
	 * El metodo start de la clase Principal llama al Stage primaryStage e inicia el FXML inicio.fxml del package view 
	 */
	public void start(Stage primaryStage) {
		Parent root;
		try {
			root=FXMLLoader.load(getClass().getResource("/view/inicio.fxml"));		
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * El metodo main ejecuta una aplicación con el launch.
	 * @param args tipo String[]
	 */
	public static void main(String[] args) {
		launch(args);
	}
}