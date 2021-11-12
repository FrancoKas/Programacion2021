
package logica;
import java.util.ArrayList;
import java.util.Random;
import logica.*;
public class Jugar {
     private Random aleatorio;
    private Mazo cartas;        // Todas las cartas
    private Mazo jugador1;
    private Mazo jugador2;
    private Mazo jugador3;
    private Mazo jugador4;
    

    public Jugar() {
        aleatorio = new Random();
        cartas = new Mazo();
        jugador1 = new Mazo(); // Cartas j1 = 0
        jugador2 = new Mazo(); // Cartas j2 = 0
        jugador3 = new Mazo(); // Cartas j3 = 0
        jugador4 = new Mazo(); // Cartas j4 = 0
        cartas.armarMazo();    // Mazo = 16
    }

    public Mazo getJugador1() {
        return jugador1;
    }
    public Mazo getJugador2() {
        return jugador2;
    }
    public Mazo getJugador3() {
        return jugador3;
    }
    public Mazo getJugador4() {
        return jugador4;
    }
    
//****************************************************************************    
    
    // iniciarJuego: Reparte 4 cartas a cada jugador
    public void iniciarJuego() {
        for (int i = 0; i < 4; i++) {
            jugador1.insertar(cartas.darCarta());
            jugador2.insertar(cartas.darCarta());
            jugador3.insertar(cartas.darCarta());
            jugador4.insertar(cartas.darCarta());
        }
    }      
    
    // Determina si un jugador gano la partida
    public boolean ganador(Mazo jug) {
        boolean gano = true;
        // Obtengo la primer carta del jugador ....
        Carta c = jug.devolver(0);
        // ... la comparo con las otras tres
        for (int i = 1; i < jug.cantidad(); i++) {
            if (c.getNumero() != jug.devolver(i).getNumero()) {
                gano = false; // Si hay una distinta entonces false
            }
        }
        return gano;
    }
    
    
    
     /* pasarCartas: Método para simular una pasada de cartas
     Utiliza el método inteligencia (para determinar carta de maquina)
     jug un jugador
     c la carta que recibe
     i la posicion de carta que devuelve (si es el usuario)
     user si es el usuario o no
     devolver = la carta que devuelve */
    
    public Carta pasarCarta(Mazo jug, Carta c, int i, boolean user) {
        Carta devuelve;
        int azar = aleatorio.nextInt(4);
        if (user == true) {             // Si es el usuario
            devuelve = jug.devolver(i); // carta en la posición 0,1,2 o 3
            jug.eliminar(i);
        } else {                        // Si es la maquina
            devuelve = this.inteligencia(jug,azar);
            jug.eliminar(this.inteligencia(jug,azar));
        }
        jug.insertar(c);                // Se queda con una carta
        return devuelve;                // Devuelve una carta
    }
     /*
      jugarMano: Todos los jugadores pasan y reciben una carta
      i La posición de la carta que pasa el jugador
     */
    
    public void jugarMano(int i){
        Carta c1, c2, c3, c4;               // Indica la carta que pasa        
        c4 = this.inteligencia(jugador4,i);
        // jugador4 -> jugador1
        c1 = this.pasarCarta(jugador1,c4,i,true);
        // jugador1 -> jugador2
        c2 = this.pasarCarta(jugador2,c1,i,false);
        // jugador2 -> jugador3
        c3 = this.pasarCarta(jugador3,c2,i,false);
        // jugador3 -> jugador4
        c4 = this.pasarCarta(jugador4,c3,i,false);
    }
    
    /*
     inteligencia: de la computadora
     Utiliza: contadorNumeroCartas, cartaExacta, tresIguales y pares
     jug un jugador
     la carta que menos le sirve
     */
    public Carta inteligencia(Mazo jug,int azar) {
        Carta auxiliar = new Carta();
        boolean seguir = true;
        int posContador = 0;           // Para posicion del contador    
        int posCarta = 0;              // Para posicion de cartas de j
        // Contador de numero de cartas
        int[] contador = this.contadorNumeroCartas(jug);
        
        // Caso 1: [Tres cartas iguales] o [un par y dos distintas] 
        // Para este caso: tiro la carta con contador[i] == 1
        if (tresIguales(contador) || pares(contador)) {
            // Recorro el contador de cartas
            while (posContador < contador.length && seguir == true) {
                // Obtengo la carta con contador 1
                if (contador[posContador] == 1) {
                    // Recorro las cartas del jugador
                    for (posCarta = 0; posCarta < jug.cantidad(); posCarta++) {
                        // Determino la carta exacta que quiero devolver
                        if (this.cartaExacta(jug,posContador,posCarta) == true)
                            auxiliar = jug.devolver(posCarta);
                    }
                    seguir = false; // Termino el ciclo (obtuve la carta)
                }
                posContador++; // Paso a la siguiente (no obtuve la carta)
            }
        // Fin del Caso 1    
        } else {
            // Caso 2: [Pares iguales] o (por descarte) [todas distintas]
            // Devuelvo una carta al azar
            auxiliar = jug.devolver(azar);
        }
      
        return auxiliar;
    }

    
   
     /*
     contadorNumeroCartas: Cuenta la cantidad de 1, 10, 11 y 12 del jugador
     jug un jugador
     un array con la estadistica del conteo.
     */
    
    int[] contadorNumeroCartas(Mazo jug) {
        int[] contar = new int[4];
        // Recorre la mano del jugador
        for (int i = 0; i < jug.cantidad(); i++) {
            // Obtiene el número de la carta
            switch (jug.devolver(i).getNumero()) {
                case 1:                 // Contador de as (posicion 0)
                    contar[0]++;
                    break;
                case 10:                // Contador de sota (posicion 1)
                    contar[1]++;
                    break;
                case 11:                // Contador de caballo (posicion 2)
                    contar[2]++;
                    break;
                case 12:                // Contador de rey (posicion 3)
                    contar[3]++;
            }
        }
        return contar;
    }   
    
    /*
     cartaExacta: Controlador para devolver la carta exacta
     jug un jugador
     posContador asocia 0 (as), 1 (sota), 2 (caballo), 3 (rey)
     posCarta posición de la carta del jugador
     true si hay relación entre posContador y posCarta
     */
    public boolean cartaExacta(Mazo jug, int posContador, int posCarta) {
        boolean cumple = false;
        // Obtengo el número de la carta en la posición dada
        int numeroCarta = jug.devolver(posCarta).getNumero();
        switch (posContador) {
            case 0:     // Posición 0 se asocia al as (1)
                if (numeroCarta == 1)
                    cumple = true;
                break;
            case 1:     // Posición 1 se asocia a la sota (10)
                if (numeroCarta == 10)
                    cumple = true;
                break;
            case 2:     // Posición 2 se asocia al caballo (11)
                if (numeroCarta == 11)
                    cumple = true;
                break;
            case 3:     // Posición 3 se asocia al rey (12)
                if (numeroCarta == 12)
                    cumple = true;
                break;     
        }
      
        return cumple;
    }
    
    
    /*
     Determina si hay tres cartas iguales
     contador el contador de cartas
     true si las celdas estan de la forma [0][1][3][0]
     */
    
    public boolean tresIguales(int[] contador) {
        boolean hayTres = false;
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] == 3) {
                hayTres = true; // Si hay tres iguales entonces true
            }
        }
        return hayTres;
    }
    
    /*
     pares: Determina si [dos pares iguales] o [un par y dos distintas]
     pre-condición: Comprobar antes que no hay tres cartas iguales
     contador el contador de cartas
     true si hay un par igual y dos cartas distintas
     */
    
    public boolean pares(int[] contador) {
        boolean pares = false;
       
        int contarCeros = 0;
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] == 0) {
                contarCeros++;
            }
        }
        // Si no hay dos ceros en el contador [0][1][2][1]
        if (contarCeros != 2)  
            pares = true;
        // Caso contrario -> [0] [2] [2] [0] (dos pares iguales)
        return pares;
    }
    
     public String añadirLetra(int a){
        String letra = null;
        if (a==1) {
            letra = "B";
        }
        if (a==2) {
            letra = "Bu";
        }
        if (a==3) {
            letra = "Bur";
        }
        if (a==4) {
            letra = "Burr";
        }
        if (a==5) {
            letra = "Burro";
        }
      return letra;
    }
     
     public void actualizar(){
         jugador1.devolver(0);
         jugador1.devolver(1);
         jugador1.devolver(2);
         jugador1.devolver(3);
     }
     
//*****************************************************************************
    @Override
    public String toString() {
        return "\n\n\nNueva jugada: "
                + "\njugador1: " + jugador1
                + "\njugador2: " + jugador2
                + "\njugador3: " + jugador3
                + "\njugador4: " + jugador4;
    }
//*****************************************************************************    
} // "Fin del Burro"