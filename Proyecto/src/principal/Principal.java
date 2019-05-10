package principal;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

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
	
	public static void main(String[] args) {
		launch(args);
	}
}