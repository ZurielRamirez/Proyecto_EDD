public class NodoGrafo {
    private Object dato;         
    private Lista listaAdyacencia; 
    private NodoGrafo siguiente;   

    // Constructor para inicializar un nodo con su dato
    public NodoGrafo(Object dato) {
        this.dato = dato;
        this.listaAdyacencia = new Lista();
        this.siguiente = null;
    }

    // Métodos getter y setter para manejar los atributos de la clase nodo
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Lista getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void setListaAdyacencia(Lista listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
}
