//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    /*

    Person persona1 = new Person();
    persona1.name = "Juan";
    persona1.lastName = "Pérez";
    persona1.age = 17;

    Degree degree = new Degree();
    degree.name = "Ingeniería de Sistemas";
    degree.duration = 5;
    degree.isActive = true;


    persona1.degree = degree;


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



     */
        // Crear una variable para almacenar el nombre de la persona a la que se enviarán los saludos
        //String Regards = "Omar"
        String Regards = "Andres";

        // Crear una instancia de la clase Person
    Person persona3 = new Person("Jorge", "Bustamante", 30,"andy@gmail.com", new String[]{"123456789", "987654321"}, true, new Degree("Ingeniería de Sistemas", 5, false));
    Person persona4 = new Person("Karol","Carbajal",29);


        // Imprimir el nombre completo de la persona y su edad
    /*
        System.out.printf(persona1.getFullName()+ " tiene " + persona1.age + " años."+
                " Su carrera es " + persona1.degree.name + " y tiene una duración de " + persona1.degree.duration + " años.\n");
        System.out.printf(persona2.name + " " + persona2.lastName + " tiene " + persona2.age + " años.\n");
        System.out.println(persona1.sendRegards("Andres"));
        System.out.println(persona2.sendRegards(Regards));
    */
        System.out.println(persona3);
        System.out.printf(persona3.getFullName()+ " tiene " + persona3.age + " años."+
                " Su carrera es " + persona3.degree.name + " y tiene una duración de " + persona3.degree.duration + " años.\n");


        System.out.println(persona4.getFullName() + " tiene " + persona4.age + " años.");




    }

}