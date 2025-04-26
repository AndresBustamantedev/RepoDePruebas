

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import src.MultiplicaFactorial; // Importamos la clase desde src

public class FactorialTest {

    @Test
    public void testFactorial() {
        src.MultiplicaFactorial t = new src.MultiplicaFactorial();
        assertEquals(120, t.factorial(5));
    }
}
