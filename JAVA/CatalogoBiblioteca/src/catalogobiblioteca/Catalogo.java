package catalogobiblioteca;

import catalogobiblioteca.excepciones.NoHayEspacioException;
import catalogobiblioteca.excepciones.LibroNoEncontradoException;

import java.util.ArrayList;

/**
 * Clase que representa un catálogo de libros.
 * Permite agregar, eliminar y buscar libros en el catálogo.
 */

    // atributos de la clase Catalogo
public class Catalogo {
    private ArrayList<Libro> libros; // lista de libros que contiene el catálogo
    private int capacidad; // capacidad máxima del catálogo

    // constructor de la clase Catalogo
    public Catalogo(int capacidad) {
        this.capacidad = capacidad;
        this.libros = new ArrayList<>();
    }
/**
 * Agrega un libro al catálogo si hay espacio y no está duplicado.
 */

public void agregarLibro(Libro libro) throws NoHayEspacioException {
    if (libros.size() >= capacidad) throw new NoHayEspacioException("No hay espacio en el catálogo.");
    if (libros.stream().noneMatch(l -> l.getISBN().equals(libro.getISBN()))) {
        libros.add(libro);
    }
}
    /*
    *throws se usa para indicar que puede lanzar una excepción como NoHayEspacioException
    *size devuelve el tamaño de la lista
    *stream permite procesar la lista de libros
    *noneMatch devuelve true si no hay coincidencias en la lista
    *equals compara el ISBN del libro que se quiere agregar con los ISBN de los libros que ya están en la lista
    *si no hay coincidencias se agrega el libro a la lista
     */



/**
 * Busca un libro por su ISBN.
 */

    public Libro buscarLibro(String isbn) throws LibroNoEncontradoException {
        return libros.stream()
                .filter(l -> l.getISBN().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con ISBN " + isbn + " no encontrado."));
    }



    /**
     * Elimina un libro del catálogo por su ISBN.
     */
    public void eliminarLibro(String isbn) throws LibroNoEncontradoException {
        Libro libro = buscarLibro(isbn);
        libros.remove(libro);
    }

/**
 * Muestra la información de todos los libros en el catálogo.
 */
    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            libros.forEach(l -> System.out.println(l.mostrarInfo()));
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public int getCapacidad() {
        return capacidad;
    }
}


