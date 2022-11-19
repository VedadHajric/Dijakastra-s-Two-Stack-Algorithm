package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testovi za naš projekat odnosno zadacu
 */

public class ExpressionEvaluatorTest {
    /**
     * Prvi test je primjer iz postavke zadace ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
     */
    @Test
    public void primjerIzZadace1() {
        Double izraz = ExpressionEvaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        assertEquals((Double)101.,(Double)izraz);
    }

    /**
     * Drugi test za drugi primjer iz postavke zadace ( 1 + ( 5 * 20 ) )
     */
    @Test
    public void primjerIzZadace2() {
        Double izraz = ExpressionEvaluator.evaluate("( 1 + ( 5 * 20 ) )");
        assertEquals((Double)101.,(Double)izraz);
    }

    /**
     * Testiranje ispravnosti koda za funkciju sqrt
     */
    @Test
    public void trazenjeKorijena() {
        Double izraz = ExpressionEvaluator.evaluate("( sqrt ( 5 * 20 ) )");
        assertEquals((Double)10., (Double)izraz);
    }

    /**
     * Testiranje ispravnosti koda za operaciju dijeljenja
     */
    @Test
    public void dijeljenje() {
        Double izraz = ExpressionEvaluator.evaluate("1 + ( 5 / 5 ) )");
        assertEquals((Double)2., (Double)izraz);
    }

}
