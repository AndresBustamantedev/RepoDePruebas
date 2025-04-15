public class Person {

    // atributos de la clase

    String name;
    String lastName;
    int age;
    String email;
    String [] phoneNumbers;
    boolean isStudent;
    Degree degree;


    // constructor de la clase

    //instancia 1
    public Person(String name, String lastName, int age, String email, String[] phoneNumbers, boolean isStudent, Degree degree) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.isStudent = isStudent;
        this.degree = degree;
    }
    //instancia 2
    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }



    // metodos (comportamiento de la clase)

    public String getFullName() {
        return name + " " + lastName;
    }

    public String sendRegards(String regards) {
        if (age < 18) return "No puedo enviar saludos a " + regards + " porque soy menor de edad.";

        return "Buenos dias " + regards + " que tal estas?";
    }




}
