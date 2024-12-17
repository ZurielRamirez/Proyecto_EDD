import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Menu {

    public static void main(String[] args) {
        String rutaArchivo = "catalogoPeliculas.csv";  // El archivo que contiene las películas
        List<Pelicula> peliculas = GestorArchivos.leerpeliculaDesdeArchivo(rutaArchivo);  // Leer películas desde el archivo
        Grafo grafoPeliculas = new Grafo();
        ListaEnlazada listaEnlazada = new ListaEnlazada();
        Grafo grafo = new Grafo();
         try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Leer la primera línea y no procesarla

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0].trim(); // Obtener el título de la película

                // Agregar la película como un nodo en el grafo
                boolean agregado = grafo.agregarNodo(titulo);
                if (agregado) {
                    System.out.println("Película agregada: " + titulo);
                } else {
                    System.out.println("La película '" + titulo + "' ya existe en el grafo.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        for (Pelicula pelicula : peliculas) {
            grafoPeliculas.agregarNodo(pelicula);
        }

        for (Pelicula pelicula : peliculas) {
            listaEnlazada.agregar(pelicula);
        }
        System.out.println("Películas cargadas:");
            for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
        Scanner scanner = new Scanner(System.in); 

        // Crear la filmoteca
        Filmoteca filmoteca = new Filmoteca(peliculas);
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Buscar película (pelicula)");
            System.out.println("2. Prestar película (pila)");
            System.out.println("3. Devolver película (pila)");
            System.out.println("4. Apartar película (cola)");
            System.out.println("5. Atender apartado (cola)");
            System.out.println("6. Mostrar películas ordenadas por director (quicksor)");
            System.out.println("8. Verificar si esta la pelicula enlazada");
            System.out.println("9. Agregar relación entre películas en el (grafo)");
            System.out.println("10.Mostrar conexiones del (grafo)");
            System.out.println("11.Buscar película por director (árboles)"); 
            System.out.println("12.Agregar una cancion a la lista enlazada");
            System.out.println("13.Eliminar una cancion de la lista enlazada");
            System.out.println("14. Salir");

            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // Buscar una película
                    System.out.println("Introduce los atributos de la película a buscar:");
                    System.out.print("Director: ");
                    String directorBuscar = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloBuscar = sc.nextLine();
                    System.out.print("Género: ");
                    String generoBuscar = sc.nextLine();
                    System.out.print("Año de estreno: ");
                    int añoBuscar = sc.nextInt();
                    System.out.print("Duración (en minutos): ");
                    int duracionBuscar = sc.nextInt();
                    sc.nextLine(); 

                    Pelicula peliculaEncontrada = filmoteca.buscarPeliculaPorDetalles(directorBuscar, tituloBuscar, generoBuscar, añoBuscar, duracionBuscar);
                    if (peliculaEncontrada != null) {
                        System.out.println("Película encontrada: " + peliculaEncontrada);
                    } else {
                        System.out.println("Película no encontrada");
                    }
                    break;

                case 2:
                    // Prestar una película
                    System.out.println("Introduce los atributos de la película a prestar:");
                    System.out.print("Director: ");
                    String directorPrestar = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloPrestar = sc.nextLine();
                    System.out.print("Género: ");
                    String generoPrestar = sc.nextLine();
                    System.out.print("Año de estreno: ");
                    int añoPrestar = sc.nextInt();
                    System.out.print("Duración (en minutos): ");
                    int duracionPrestar = sc.nextInt();
                    sc.nextLine(); 

                    Pelicula peliculaPrestar = new Pelicula(directorPrestar, tituloPrestar, generoPrestar, añoPrestar, duracionPrestar);
                    filmoteca.prestarPelicula(peliculaPrestar);
                    System.out.println("Película prestada: " + peliculaPrestar);
                    break;

                case 3:
                    // Devolver una película
                    System.out.println("Introduce los detalles de la película a devolver:");
                    System.out.print("Director: ");
                    String directorDev = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloDev = sc.nextLine();
                    System.out.print("Género: ");
                    String generoDev = sc.nextLine();
                    System.out.print("Año: ");
                    int añoDev = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Duración (en minutos): ");
                    int duracionDev = sc.nextInt();
                    sc.nextLine(); 

                    Pelicula peliculaDevolver = new Pelicula(directorDev, tituloDev, generoDev, añoDev, duracionDev);
                    filmoteca.devolverPelicula(peliculaDevolver);
                    break;

                case 4:

                    // Apartar una película
                    System.out.println("Introduce los atributos de la película a apartar:");
                    System.out.print("Director: ");
                    String directorApartar = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloApartar = sc.nextLine();
                    System.out.print("Género: ");
                    String generoApartar = sc.nextLine();
                    System.out.print("Año de estreno: ");
                    int añoApartar = sc.nextInt();
                    System.out.print("Duración (en minutos): ");
                    int duracionApartar = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea

                    // Crear el objeto película para buscarlo
                    Pelicula peliculaApartar = new Pelicula(directorApartar, tituloApartar, generoApartar, añoApartar, duracionApartar);
    
                    // Verificar si la película existe en la filmoteca
                    if (filmoteca.contiene(peliculaApartar)) {
                    // Apartar la película si existe
                    filmoteca.apartarPelicula(peliculaApartar);
                        System.out.println("Película apartada: " + peliculaApartar);
                    } else {
                    // Mensaje si la película no existe
                        System.out.println("La película no existe en la filmoteca.");
                    }
                break;


             case 5:
                    // Atender un apartado
                try {
                    String peliculaAtendida = filmoteca.atenderApartado();
                    System.out.println("Se atendió el apartado de la película: " + peliculaAtendida);
                    } catch (Exception e) {
                    System.out.println("No hay apartados para atender.");
                    }
                break;


                case 6:
                    // Mostrar películas ordenadas por director
                    System.out.println("Películas ordenadas por director:");
                    filmoteca.ordenarPeliculasPorDirector();
                    for (Pelicula pelicula : peliculas) {
                        System.out.println(pelicula);
                    }
                    break;

 

                case 8:
                    // Verificar si una película está en la lista enlazada
                    System.out.println("Introduce los datos de la película a verificar:");
                    System.out.print("Director: ");
                    String directorLista = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloLista = sc.nextLine();
                    System.out.print("Género: ");
                    String generoLista = sc.nextLine();
                    System.out.print("Año de estreno: ");
                    int añoLista = sc.nextInt();
                    System.out.print("Duración (en minutos): ");
                    int duracionLista = sc.nextInt();
                    sc.nextLine(); 

                    Pelicula peliculaVerificar = new Pelicula(directorLista, tituloLista, generoLista, añoLista, duracionLista);
                    if (listaEnlazada.contiene(peliculaVerificar)) {
                        System.out.println("La película está en la lista enlazada.");
                    } else {
                        System.out.println("La película no está en la lista enlazada.");
                    }
                    break;

            case 9:
                System.out.println("Ingrese la primera película (nodo origen): ");
                String pelicula1 = scanner.nextLine().trim(); // Limpiamos espacios extra

                System.out.println("Ingrese la segunda película (nodo destino): ");
                String pelicula2 = scanner.nextLine().trim(); // Limpiamos espacios extra

                // Verificamos si ambas películas existen en el grafo
                if (!grafo.existeVertice(pelicula1)) {
                    System.out.println("La película '" + pelicula1 + "' no existe en el grafo.");
                } else if (!grafo.existeVertice(pelicula2)) {
                    System.out.println("La película '" + pelicula2 + "' no existe en el grafo.");
                } else {
                    // Si ambas existen, intentamos agregar la arista
                boolean aristaAgregada = grafo.agregarArista(pelicula1, pelicula2);
                if (aristaAgregada) {
                    System.out.println("Relación agregada correctamente entre '" + pelicula1 + "' y '" + pelicula2 + "'.");
                } else {
                System.out.println("No se pudo agregar la relación.");
                }
                }

                // Imprimimos el grafo después de agregar la relación para verificar el estado
                    System.out.println("Estado actual del grafo:");
                    System.out.println(grafo);
                break;




                case 10:
                    // Mostrar conexiones del grafo
                    System.out.println("Conexiones del grafo:");
                    System.out.println(grafoPeliculas.toString());
                    break;

                case 11:
                    // Buscar película por director (árboles)
                    System.out.println("Introduce el nombre del director:");
                    String directorBuscarArbol = sc.nextLine();  
                    Pelicula peliculaEncontradaArbol = filmoteca.buscarPeliculaEnArbol(directorBuscarArbol);
                    if (peliculaEncontradaArbol != null) {
                        System.out.println("Película encontrada: " + peliculaEncontradaArbol);
                    } else {
                        System.out.println("Película no encontrada");
                    }
                    break;

                case 12:
                    // Agregar película a la lista enlazada
                    System.out.println("Introduce los datos de la película a agregar:");
                    System.out.print("Director: ");
                    String directorAgregar = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloAgregar = sc.nextLine();
                    System.out.print("Género: ");
                    String generoAgregar = sc.nextLine();
                    System.out.print("Año de estreno: ");
                    int añoAgregar = sc.nextInt();
                    System.out.print("Duración (en minutos): ");
                    int duracionAgregar = sc.nextInt();
                    sc.nextLine(); 

                    Pelicula peliculaAgregar = new Pelicula(directorAgregar, tituloAgregar, generoAgregar, añoAgregar, duracionAgregar);
                    listaEnlazada.agregar(peliculaAgregar);
                    System.out.println("Película agregada a la lista enlazada.");
                    break;

                case 13:
                    // Eliminar película de la lista enlazada
                    System.out.println("Introduce los datos de la película a eliminar:");
                    System.out.print("Director: ");
                    String directorEliminar = sc.nextLine();
                    System.out.print("Título: ");
                    String tituloEliminar = sc.nextLine();
                    System.out.print("Género: ");
                    String generoEliminar = sc.nextLine();
                    System.out.print("Año de estreno: ");
                    int añoEliminar = sc.nextInt();
                    System.out.print("Duración (en minutos): ");
                    int duracionEliminar = sc.nextInt();
                    sc.nextLine(); 

                    Pelicula peliculaEliminar = new Pelicula(directorEliminar, tituloEliminar, generoEliminar, añoEliminar, duracionEliminar);
                    if (listaEnlazada.eliminar(peliculaEliminar)) {
                        System.out.println("Película eliminada de la lista enlazada.");
                    } else {
                        System.out.println("La película no se encontró en la lista enlazada.");
                    }
                    break;

                case 14:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 14);

        sc.close();
    }
}




