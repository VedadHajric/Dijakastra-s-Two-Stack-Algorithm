package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Klasa sa javnom metodom evalute
 */

public class ExpressionEvaluator {

    public static double evaluate(String expression) {
        String operator = "";
        Double result = 0.;
        Stack<Double> operandi = new Stack<Double>();
        Stack<String> operatori = new Stack<String>();
        String[] symbols = expression.split(" ");
        for(String symbol : symbols) {
            if(symbol.equals("("));
            else if(symbol.equals("+")) operatori.push(symbol);
            else if(symbol.equals("-")) operatori.push(symbol);
            else if(symbol.equals("/")) operatori.push(symbol);
            else if(symbol.equals("*")) operatori.push(symbol);
            else if(symbol.equals("sqrt")) operatori.push(symbol);
            else if(symbol.equals("pow")) operatori.push(symbol);
            else if(symbol.equals(")")) {
                operator = operatori.pop();
                Double value = operandi.pop();
                if(operator.equals("+")) value = operandi.pop() + value;
                if(operator.equals("-")) value = operandi.pop() - value;
                if(operator.equals("/")) {
                    if(value == 0) throw new RuntimeException("Nije dozvoljeno dijeljenje sa nulom");
                    value = operandi.pop() / value;
                }
                if(operator.equals("*")) value = operandi.pop() * value;
                if(operator.equals("sqrt")) value = Math.sqrt(value);
                operandi.push(value);
            }
            else operandi.push(Double.parseDouble(symbol));
        }
        result = operandi.pop();
        return result;
    }
}
