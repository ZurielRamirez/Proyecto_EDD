public class Arista { 
    private Object destino; 
    private float peso;   
    private Arista siguiente; 

    // Este constructor es para un arista sin peso =0
    public Arista(Object destino) {
        this.destino = destino;
        this.siguiente = null;
    }

    // Este constructor es para un arista con un peso especificadp
    public Arista(Object destino, float peso) {
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;
    }
    
    // Métodos getter y setter para manejar los atributos de la clase arista
    public Object getDestino() {
        return destino;
    }

    public void setDestino(Object destino) {
        this.destino = destino;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Arista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }
}
