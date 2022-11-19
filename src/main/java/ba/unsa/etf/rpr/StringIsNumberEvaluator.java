package ba.unsa.etf.rpr;

/**
 * Dodana klasa kao olaksica rjesavanja problem koja ima jednu metodu "isNumber" koja prima String i provjerava
 * da li se moze parseati u Double
 */

public class StringIsNumberEvaluator {
    public static boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }
}
