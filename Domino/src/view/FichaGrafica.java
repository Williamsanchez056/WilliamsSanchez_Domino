package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Ficha;

public class FichaGrafica extends VBox {

    @FXML
    private Label lblSuperior;

    @FXML
    private Label lblInferior;

    private Ficha fichaLogica;

    public FichaGrafica(Ficha ficha) {
        this.fichaLogica = ficha;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            actualizarVista();
            
        } catch (Exception e) {
            System.err.println("Error al crear la ficha gráfica: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void actualizarVista() {
        if (fichaLogica != null) {
            lblSuperior.setText(String.valueOf(fichaLogica.getValor1()));
            lblInferior.setText(String.valueOf(fichaLogica.getValor2()));
        }
    }

    public Ficha getFichaLogica() {
        return fichaLogica;
    }
}