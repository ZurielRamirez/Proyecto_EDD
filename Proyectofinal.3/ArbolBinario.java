public class ArbolBinario {
    private NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(Pelicula pelicula) {
        this.raiz = insertarRecursivo(this.raiz, pelicula);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Pelicula pelicula) {
        if (nodo == null) {
            return new NodoArbol(pelicula);
        }
        if (pelicula.getDirector().compareTo(nodo.getPelicula().getDirector()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), pelicula));
        } else if (pelicula.getDirector().compareTo(nodo.getPelicula().getDirector()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), pelicula));
        }
        return nodo;
    }

    public Pelicula buscar(String director) {
        return buscarRecursivo(raiz, director);
    }

    private Pelicula buscarRecursivo(NodoArbol nodo, String director) {
        if (nodo == null) {
            return null;
        }
        if (director.equals(nodo.getPelicula().getDirector())) {
            return nodo.getPelicula();
        }
        if (director.compareTo(nodo.getPelicula().getDirector()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), director);
        } else {
            return buscarRecursivo(nodo.getDerecho(), director);
        }
    }
}

