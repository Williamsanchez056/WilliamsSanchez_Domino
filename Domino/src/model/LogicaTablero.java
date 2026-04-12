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
            int extremoIzquierdo = fichasEnTablero.getFirst().getLadoA();
            
            if (ficha.getLadoA() == extremoIzquierdo) {
                fichasEnTablero.addFirst(ficha);
                return true;
            } 
            else if (ficha.getLadoB() == extremoIzquierdo) {
                Ficha volteada = new Ficha(ficha.getLadoB(), ficha.getLadoA());
                fichasEnTablero.addFirst(volteada);
                return true;
            }
        } else {
            int extremoDerecho = fichasEnTablero.getLast().getLadoB();
            
            if (ficha.getLadoB() == extremoDerecho) {
                fichasEnTablero.addLast(ficha);
                return true;
            } 
            else if (ficha.getLadoA() == extremoDerecho) {
                Ficha volteada = new Ficha(ficha.getLadoB(), ficha.getLadoA());
                fichasEnTablero.addLast(volteada);
                return true;
            }
        }
        return false;
    }

    public java.util.List<Ficha> getFichasEnTablero() {
        return java.util.Collections.unmodifiableList(fichasEnTablero);
    }
}


