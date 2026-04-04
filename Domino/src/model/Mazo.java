package model;
import java.util.ArrayList;
import java.util.List;

public class Mazo {
    private List<Ficha> fichas;

    public Mazo(){
        this.fichas = new ArrayList<>();
        generarFichas();
        barajar();
    }

    private void generarFichas() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }
        }
    }
    public void barajar() {
        java.util.Collections.shuffle(fichas);
    }
    public List<Ficha> repartir(int cantidad) {
        List<Ficha> mano = new ArrayList<>();
        for (int i = 0; i < cantidad && !fichas.isEmpty(); i++) {
            mano.add(fichas.remove(0));
        }
        return mano;
    }
    public Ficha robar(){
        if (!fichas.isEmpty()) {
            return fichas.remove(0);
        }
        return null;
    }


    

    
}
