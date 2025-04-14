public class Person {

    // atributos de la clase

    String name;
    String lastName;
    int age;
    String email;
    String [] phoneNumbers;
    boolean isStudent;

    // metodos (comportamiento de la clase)

    public String getFullName() {
        return name + " " + lastName;
    }

    public String sendRegards(String regards) {
        if (age < 18) return "No puedo enviar saludos a " + regards + " porque soy menor de edad.";

        return "Buenos dias " + regards + " que tal estas?";
    }

}
