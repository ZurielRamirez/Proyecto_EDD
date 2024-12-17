public class Lista {
    private Arista primero; 
    private Arista ultimo; 
    //El constructor para inicializar una lista vacía
    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }
    // Verifica si la lista  está vacía
    public boolean estaVacia() {
        return this.primero == null && this.ultimo == null;
    }
    // Agrega una arista sin peso en caso de que no exista previamente
    public void agregarAdyacencia(Object destino) {
        if (!existe(destino)) {
            Arista nodo = new Arista(destino);
            inserta(nodo);
        }
    }
    // Agrega una arista con peso en caso de que no exista previamente
    public void agregarAdyacencia(Object destino, float peso) {
        if (!existe(destino)) {
            Arista nodo = new Arista(destino, peso);
            inserta(nodo);
        }
    }
    // Metodo para insertar una nueva arista en la lista
    private boolean inserta(Arista nodo) {
        if (estaVacia()) {
            this.primero = nodo;
            this.ultimo = nodo;
            return true;
        }
        this.ultimo.setSiguiente(nodo); //Aqui agrega al final de la lista.
        this.ultimo = nodo;
        return true;
    }
    // Metodo que verifica si una arista con el destino  ya existe
    private boolean existe(Object destino) {
        Arista actual = primero;
        while (actual != null) {
            if (destino.toString().equals(actual.getDestino().toString()))
                return true;
            actual = actual.getSiguiente();
        }
        return false;
    }
    // Metodo que devuelve una representación de los destinos en la lista
    @Override
    public String toString() {
        String cadena = "";
        Arista actual = primero;
        while (actual != null) {
            cadena += actual.getDestino().toString() + ";";
            actual = actual.getSiguiente();
        }
        return cadena;
    }
}
