package logica;
public class Carta {
    private int numero;
    private String palo;

    public Carta() {
    }

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getPalo() {
        return palo;
    }
    public void setPalo(String palo) {
        this.palo = palo;
    }
    @Override
    public String toString() {  // Ruta de la imagen
        return "img/" + palo + "/" + numero + ".png";           // En linux
        // return "img\\" + palo + "\\" + numero + ".png";      // En Windows
    }
}