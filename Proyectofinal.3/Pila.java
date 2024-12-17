public class Pila {
    private Nodo tope;
    private int size;

    public Pila() {
        this.size = 0;
        this.tope = null;
    }

    // Agregar un nodo a la pila
    public boolean push(Pelicula pelicula) {
        this.size++;
        Nodo nodo = new Nodo(pelicula);
        if (this.tope == null) {
            this.tope = nodo;
        } else {
            nodo.setSiguiente(this.tope);
            this.tope = nodo;
        }
        return true;
    }

    // Verificar si la pila está vacía
    public boolean estaVacia() {
        return this.tope == null;
    }

    // Quitar el nodo del tope y retornar  película
    public Pelicula pop() throws Exception {
        if (this.estaVacia()) {
            throw new Exception("Pila Vacia");
        }
        Nodo aux = this.tope;
        this.tope = this.tope.getSiguiente();
        this.size--;
        return aux.getPelicula();
    }

    // Obtener el tamaño actual de la pila
    public int getSize() {
        return this.size;
    }

    // Obtener la película en el tope sin eliminarla
    public Pelicula peek() throws Exception {
        if (this.estaVacia()) {
            throw new Exception("Pila Vacia");
        }
        return this.tope.getPelicula();
    }
}



