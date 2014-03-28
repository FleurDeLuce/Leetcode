/*
Problem:
Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

 
Analysis:
So many cases to consider!
First of all, remove all the space at both ends of the given string;
Now we start from the left. 
The first position is a little bit special
1. '+/-': skip them
2. '.': set the dotFlag
3. '0~9': set the numFlag
4. others:  invalid input 

we continue 
if '.' is met, we break out of the current loop, start a new one. Note after '.', only 'e', numbers are allowed.
if 'e' is met, break out of the current loop, start a new one. Note after 'e', only numbers or '+/-' are allowed
*/



/**
Automata
 
<NUMBER> ::= <DECIMAL> ['e' <INTEGER>]
<DECIMAL> ::= <SIGN> <DECIMAL_POSITIVE>
<DECIMAL_POSITIVE> ::= INTEGER_POSITIVE ['.' (<INTEGER_POSITIVE> | ¦Å)]
                       | (<INTEGER_POSITIVE> | ¦Å) '.' <INTEGER_POSITIVE> 
<INTEGER> ::= <SIGN> <INTEGER_POSITIVE>
<INTEGER_POSITIVE> ::= [0-9]+
<SIGN> ::= '+' | '-' | ¦Å

*/



public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        int n = s.length();
        char[] cs = s.toCharArray();
        return isNumber(cs, 0, n);
    }
    
    private boolean isNumber(char[] cs, int s, int e){
        int eIndex = -1;
        for(int i = s; i < e; i++){
            if(cs[i] == 'e'){
                eIndex = i;
            }
        }
        if(eIndex >= 0){
            return isDecimals(cs, s, eIndex) && isInteger(cs, eIndex + 1, e);
        }else{
            return isDecimals(cs, s, e);
        }
    }
    
    private boolean isDecimals(char[] cs, int s, int e){
        if(s >= e){
            return false;
        }
        if(cs[s] == '-' || cs[s] == '+'){
            return isDecimalsPositive(cs, s + 1, e);
        }else{
            return isDecimalsPositive(cs, s, e);
        }
    }
    
    private boolean isDecimalsPositive(char[] cs, int s, int e){
        int dotIndex = -1;
        for(int i = s; i < e; i++){
            if(cs[i] == '.'){
                dotIndex = i;
                break;
            }
        }
        if(dotIndex >= 0){
            return e - s > 1 && (isIntegerPositive(cs, s, dotIndex) || s == dotIndex) && (isIntegerPositive(cs, dotIndex + 1, e) || dotIndex + 1 == e);
        }else{
            return isIntegerPositive(cs, s, e);
        }
    }
    
    private boolean isInteger(char[] cs, int s, int e){
        if(s >= e){
            return false;
        }
        if(cs[s] == '-' || cs[s] == '+'){
            return isIntegerPositive(cs, s + 1, e);
        }else{
            return isIntegerPositive(cs, s, e);
        }
    }
    
    private boolean isIntegerPositive(char[] cs, int s, int e){
        if(s >= e){
            return false;
        }
        for(int i = s; i < e; i++){
            if(!isDigit(cs[i])){
                return false;
            }
        }
        return true;
    }
    
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}