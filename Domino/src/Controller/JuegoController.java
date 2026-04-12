package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Ficha;
import model.LogicaTablero;
import model.Mazo;
import model.Jugador;
import java.io.IOException;
import javafx.scene.control.Label;
import java.util.List;

public class JuegoController {

    @FXML
    private VBox vboxJugador1;

    @FXML
    private VBox vboxJugador2;

    @FXML
    private HBox contenedorManoJugador;

    @FXML
    private HBox contenedorManoJugador2;

    @FXML
    private HBox contenedorTablero;

    @FXML
    private Label lblCantidadPozo;

    private boolean esTurnoJugador1 = true;

    private Mazo mazo;
    private Jugador jugadorHumano;
    private Jugador jugador2;
    private LogicaTablero logicaTablero;

    @FXML
    public void initialize() {
        mazo = new Mazo();
        jugadorHumano = new Jugador("Williams");
        jugador2 = new Jugador("Jugador 2");
        logicaTablero = new LogicaTablero();

        empezarJuego();
        actualizarCantidadPozo();
        aplicarEstadoTurno();
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

        List<Ficha> manoOponente = mazo.repartir(7);
        for (Ficha f : manoOponente) {
            jugador2.agregarFicha(f);
            mostrarFichaEnPantallaJugador2(f);
        }
    }

    private void mostrarFichaEnPantalla(Ficha fichaLogica) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha.fxml"));
            Parent nodoFicha = loader.load();

            FichaController controller = loader.getController();
            controller.setJuegoPrincipal(this);
            controller.cargarDatos(fichaLogica);
            nodoFicha.setUserData(controller);
            contenedorManoJugador.getChildren().add(nodoFicha);

        } catch (IOException e) {
            System.err.println("Error cargando Ficha.fxml: " + e.getMessage());
        }
    }

    private void mostrarFichaEnPantallaJugador2(Ficha fichaLogica) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha.fxml"));
            Parent nodoFicha = loader.load();

            FichaController controller = loader.getController();
            controller.setJuegoPrincipal(this);
            controller.cargarDatos(fichaLogica);
            nodoFicha.setUserData(controller);
            contenedorManoJugador2.getChildren().add(nodoFicha);

        } catch (IOException e) {
            System.err.println("Error cargando Ficha.fxml para Jugador 2: " + e.getMessage());
        }
    }


    public void intentarJugarFicha(FichaController fichaController) {
        Ficha ficha = fichaController.getFichaLogica();
        boolean esFichaJugador1 = contenedorManoJugador.getChildren().contains(fichaController.getNodoFicha());
        boolean esFichaJugador2 = contenedorManoJugador2.getChildren().contains(fichaController.getNodoFicha());

        if (esTurnoJugador1 && !esFichaJugador1) {
            System.out.println("No es turno de Jugador 2.");
            return;
        }
        if (!esTurnoJugador1 && !esFichaJugador2) {
            System.out.println("No es turno de Williams.");
            return;
        }

        Jugador jugadorActual = esTurnoJugador1 ? jugadorHumano : jugador2;
        HBox contenedorActual = esTurnoJugador1 ? contenedorManoJugador : contenedorManoJugador2;

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
            jugadorActual.jugarFicha(ficha);
            contenedorActual.getChildren().remove(fichaController.getNodoFicha());
            mostrarTablero();
            System.out.println("Ficha jugada: " + ficha + " por " + jugadorActual.getNombre());

            cambiarTurno();
            aplicarEstadoTurno();
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
        esTurnoJugador1 = true;
        contenedorManoJugador.getChildren().clear();
        contenedorManoJugador2.getChildren().clear();
        contenedorTablero.getChildren().clear();
        initialize();
        System.out.println("Reiniciando juego");
    }

    @FXML
    public void tomarDelPozo(){
        Ficha nuevaFicha = mazo.sacarFichaDelpozo();
        if (nuevaFicha != null){
            jugadorHumano.agregarFicha(nuevaFicha);
            mostrarFichaEnPantalla(nuevaFicha);
            actualizarCantidadPozo();
        } else {
            System.out.println("No quedan fichas en el pozo.");
        }
    }
    private void actualizarCantidadPozo() {
        int cantidadRestante = mazo.getCantidadFichasRestantes();
        lblCantidadPozo.setText(String.valueOf(cantidadRestante));
    }

    private void aplicarEstadoTurno() {
        contenedorManoJugador.setDisable(!esTurnoJugador1);
        contenedorManoJugador2.setDisable(esTurnoJugador1);
        if (esTurnoJugador1) {
            System.out.println("Turno de Williams.");
        } else {
            System.out.println("Turno del Jugador 2.");
        }
    }

    public void cambiarTurno() {
        esTurnoJugador1 = !esTurnoJugador1;
    }
}

