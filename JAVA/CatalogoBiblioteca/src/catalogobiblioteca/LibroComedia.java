package catalogobiblioteca;
    /**
    * Clase que representa un libro de Comedia.
     */

    //atributos de la clase LibroComedia
    public class LibroComedia extends Libro {
    private String tipoHumor; // atributo específico de la clase LibroComedia


    // constructor de la clase LibroComedia

        public LibroComedia(String autor, int numeroPaginas, String ISBN, String tipoHumor) {
            super(autor, numeroPaginas, ISBN);
            this.tipoHumor = tipoHumor;
        }

    // Getters y Setters
        public String getTipoHumor() {
            return tipoHumor;
        }


        @Override
        public String mostrarInfo() {
            return "Libro de Comedia | Autor: " + autor + ", Páginas: " + numeroPaginas + ", ISBN: " + ISBN + ", Tipo de humor: " + tipoHumor;
        }
    }
