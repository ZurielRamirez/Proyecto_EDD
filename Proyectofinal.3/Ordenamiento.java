import java.util.List;

public class Ordenamiento {

    public static void quicksortPorDirector(List<Pelicula> peliculas) {
        quick(peliculas, 0, peliculas.size() - 1);
    }

    private static void quick(List<Pelicula> peliculas, int posI, int posD) {
        if (posI < posD) {
            int index = sort(peliculas, posI, posD);
            quick(peliculas, posI, index - 1);
            quick(peliculas, index, posD);
        }
    }

    private static int sort(List<Pelicula> peliculas, int posI, int posD) {
        String pivote = peliculas.get((posI + posD) / 2).getDirector();
        while (posI <= posD) {
            while (peliculas.get(posI).getDirector().compareTo(pivote) < 0)
                posI++;
            while (peliculas.get(posD).getDirector().compareTo(pivote) > 0)
                posD--;
            if (posI <= posD) {
                Pelicula aux = peliculas.get(posI);
                peliculas.set(posI, peliculas.get(posD));
                peliculas.set(posD, aux);
                posI++;
                posD--;
            }
        }
        return posI;
    }

    public static int binarySearchPorDirector(List<Pelicula> peliculas, String director) {
        int inicio = 0;
        int fin = peliculas.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (peliculas.get(medio).getDirector().equals(director)) {
                return medio;
            } else if (peliculas.get(medio).getDirector().compareTo(director) < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
}



