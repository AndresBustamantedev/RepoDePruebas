package catalogobiblioteca;

/**
 * Clase que representa un libro de Terror.
 * Extiende de la clase abstracta Libro.
 */

    //extends sirve para indicar que una clase hereda de otra en este caso hereda de la clase Libro los siguientes atributos
    // autor, numeroPaginas, ISBN
    // y el constructor de la clase Libro

    // atributos de la clase LibroTerror
public class LibroTerror extends Libro {
    private double calificacion; // atributo específico de la clase LibroTerror
    // se usa doble para permitir decimales en la calificaciwon

    // constructor de la clase LibroTerror
    public LibroTerror(String autor, int numeroPaginas, String ISBN, double calificacion) {
        super(autor, numeroPaginas, ISBN); //super es una palabra reservada que se utiliza para referirse a la clase padre
        this.calificacion = calificacion; // asigna el valor de calificacion al atributo de la clase LibroTerror
    }

    // Getters y Setters
    public double getCalificacion() {
        return calificacion; // devuelve la calificacion
    }
    @Override // se usa para indicar que el metodo está sobrescribiendo un metodo de la clase padre
    public String mostrarInfo() {
        return "Libro de Terror | Autor: " + autor + ", Páginas: " + numeroPaginas + ", ISBN: " + ISBN + ", Calificación: " + calificacion;
    }
}
