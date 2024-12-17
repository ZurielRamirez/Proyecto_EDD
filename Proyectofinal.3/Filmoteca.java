import java.util.*;

public class Filmoteca {
    private List<Pelicula> peliculas;
    private ArbolBinario arbolPeliculas;
    private Cola apartados;
    private Pila prestamos;
    private Pila busquedasRecientes;
    private ListaEnlazada eliminar;
    private ListaEnlazada agregar;

    public Filmoteca(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
        this.arbolPeliculas = new ArbolBinario();
        this.apartados = new Cola();
        this.prestamos = new Pila();
        this.busquedasRecientes = new Pila();
        this.eliminar=eliminar;
        this.agregar=agregar;
        
        for (Pelicula pelicula : peliculas) {
            this.arbolPeliculas.insertar(pelicula);
        }
    }
    
    
    public boolean contiene(Pelicula pelicula) {
    for (Pelicula p : peliculas) {
        // Comparar los atributos de las películas
        if (p.getTitulo().equalsIgnoreCase(pelicula.getTitulo()) &&
            p.getDirector().equalsIgnoreCase(pelicula.getDirector()) &&
            p.getGenero().equalsIgnoreCase(pelicula.getGenero()) &&
            p.getAñoEstreno() == pelicula.getAñoEstreno() &&
            p.getDuracion() == pelicula.getDuracion()) {
            return true;
        }
    }
    return false;
}

    public void apartarPelicula(Pelicula pelicula) {  //Cola
        apartados.insert(pelicula);
    }

public String atenderApartado() throws Exception {
    if (!apartados.estaVacia()) {
        Pelicula peliculaAtendida = apartados.frente(); // Obtener la película al frente
        apartados.delete(); // Eliminarla de la cola
        return peliculaAtendida.getTitulo();
    } else {
        throw new Exception("No hay apartados para atender");
    }
}


    public void prestarPelicula(Pelicula pelicula) {  // pila
        prestamos.push(pelicula);
    }

    public void devolverPelicula() {  //pila
        try {
            prestamos.pop();
        } catch (Exception e) {
            System.out.println("No hay Peliculas para devolver");
        }
    }

    public void agregarBusquedaReciente(Pelicula pelicula) {  // pila
        busquedasRecientes.push(pelicula);
    }

    public Pelicula obtenerUltimaBusqueda() throws Exception {
        return busquedasRecientes.pop(); //pila
    }

    public void ordenarPeliculasPorDirector() {  //quicksort
        Ordenamiento.quicksortPorDirector(peliculas);  
    }

    public int buscarPeliculaPorDirector(String director) {
        return Ordenamiento.binarySearchPorDirector(peliculas, director);  
    }

    public Pelicula buscarPeliculaEnArbol(String director) { //arbol
        return arbolPeliculas.buscar(director); 
    }
    
    public Pelicula buscarPeliculaPorDetalles(String director, String titulo, String genero, int año, int duracion) {
    for (Pelicula pelicula : peliculas) {
        if (pelicula.getDirector().equals(director) && 
            pelicula.getTitulo().equals(titulo) && 
            pelicula.getGenero().equals(genero) && 
            pelicula.getAñoEstreno() == año && 
            pelicula.getDuracion() == duracion) {
            return pelicula;
        }
    }
    return null; 
}
public void devolverPelicula(Pelicula peliculaDevolver) {
    Pila temporal = new Pila(); 
    boolean encontrada = false;
    
try {
    while (!prestamos.estaVacia()) { 
        Pelicula pelicula = prestamos.pop(); 
        if (pelicula.equals(peliculaDevolver)) {
            encontrada = true; 
            break; 
        } else {
            temporal.push(pelicula); 

        }
    }

    while (!temporal.estaVacia()) { 
        prestamos.push(temporal.pop());
    }
} catch (Exception e) {
    System.out.println("Error al procesar las pilas: " + e.getMessage());
}

    // Mensaje al usuario
    if (encontrada) {
        System.out.println("La película \"" + peliculaDevolver.getTitulo() + "\" ha sido devuelta.");
    } else {
        System.out.println("La película no se encontró en los préstamos.");
    }

}
}

