package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testovi za nas projekat odnosno zadacu za klasu ExpressionEvaluator
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
        Double izraz = ExpressionEvaluator.evaluate("( sqrt ( 4 * 16 ) )");
        assertEquals((Double)8., (Double)izraz);
    }

    /**
     * Testiranje ispravnosti koda za operaciju dijeljenja
     */
    @Test
    public void dijeljenje() {
        Double izraz = ExpressionEvaluator.evaluate("6 + ( 3 / 3 ) )");
        assertEquals((Double)7., (Double)izraz);
    }
    /**
     * Testiranje kad je rezultat negativan
     */
    @Test
    public void negativni() {
        Double izraz = ExpressionEvaluator.evaluate("8 - ( 3 * 9 ) )");
        assertEquals((Double)(-19.), (Double)izraz);
    }
    /**
     * Testiranje da li nas kod koji smo napisali baca gresku kod dijeljenja sa nulom
     */
    public void dijeljenjeSaNulom() {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 15 / 0 )");
        });
        assertEquals("Nije dozvoljeno dijeliti sa nulom", thrown.getMessage());
    }
}
