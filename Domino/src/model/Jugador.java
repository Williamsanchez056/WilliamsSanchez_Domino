package model;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Ficha> mano;
    private int puntuacion;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.puntuacion = 0;
    }

    public void agregarFicha(Ficha ficha){
        mano.add(ficha);
    }

    public void jugarFicha(Ficha ficha){
        mano.remove(ficha);
    }
    public boolean tieneFicha(int extremoIzquierdo, int extremoDerecho) {
        for (Ficha f : mano) {
            if (f.puedeConectarCon(extremoIzquierdo) || f.puedeConectarCon(extremoDerecho)) {
                return true;
            }
        }
        return false;
    }
    public String getNombre() {
        return nombre;
    }
    public List<Ficha> getMano() {
        return mano;
    }
    public int getPuntuacion() {
        return puntuacion;
    }
    public void sumarPuntos(int puntos) {
        puntuacion += puntos;
    }

    public int calcularPuntosEnMano() {
        int total = 0;
        for (Ficha f : mano) {
            total += f.getPuntuacion();
        }
        return total;
    }
}
