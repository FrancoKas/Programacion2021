package logica;
import java.util.Random;
import java.util.ArrayList;
public class Mazo {
    private ArrayList<Carta> baraja;
    private Random aleatorio;
    
    public Mazo() {
        aleatorio = new Random();
        baraja = new ArrayList<>();
    }
    /** Métodos primitivos **/
    public void insertar(Carta c) {
        baraja.add(c);
    }
    public void eliminar(int i) {
        baraja.remove(i);
    }
    public void eliminar(Carta c) {
        baraja.remove(c);
    }
    public int cantidad() {
        return baraja.size();
    }
    public boolean sinCartas(){
        return baraja.isEmpty();
    }
    public boolean encuentra(Carta c){
        return baraja.contains(c);
    }
    public Carta devolver(int i) {
        return baraja.get(i);
    }
    /** Fin de métodos primitivos **/
/********************************************************************/     
    public void armarMazo() {
        int numero = 1;
        String palo = "basto";
        Carta carta;
        
        for (int i = 0; i < 16; i++) {
            if (numero == 2)
                numero = 10;
            carta = new Carta(numero,palo);
            this.insertar(carta);                        
            numero++; 
            // Si ya cargue 12 cartas de un palo ...
            if (numero == 13) {
                numero = 1;
                // ... paso al siguiente palo
                if(palo.equals("basto"))
                    palo = "copa";
                else if (palo.equals("copa"))
                    palo = "espada";
                else
                    palo = "oro";
            } // fin de if (numero == 13)
        } // fin de for
    }
    
/********************************************************************/           
    public Carta darCarta() {
        int i = aleatorio.nextInt(baraja.size());
        Carta c = baraja.get(i);
        baraja.remove(i);
        return c;
    }
/********************************************************************/
    @Override
    public String toString() {
        return "\n" +baraja.get(0).getNumero()+" de "+baraja.get(0).getPalo()
               +", "+baraja.get(1).getNumero()+" de "+baraja.get(1).getPalo()
               +", "+baraja.get(2).getNumero()+" de "+baraja.get(2).getPalo()
               +", "+baraja.get(3).getNumero()+" de "+baraja.get(3).getPalo();
    }
} // Fin de Mazo