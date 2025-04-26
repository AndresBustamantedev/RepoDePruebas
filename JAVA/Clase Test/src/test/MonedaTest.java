import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MonedaTest {

    @Test
    public void testDolarEuro() {
        src.Moneda moneda = new src.Moneda();
        assertEquals(8.925, moneda.dolarEuro(10.5), 0.01);
    }

    @Test
    public void testEuroDolar() {
        src.Moneda moneda = new src.Moneda();
        assertEquals(23.88, moneda.euroDolar(20.30), 0.01);
    }
}
