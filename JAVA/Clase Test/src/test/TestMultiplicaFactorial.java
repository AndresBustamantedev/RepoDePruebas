import org.junit.Test;
import static org.junit.Assert.assertEquals; // Importamos los métodos de aserción de JUnit 4

public class TestMultiplicaFactorial {

    @Test
    public void testMultiplica() {
        src.MultiplicaFactorial t = new src.MultiplicaFactorial();
        assertEquals(20, t.multiplica(4, 5)); // Usamos assertEquals de JUnit 4
    }

    @Test
    public void testFactorial() {
        src.MultiplicaFactorial t = new src.MultiplicaFactorial();
        assertEquals(120, t.factorial(5)); // También aquí
    }
}
