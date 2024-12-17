public class Nodo {
    private Pelicula pelicula;  // Almacena un objeto Pelicula
    private Nodo siguiente;     // Referencia al siguiente Nodo

    public Nodo(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.siguiente = null;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}


