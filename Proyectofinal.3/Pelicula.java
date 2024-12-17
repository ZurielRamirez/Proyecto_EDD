public class Pelicula {
    private String director;
    private String titulo;
    private String genero;
    private int año;
    private int duracion;

    public Pelicula(String director, String titulo, String genero, int año, int duracion) {
        this.director = director;
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
        this.duracion = duracion;
    }

    public String getDirector() { 
        return director; 
    }
    public String getTitulo() {
        return titulo; 
    }
    public String getGenero() { 
        return genero; 
    }
    public int getAñoEstreno() { 
        return año; 
    }
    public int getDuracion() { 
        return duracion; 
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Director: " + director + ", Título: " + titulo + ", Género: " + genero + 
               ", Año: " + año + ", Duración: " + duracion + " minutos";
    }
    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pelicula pelicula = (Pelicula) obj;
    return año == pelicula.año &&
           duracion == pelicula.duracion &&
           director.equals(pelicula.director) &&
           titulo.equals(pelicula.titulo) &&
           genero.equals(pelicula.genero);
}
}
