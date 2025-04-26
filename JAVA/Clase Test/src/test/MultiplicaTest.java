
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import src.MultiplicaFactorial; // Importamos la clase desde src

public class MultiplicaTest {

    @Test
    public void testMultiplica() {
        src.MultiplicaFactorial t = new src.MultiplicaFactorial();
        assertEquals(20, t.multiplica(4, 5));
    }
}
