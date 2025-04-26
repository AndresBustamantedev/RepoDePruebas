import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TemperaturaTest {

    @Test
    public void testFahrenheitToCelsius() {
        src.Temperatura temp = new src.Temperatura();
        assertEquals(-40, temp.fahrenheitToCelsius(-40), 0.01);
        assertEquals(0, temp.fahrenheitToCelsius(32), 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        src.Temperatura temp = new src.Temperatura();
        assertEquals(23, temp.celsiusToFahrenheit(-5), 0.01);
        assertEquals(59, temp.celsiusToFahrenheit(15), 0.01);
    }
}
