package catalogobiblioteca.excepciones;

/**
 * Excepción personalizada que se lanza cuando no hay espacio en el catálogo.
 */
public class NoHayEspacioException extends Exception {
    public NoHayEspacioException(String mensaje) {
        super(mensaje);
    }
}
