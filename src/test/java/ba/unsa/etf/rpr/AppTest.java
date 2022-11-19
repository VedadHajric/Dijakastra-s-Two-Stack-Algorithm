package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testovi za nas projekat odnosno zadacu za klasu App
 */
public class AppTest
{
    /**
     * Testiranje ispravnosti ulaza, prvi test je primjer iz postavke zadace ( 1 + ( 5 * 20 ) )
     */
    @Test
    public void primjerIzZadace1()
    {
        assertEquals("Ilegalan izraz", App.main(new String[]{"( 1 + ( 5 * 20 ) )"}));
    }

    /**
     * Testiranje ispravnosti ulaza, primjer bez operanada  ( - ( / ) )
     */
    @Test
    public void primjerIzZadace2()
    {
        assertEquals("Ilegalan izraz", App.main(new String[]{"( - ( / ) )"}));
    }

    /**
     * Testiranje ispravnosti ulaza, primjer u kojem nisu sve otvorene zagrade zatvorene  ( 3 + ( 4 - 1 )
     */
    @Test
    public void primjerIzZadace3()
    {
        assertEquals("Ilegalan izraz", App.main(new String[]{"( 3 + ( 4 - 1 )"}));
    }

    /**
     * Testiranje ispravnosti ulaza, primjer u kojem nedostaje prva zagrada   9 - ( 8 / 2 ) )
     */
    @Test
    public void primjerIzZadace4()
    {
        assertEquals("Ilegalan izraz", App.main(new String[]{" 9 - ( 8 / 2 ) )"}));
    }


    /**
     * Testiranje ispravnosti ulaza, primjer  u kojem nedostaje operator  ( 4 ( 6 + 3 ) )
     */
    @Test
    public void primjerIzZadace5()
    {
        assertEquals("Ilegalan izraz", App.main(new String[]{"( 4 ( 6 + 3 ) )"}));
    }

    /**
     * Testiranje ispravnosti ulaza, primjer u kojem imamo karakter koji nije u zadatim  ( 3 ! ( 5 + 1 ) )
     */
    @Test
    public void primjerIzZadace6()
    {
        assertEquals("Ilegalan izraz", App.main(new String[]{"( 3 ! ( 5 + 1 ) )"}));
    }

    /**
     * Za posljednji test, jedan integracijski test
     */
    @Test
    public void integration()
    {
        assertEquals("101.0", App.main(new String[]{"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"}));
    }

}
