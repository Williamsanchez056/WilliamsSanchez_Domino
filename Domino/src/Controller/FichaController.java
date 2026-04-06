package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Ficha;

public class FichaController {
    @FXML
    private VBox contenedorFicha; 

    @FXML
    private Label lblSuperior; 

    @FXML
    private Label lblInferior; 

    private Ficha fichaLogica; 

    public void cargarDatos(Ficha ficha) {
        this.fichaLogica = ficha;
        
        if (lblSuperior != null && lblInferior != null) {
            lblSuperior.setText(String.valueOf(ficha.getLadoA()));
            lblInferior.setText(String.valueOf(ficha.getLadoB()));
        } else {
            System.err.println(" Error: con los labels");
        }
    }

    public Ficha getFichaLogica() {
        return this.fichaLogica;
    }

    @FXML
    public void FichaClick() {
        if (fichaLogica != null) {
            System.out.println("Click en ficha: " + fichaLogica.toString());
        }
    }
}
    

    

