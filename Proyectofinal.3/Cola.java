public class Cola {
    private Nodo frente;
    private Nodo ultimo;
    private int size;

    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean insert(Pelicula pelicula) { 
        Nodo nuevo = new Nodo(pelicula);
        if (this.frente == null && this.ultimo == null) {
            this.frente = nuevo;
            this.ultimo = nuevo;
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
        }
        this.size++;
        return true;
    }

    public boolean delete() {
        if (this.frente == null) {
            return false;
        }
        Nodo aux = this.frente;
        this.frente = this.frente.getSiguiente();
        if (this.frente == null) {
            this.ultimo = null;
        }
        this.size--;
        return true;
    }

    public Pelicula frente() { 
        if (this.frente == null) {
            throw new IllegalStateException("La cola está vacía");
        }
        return this.frente.getPelicula();
    }
public boolean estaVacia() {
    return this.frente == null;
}

    public int size() {
        return this.size;
    }
}




