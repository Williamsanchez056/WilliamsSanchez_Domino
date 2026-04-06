package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import model.Ficha;
import model.Mazo;
import model.Jugador;
import java.io.IOException;
import java.util.List;

public class JuegoController {

    @FXML
    private HBox contenedorManoJugador; 

    @FXML
    private HBox contenedorTablero; 

    private Mazo mazo;
    private Jugador jugadorHumano;
    private Jugador cpu;

    @FXML
    public void initialize() {
        mazo = new Mazo();
        jugadorHumano = new Jugador("Williams");
        cpu = new Jugador("Computadora");

        empezarJuego();
    }
    public void comenzarNuevaPartida() {
    System.out.println("Comenzando nueva partida");
    empezarJuego(); 
}
    private void empezarJuego() {
        List<Ficha> manoInicial = mazo.repartir(7);
        for (Ficha f : manoInicial) {
            jugadorHumano.agregarFicha(f);
            mostrarFichaEnPantalla(f);
        }
    }

    private void mostrarFichaEnPantalla(Ficha fichaLogica) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha.fxml"));
            Parent nodoFicha = loader.load();


            FichaController controller = loader.getController();
            controller.cargarDatos(fichaLogica);
            contenedorManoJugador.getChildren().add(nodoFicha);

        } catch (IOException e) {
            System.err.println("Error cargando Ficha.fxml: " + e.getMessage());
        }
    }

    @FXML
    private void reiniciarPartida() {
        contenedorManoJugador.getChildren().clear();
        contenedorTablero.getChildren().clear();
        initialize();
        System.out.println("Reiniciando juego");
    }
}

