/*
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 
 If the fractional part is repeating, enclose the repeating part in parentheses.
 
 For example,
 
 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0 || numerator == 0)
            return new String("0");
        StringBuffer res = new StringBuffer();
        // check if negative to protect from overflow
        if ((numerator > 0)^(denominator > 0))
            res.append("-");
        // avoid overflow in absolute value of INT_MIN
        // remember to cast original int numerator to long type before assignment
        long numeratorLong = Math.abs((long)numerator);
        long denominatorLong = Math.abs((long)denominator);
        
        // convert the fraction to decimal
        res.append(String.valueOf(numeratorLong / denominatorLong));
        // get quotient one digit by one digit
        long remainder = numeratorLong % denominatorLong;
        if (remainder == 0) return res.toString();
        res.append(".");
        HashMap<Long, Integer> position = new HashMap<Long, Integer>();
        while (remainder != 0) {
            // check if remainder is in hashmap, if so, the recurring starts
            if (position.get(remainder) != null) {
                break;
            }
            position.put(remainder, res.length());
            remainder *= 10;
            res.append(String.valueOf(remainder / denominatorLong));
            remainder %= denominatorLong;
        }
        // finite decimal
        if (remainder == 0) return res.toString();
        // infinite repeating decimal
        // get back to the place before the first repeating number, insert left bracket
        // then go to the end of the repeating part, add the right bracket 
        res.insert(position.get(remainder), "(");
        res.append(")");
        
        return res.toString();
    }
}