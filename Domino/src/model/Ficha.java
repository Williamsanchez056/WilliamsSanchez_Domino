package model;
public class Ficha {
    private final int ladoA;
    private final int ladoB;
    private int valor1;
    private int valor2;
    private boolean visitada; 

    public Ficha(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.valor1 = ladoA;
        this.valor2 = ladoB;
        this.visitada = false;

    }
    public int getLadoA() {
        return ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public int getValor1() {
        return valor1;
    }

    public int getValor2() {
        return valor2;
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


