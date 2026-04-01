package model;
public class Ficha {
    private final int ladoA;
    private final int ladoB;
    private boolean visitada; 

    public Ficha(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.visitada = false;
    }
    public int getLadoA() {
        return ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public boolean esDoble() {
        return ladoA == ladoB;
    }

    public int getPuntuacion() {
        return ladoA + ladoB;
    }

    public boolean puedeConectarCon(int valor) {
        return ladoA == valor || ladoB == valor;
    }
    @Override
    public String toString() {
        return "[" + ladoA + "|" + ladoB + "]";
    }
}


