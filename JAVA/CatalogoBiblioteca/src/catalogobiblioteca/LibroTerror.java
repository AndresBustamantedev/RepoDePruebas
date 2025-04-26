package catalogobiblioteca;

/**
 * Clase que representa un libro de Terror.
 * Extiende de la clase abstracta Libro.
 */

public class LibroTerror extends Libro {
    private double calificacion;

    public LibroTerror(String autor, int numeroPaginas, String ISBN, double calificacion) {
        super(autor, numeroPaginas, ISBN);
        this.calificacion = calificacion;
    }

    @Override
    public String mostrarInfo() {
        return "Libro de Terror | Autor: " + autor + ", Páginas: " + numeroPaginas + ", ISBN: " + ISBN + ", Calificación: " + calificacion;
    }
}
