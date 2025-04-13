//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.SQLOutput;
import java.util.Scanner;
public class Ahorcado {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //Clase Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Definir la palabra secreta y el número máximo de intentos
        //Declaración de variables
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //optimizar el código 2

        // Crear un arreglo de caracteres para almacenar las letras adivinadas
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Estructura de control para el juego: iterativa
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_'; // Inicializar con guiones bajos

        }

        // Estructura de control para el juego: iterativa

        while(!palabraAdivinada && intentos < intentosMaximos){
            System.out.println("");
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ("+palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra por favor :");

            // usamamos la clase scanner para pedirle al usuario que ingrese una letra
            //char letra = scanner.next().charAt(0);
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta){
                intentos++;
                System.out.println("Letra incorrecta. Te quedan " + (intentosMaximos - intentos) + " intentos.");
            } else {
                System.out.println("Letra correcta!");
            }


            // Verificar si la palabra ha sido adivinada

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            }

            // Mostrar el estado actual de la palabra adivinada

            if (intentos == intentosMaximos) {
                System.out.println("Lo siento, has agotado tus intentos. La palabra era: " + palabraSecreta);
            }


        }
        // Cerrar el escáner
        scanner.close();

    }
}