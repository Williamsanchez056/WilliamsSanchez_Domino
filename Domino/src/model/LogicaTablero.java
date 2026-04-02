package model;

import java.util.LinkedList;

public class LogicaTablero {
    private LinkedList<Ficha> fichasEnTablero;

    public LogicaTablero() {
        this.fichasEnTablero = new LinkedList<>();
    }

    public boolean agregarFicha(Ficha ficha, boolean alInicio) {
        if (fichasEnTablero.isEmpty()) {
            fichasEnTablero.add(ficha);
            return true;
        }

        if (alInicio) {
            // Miramos el lado A de la primera ficha del tablero
            int extremoIzquierdo = fichasEnTablero.getFirst().getLadoA();
            
            // Si el lado B de mi ficha nueva pega con el extremo
            if (ficha.getLadoB() == extremoIzquierdo) {
                fichasEnTablero.addFirst(ficha);
                return true;
            } 
            // Si el lado A de mi ficha nueva pega, hay que "voltearla"
            else if (ficha.getLadoA() == extremoIzquierdo) {
                Ficha volteada = new Ficha(ficha.getLadoB(), ficha.getLadoA());
                fichasEnTablero.addFirst(volteada);
                return true;
            }
        } else {
            // Miramos el lado B de la última ficha del tablero
            int extremoDerecho = fichasEnTablero.getLast().getLadoB();
            
            if (ficha.getLadoA() == extremoDerecho) {
                fichasEnTablero.addLast(ficha);
                return true;
            } 
            else if (ficha.getLadoB() == extremoDerecho) {
                Ficha volteada = new Ficha(ficha.getLadoB(), ficha.getLadoA());
                fichasEnTablero.addLast(volteada);
                return true;
            }
        }

        return false;
    }
}


