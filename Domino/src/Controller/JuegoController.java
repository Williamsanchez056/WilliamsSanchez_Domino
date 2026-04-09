package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import model.Ficha;
import model.LogicaTablero;
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
    private LogicaTablero logicaTablero;

    @FXML
    public void initialize() {
        mazo = new Mazo();
        jugadorHumano = new Jugador("Williams");
        cpu = new Jugador("Computadora");
        logicaTablero = new LogicaTablero();

        empezarJuego();
    }

    public void comenzarNuevaPartida() {
        System.out.println("Comenzando nueva partida");
        reiniciarPartida();
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
            controller.setJuegoPrincipal(this);
            controller.cargarDatos(fichaLogica);
            contenedorManoJugador.getChildren().add(nodoFicha);

        } catch (IOException e) {
            System.err.println("Error cargando Ficha.fxml: " + e.getMessage());
        }
    }

    public void intentarJugarFicha(FichaController fichaController) {
        Ficha ficha = fichaController.getFichaLogica();
        boolean jugadaValida = false;

        if (logicaTablero.getFichasEnTablero().isEmpty()) {
            jugadaValida = logicaTablero.agregarFicha(ficha, true);
        } else {
            jugadaValida = logicaTablero.agregarFicha(ficha, false);
            if (!jugadaValida) {
                jugadaValida = logicaTablero.agregarFicha(ficha, true);
            }
        }

        if (jugadaValida) {
            jugadorHumano.jugarFicha(ficha);
            contenedorManoJugador.getChildren().remove(fichaController.getNodoFicha());
            mostrarTablero();
            System.out.println("Ficha jugada: " + ficha);
        } else {
            System.out.println("No se puede jugar esa ficha: " + ficha);
        }
    }

    private void mostrarTablero() {
        contenedorTablero.getChildren().clear();
        for (Ficha ficha : logicaTablero.getFichasEnTablero()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha.fxml"));
                Parent nodoFicha = loader.load();
                FichaController controller = loader.getController();
                controller.cargarDatos(ficha);
                nodoFicha.setDisable(true);
                nodoFicha.setOpacity(0.9);
                contenedorTablero.getChildren().add(nodoFicha);
            } catch (IOException e) {
                System.err.println("Error cargando Ficha.fxml para tablero: " + e.getMessage());
            }
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

