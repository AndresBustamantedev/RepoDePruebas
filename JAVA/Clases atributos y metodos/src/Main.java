//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Person persona = new Person();
    persona.name = "Juan";
    persona.lastName = "Pérez";
    persona.age = 17;

    Degree degree = new Degree();
    degree.name = "Ingeniería de Sistemas";
    degree.duration = 5;
    degree.isActive = true;


    persona.degree = degree;


    // Crear una segunda instancia de la clase Person


    Person persona2 = new Person();
    persona2.name = "Ana";
    persona2.lastName = "García";
    persona2.age = 55;

    Degree degree2 = new Degree();
    degree2.name = "Ingeniería biomedica";
    degree2.duration = 4;
    degree2.isActive = false;

    persona2.degree = degree2;

        // Crear una variable para almacenar el nombre de la persona a la que se enviarán los saludos
        //String Regards = "Omar"

    String Regards = "Andres";

        // Imprimir el nombre completo de la persona y su edad

        System.out.printf(persona.getFullName()+ " tiene " + persona.age + " años."+
                " Su carrera es " + persona.degree.name + " y tiene una duración de " + persona.degree.duration + " años.\n");
        System.out.printf(persona2.name + " " + persona2.lastName + " tiene " + persona2.age + " años.\n");
        System.out.println(persona.sendRegards("Andres"));
        System.out.println(persona2.sendRegards(Regards));


    }

}