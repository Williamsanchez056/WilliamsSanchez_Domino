package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.net.URL; 

public class MenuInicioController {

    private MediaPlayer mediaPlayer; 

    @FXML
    private void botonEmpezar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));
            Parent raizJuego = loader.load();
            Stage ventana = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene escenaJuego = new Scene(raizJuego);
            ventana.setScene(escenaJuego);
            ventana.show();
        } catch (Exception e) {
            System.err.println("Error al cargar el juego: " + e.getMessage());
        }
    }
    @FXML
    public void initialize() {
        try {

            URL recurso = getClass().getResource("/view/music/bachata.mp3");
            
            if (recurso != null) {
                Media audio = new Media(recurso.toString());
                mediaPlayer = new MediaPlayer(audio);
                
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
                mediaPlayer.setVolume(0.2); 
                
                mediaPlayer.play();
                System.out.println("Musica sonando");
            } else {
                System.out.println("No se encontro musica en: /view/music/bachata.mp3");
            }
        } catch (Exception e) {
            System.out.println("Error con la música: " + e.getMessage());
            e.printStackTrace();
        }
    }
}