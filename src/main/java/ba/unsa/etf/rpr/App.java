package ba.unsa.etf.rpr;

/**
 * Main klasa u kojoj obavljamo validaciju ulaza i u kojoj obavljamo parsanje stringa
 *
 */
public class App 
{
    public static String main( String[] args ) {
        Double result = null;
        try {
            if(args.length == 0) throw new RuntimeException("Nijedan argument nije primljen");
            int brojOperatora = 0;
            int brojOperanada = 0;
            int brojOtvorenihZagrada = 0;
            int brojZatvorenihZagrada = 0;

            for(String argument : args) {
                brojOperatora = 0;
                brojOperanada = 0;
                brojOtvorenihZagrada = 0;
                brojZatvorenihZagrada = 0;

                String[] symbols = argument.split(" ");
                for(String symbol : symbols) {
                    if(symbol.equals("(")) brojOtvorenihZagrada = brojOtvorenihZagrada + 1;
                    else if(symbol.equals(")")) brojZatvorenihZagrada = brojZatvorenihZagrada + 1;
                    else if(StringIsNumberEvaluator.isNumber(symbol)) brojOperanada = brojOperanada + 1;
                    else if(symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/") || symbol.equals("sqrt")) brojOperatora = brojOperatora + 1;
                    else throw new RuntimeException("Neispravan izraz");
                }
                if(brojOtvorenihZagrada != brojZatvorenihZagrada || brojOtvorenihZagrada != brojOperatora || brojOperanada == 0) throw new RuntimeException("Neispravan izraz");
                result = ExpressionEvaluator.evaluate(argument);
                System.out.println("Rezultat je: " + result);
            }
        } catch (RuntimeException error)  {
            System.out.println(error.getMessage());
            return error.getMessage();
        }
        String string = String.valueOf(result);
        return string;
    }
}
