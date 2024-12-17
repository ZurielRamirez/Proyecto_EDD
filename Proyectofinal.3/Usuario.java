import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Pelicula> peliculaPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.peliculaPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getpeliculaPrestados() {
        return peliculaPrestados;
    }

    public void prestarPelicula(Pelicula Pelicula) {
        peliculaPrestados.add(Pelicula);
    }

    public boolean devolverPelicula(Pelicula Pelicula) {
        return peliculaPrestados.remove(Pelicula);
    }
}