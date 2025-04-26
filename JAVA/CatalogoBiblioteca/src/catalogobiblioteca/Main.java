package catalogobiblioteca;

import catalogobiblioteca.excepciones.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Clase principal que ejecuta las operaciones sobre la biblioteca y su catálogo.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Crear una biblioteca
            Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Andres Bustamante");
            System.out.println("📚 Biblioteca creada: " + biblioteca.getNombre() + ", Director: " + biblioteca.getDirector());

            // 2. Crear un catálogo con capacidad para 4 libros
            biblioteca.crearCatalogo(4);
            Catalogo catalogo = biblioteca.getCatalogo();
            System.out.println("📖 Catálogo creado con capacidad para " + catalogo.getCapacidad() + " libros.");

            // 3. Simulación de carga
            System.out.println("📥 Agregando libros al catálogo...");
            System.out.print("Cargando libros");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);  // 0.5 segundos para hacerlo más ágil
                System.out.print(".");
            }
            System.out.println("\n✅ Libros cargados correctamente.");

            // Agregar 4 libros iniciales
            catalogo.agregarLibro(new LibroTerror("Stephen King", 500, "ISBN001", 4.5));
            catalogo.agregarLibro(new LibroComedia("Quino", 120, "ISBN002", "Sátira"));
            catalogo.agregarLibro(new LibroPoliciaco("Agatha Christie", 300, "ISBN003", "Misterio", "Poirot"));
            catalogo.agregarLibro(new LibroTerror("Lovecraft", 250, "ISBN004", 4.8));

            // ---- Menú interactivo ----
            boolean salir = false;
            while (!salir) {
                System.out.println("\n========== MENÚ ==========");
                System.out.println("1. Agregar libro");
                System.out.println("2. Buscar libro por ISBN");
                System.out.println("3. Eliminar libro por ISBN");
                System.out.println("4. Mostrar todos los libros");
                System.out.println("5. Exportar catálogo");
                System.out.println("6. Salir");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer

                switch (opcion) {
                    case 1:
                        agregarLibroDesdeTerminal(scanner, catalogo);
                        break;
                    case 2:
                        System.out.print("Ingrese el ISBN del libro a buscar: ");
                        String isbnBuscar = scanner.nextLine();
                        try {
                            Libro libro = catalogo.buscarLibro(isbnBuscar);
                            System.out.println("✅ Libro encontrado: " + libro.mostrarInfo());
                        } catch (LibroNoEncontradoException e) {
                            System.out.println("⚠️ " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el ISBN del libro a eliminar: ");
                        String isbnEliminar = scanner.nextLine();
                        try {
                            catalogo.eliminarLibro(isbnEliminar);
                            System.out.println("✅ Libro eliminado correctamente.");
                        } catch (LibroNoEncontradoException e) {
                            System.out.println("⚠️ " + e.getMessage());
                        }
                        break;
                    case 4:
                        catalogo.mostrarLibros();
                        break;
                    case 5:
                        exportarCatalogo(catalogo);
                        break;
                    case 6:
                        salir = true;
                        System.out.println("👋 Saliendo del gestor. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("❌ Opción no válida.");
                }
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error general: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Permite al usuario agregar un libro desde la terminal.
     */
    private static void agregarLibroDesdeTerminal(Scanner scanner, Catalogo catalogo) {
        try {
            System.out.println("Seleccione el tipo de libro:");
            System.out.println("1. Terror");
            System.out.println("2. Comedia");
            System.out.println("3. Policiaco");
            System.out.print("Opción: ");
            int tipo = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("Número de páginas: ");
            int paginas = scanner.nextInt();
            scanner.nextLine();

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            switch (tipo) {
                case 1:
                    System.out.print("Calificación: ");
                    double calificacion = scanner.nextDouble();
                    scanner.nextLine();
                    catalogo.agregarLibro(new LibroTerror(autor, paginas, isbn, calificacion));
                    break;
                case 2:
                    System.out.print("Tipo de humor: ");
                    String humor = scanner.nextLine();
                    catalogo.agregarLibro(new LibroComedia(autor, paginas, isbn, humor));
                    break;
                case 3:
                    System.out.print("Trama (Misterio/Intriga): ");
                    String trama = scanner.nextLine();
                    System.out.print("Personajes: ");
                    String personajes = scanner.nextLine();
                    catalogo.agregarLibro(new LibroPoliciaco(autor, paginas, isbn, trama, personajes));
                    break;
                default:
                    System.out.println("❌ Tipo de libro no válido.");
                    return;
            }
            System.out.println("✅ Libro agregado correctamente.");
        } catch (NoHayEspacioException e) {
            System.out.println("⚠️ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ Error al agregar el libro.");
        }
    }

    /**
     * Exporta el catálogo a un archivo .obj
     */
    private static void exportarCatalogo(Catalogo catalogo) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libros.obj"));
            oos.writeObject(catalogo.getLibros());
            oos.close();
            System.out.println("✅ Catálogo exportado correctamente a 'libros.obj'.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al exportar el catálogo: " + e.getMessage());
        }
    }
}
