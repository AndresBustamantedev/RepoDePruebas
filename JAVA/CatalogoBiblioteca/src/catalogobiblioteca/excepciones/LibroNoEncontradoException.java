package catalogobiblioteca.excepciones;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un libro en el catálogo.
 */
public class LibroNoEncontradoException extends Exception {
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
