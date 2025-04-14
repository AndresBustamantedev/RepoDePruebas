//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Person persona = new Person();
    persona.name = "Juan";
    persona.lastName = "Pérez";
    persona.age = 30;

    Person persona2 = new Person();
    persona2.name = "Ana";
    persona2.lastName = "García";
    persona2.age = 15;



    String Regards = "Andres";

        System.out.printf(persona.getFullName()+ " tiene " + persona.age + " años.\n");
        System.out.printf(persona2.name + " " + persona2.lastName + " tiene " + persona2.age + " años.\n");
        System.out.println(persona.sendRegards("Omar"));
        System.out.println(persona2.sendRegards(Regards));


    }

}