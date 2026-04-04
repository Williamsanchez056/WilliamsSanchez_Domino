package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuInicio.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            primaryStage.setTitle("Domino");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false); 
            primaryStage.show();
            
            System.out.println("Menu Inicio");

        } catch (Exception e) {
            System.err.println("Error: No se puede cargar menu de inicio");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}