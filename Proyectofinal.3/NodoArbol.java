public class NodoArbol {
    private Pelicula pelicula;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
