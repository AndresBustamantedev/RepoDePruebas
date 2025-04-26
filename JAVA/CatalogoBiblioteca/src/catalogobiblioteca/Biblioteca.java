package catalogobiblioteca;

/**
 * Clase que representa una Biblioteca, la cual contiene un catálogo de libros.
 */
public class Biblioteca {
    private String nombre;
    private String director;
    private Catalogo catalogo;

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    /**
     * Crea un catálogo con la capacidad indicada.
     */
    public void crearCatalogo(int capacidad) {
        this.catalogo = new Catalogo(capacidad);
    }

    /**
     * Devuelve el catálogo si existe, si no lanza una excepción.
     */
    public Catalogo getCatalogo() {
        if (catalogo == null) {
            throw new RuntimeException("El catálogo aún no ha sido creado.");
        }
        return catalogo;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDirector() {
        return director;
    }
}
