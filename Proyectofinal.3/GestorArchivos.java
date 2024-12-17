import java.io.*;
import java.util.*;

public class GestorArchivos {
    public static List<Pelicula> leerpeliculaDesdeArchivo(String ruta) {
        List<Pelicula> peliculas = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(ruta))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String director = datos[0];
                    String titulo = datos[1];
                    String genero = datos[2];
                    int año = Integer.parseInt(datos[3]);
                    int duracion = Integer.parseInt(datos[4]);
                    
                    Pelicula pelicula = new Pelicula(director, titulo, genero, año, duracion);
                    peliculas.add(pelicula);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + ruta);
        }
        return peliculas;
    }
}


