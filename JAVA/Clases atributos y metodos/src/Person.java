import java.util.Locale;

public class Person {

    // atributos de la clase

    private String name;
    String lastName;
    int age;
    String email;
    String [] phoneNumbers;
    boolean isStudent;
    Degree degree;


    // constructor de la clase

    //instancia 1
    public Person(String name, String lastName,   int age, String email, String[] phoneNumbers, boolean isStudent, Degree degree) {
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


    //public String getName() {
     //   return this.name.toLowerCase();}

    // GET AND SETER


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
