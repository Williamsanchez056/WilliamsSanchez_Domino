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

    private JuegoController juegoPrincipal;

    public void setJuegoPrincipal(JuegoController juegoPrincipal){
        this.juegoPrincipal = juegoPrincipal;
    }

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

    public VBox getNodoFicha() {
        return contenedorFicha;
    }

    @FXML
    public void onFichaClicked() {
        if (juegoPrincipal != null && fichaLogica != null) {
            juegoPrincipal.intentarJugarFicha(this);
        }
    }
}
    

    

