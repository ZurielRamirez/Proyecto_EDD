public class ListaEnlazada {
    private Nodo cabeza;
    private int size;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }
    public void agregar(Pelicula pelicula) { 
        Nodo nuevoNodo = new Nodo(pelicula);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
        size++;
    }

    public boolean eliminar(Pelicula pelicula) {  
        if (cabeza == null) {
            return false;
        }

        if (cabeza.getPelicula().equals(pelicula)) {
            cabeza = cabeza.getSiguiente();
            size--;
            return true;
        }

        Nodo temp = cabeza;
        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getPelicula().equals(pelicula)) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                size--;
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public boolean contiene(Pelicula pelicula) {  
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getPelicula().equals(pelicula)) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public int size() {
        return size;
    }
}



