/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

// Solution one
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToMap(char c) {
        int val = 0;
        switch(c) {
            case 'I': val = 1;
                      break;
            case 'V': val = 5;
                      break;
            case 'X': val = 10;
                      break;
            case 'L': val = 50;
                      break;
            case 'C': val = 100;
                      break;
            case 'D': val = 500;
                      break;
            case 'M': val = 1000;
                      break;
        }
        return val;
    }
    
    
    public int romanToInt(String s) {
        int len = s.length();
        if (s == null || len == 0)
            return 0;
        
        int num = 0;
        for (int i = 0; i < len - 1; i++) {
            int cur = romanToMap(s.charAt(i));
            int next = romanToMap(s.charAt(i + 1));
            num += cur;
            if (cur < next) {
                num -= 2 * cur;
            }
        }
        num += romanToMap(s.charAt(len - 1));  
        return num;      
    }
}

// Solution Two
public class Solution {
    public int romanToMap(char c) {
        int val = 0;
        switch(c) {
            case 'I': val = 1;
                      break;
            case 'V': val = 5;
                      break;
            case 'X': val = 10;
                      break;
            case 'L': val = 50;
                      break;
            case 'C': val = 100;
                      break;
            case 'D': val = 500;
                      break;
            case 'M': val = 1000;
                      break;
        }
        return val;
    }
    
    
    public int romanToInt(String s) {
        int len = s.length();
        if (s == null || len == 0)
            return 0;
        
        int num = 0;
        num += romanToMap(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int prev = romanToMap(s.charAt(i - 1));
            int cur = romanToMap(s.charAt(i));
            num += cur;
            if (prev < cur && i > 0) {
                num -= 2 * prev;
            }
        }
        return num;      
    }
}
}

