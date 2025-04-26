package catalogobiblioteca;

import java.io.Serializable;
// importar java.io.Serializable para permitir la serialización de objetos
/**
 * Clase abstracta que representa un libro genérico.
 * Sirve como base para los diferentes tipos de libros.
 * No se puede instanciar directamente.
 */

    // atributos de la clase Libro
    public abstract class Libro implements Serializable {
    protected String autor;
    protected int numeroPaginas;
    protected String ISBN;

    // constructor
    public Libro(String autor, int numeroPaginas, String ISBN) {
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.ISBN = ISBN;
    }

    // Getters y Setters
    public String getISBN() {
        return ISBN;
    }

    /**
     * Metodo abstracto para mostrar la información del libro.
     * Cada subclase implementará su propia versión.
     */
    public abstract String mostrarInfo();// metodo abstracto que obliga a las subclases a implementar su propia versión
}
