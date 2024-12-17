public class Grafo {
    private NodoGrafo primero; 
    private NodoGrafo ultimo; 
    // Constructor para inicializar un grafo vacío
    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    } // Crea una nueva instancia del grafo
    // Metodo para verificar si el grafo está vacío
    public boolean estaVacio() {
        return this.primero == null && this.ultimo == null;
    }
    // metodo que verifica si un nodo con el dato especificado ya existe en el grafo
public boolean existeVertice(Object dato) {
    if (estaVacio()) {
        System.out.println("El grafo está vacío.");
        return false;
    }
    NodoGrafo actual = primero;
    while (actual != null) {
        if (actual.getDato().toString().trim().equalsIgnoreCase(dato.toString().trim())) {
            return true;
        }
        actual = actual.getSiguiente();
    }
    System.out.println("No se encontró el vértice: " + dato);
    return false;
}




    // Metodo para agregar una arista sin peso entre dos nodos si ambos existen
    public boolean agregarArista(Object origen, Object destino) {
    System.out.println("Intentando agregar arista entre: " + origen + " y " + destino);

    if (!existeVertice(origen) || !existeVertice(destino)) {
        System.out.println("Error: Una o ambas películas no existen.");
        return false;
    }

    NodoGrafo actual = primero;
    while (!actual.getDato().toString().trim().equalsIgnoreCase(origen.toString().trim())) {
        actual = actual.getSiguiente();
    }
    actual.getListaAdyacencia().agregarAdyacencia(destino);
    System.out.println("Arista agregada con éxito.");
    return true;
    }


    // Metodo para agregar una arista con peso entre dos nodos si ambos existen
    public boolean agregarArista(Object origen, Object destino, float peso) {
        if (!existeVertice(origen) || !existeVertice(destino))
            return false;
        NodoGrafo actual = primero;
        while (!actual.getDato().toString().equals(origen.toString())) {
            actual = actual.getSiguiente();
        }
        actual.getListaAdyacencia().agregarAdyacencia(destino, peso);
        return true;
    }
    // Metodo para agregar un nuevo nodo al grafo si no existe previamente
public boolean agregarNodo(Object dato) {
    if (existeVertice(dato)) {
        return false; // No agregar si el nodo ya existe
    }
    NodoGrafo nodo = new NodoGrafo(dato);
    if (estaVacio()) {
        this.primero = nodo;
        this.ultimo = nodo;
    } else {
        this.ultimo.setSiguiente(nodo); // Agregar al final de la lista
        this.ultimo = nodo;
    }
    return true;
}

    // Metodo que devuelve una representación del grafo.
    @Override
    public String toString() {
        String cadena = "";
        NodoGrafo actual = primero;
        while (actual != null) {
            cadena += actual.getDato().toString() + "->" + actual.getListaAdyacencia().toString() + "\n";
            actual = actual.getSiguiente();
        }
        return cadena;
    }
}
