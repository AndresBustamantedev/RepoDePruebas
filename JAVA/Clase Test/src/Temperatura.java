package src;
public class Temperatura {

    //creamos un metodo que convierte de Celsius a Fahrenheit
    // y otro que convierte de Fahrenheit a Celsius

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}


