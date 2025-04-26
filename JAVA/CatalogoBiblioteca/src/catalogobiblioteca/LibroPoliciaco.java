package catalogobiblioteca;


    // atributos de la clase LibroPoliciaco

    public class LibroPoliciaco extends Libro {
        private String trama; // atributo específico de la clase LibroComedia
        private String personajes; // atributo específico de la clase LibroComedia


        // constructor de la clase LibroPoliciaco
        public LibroPoliciaco(String autor, int numeroPaginas, String ISBN, String trama, String personajes) {
            super(autor, numeroPaginas, ISBN);
            this.trama = trama;
            this.personajes = personajes;
        }


        // Getters y Setters
        public String getTrama() {
            return trama;
        }
        public String getPersonajes() {
            return personajes;
        }

        @Override
        public String mostrarInfo() {
            return "Libro Policiaco | Autor: " + autor + ", Páginas: " + numeroPaginas + ", ISBN: " + ISBN + ", Trama: " + trama + ", Personajes: " + personajes;
        }


        // Metodo para mostrar la información del libro

}