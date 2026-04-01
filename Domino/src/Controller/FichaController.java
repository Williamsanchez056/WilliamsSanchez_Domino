package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Ficha;

public class FichaController {
    @FXML
    private VBox contenedorFichas;

    @FXML
    private Label labelSuperior;

    @FXML
    private Label labelInferior;

    @FXML
    private Ficha fichaLogica;

    public void cargarDatos(Ficha ficha){
        this.fichaLogica = ficha;

        labelSuperior.setText(String.valueOf(ficha.getLadoA()));
        labelInferior.setText(String.valueOf(ficha.getLadoB()));
    }

    public Ficha getFichaLogica(){
        return this.fichaLogica;
    }

    @FXML
    public void FichaClick(){
        System.out.println("Click en ficha: " + fichaLogica.toString());
    }


}

    

    

    

