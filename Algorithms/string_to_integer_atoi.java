/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution {
    public int atoi(String str) {
        // empty string
        int len = str.length();
        if (len == 0 || str == null) 
            return 0;
        
        // trim heading white spaces
        int i = 0;       
        while (str.charAt(i) == ' ' && i < len) i++;
        
        // positive or negative sign
        int sign = 1;
        // only need to check if the first char is sign or not
        if (str.charAt(i) == '+') 
            i++;
        else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }     
        
        int num = 0;
        // check invalid char
        for (; i < len; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') 
                break;
            // check overflow
            // mistake :
            //             if (num / 10 > Integer.MAX_VALUE 
            // || num / 10 == Integer.MAX_VALUE && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10) 
            if (num > Integer.MAX_VALUE / 10
            || num == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10) 
                return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            else 
                num = num * 10 + (str.charAt(i) - '0');
        }
        return num * sign;
    }
}






public class Solution {
    public int atoi(String str) {
        // Empty string
        int len = str.length();
        if (len == 0 || str == null) 
            return 0;
        
        // Trim white spaces
        //String trimStr = str.trim();
        int i;
        for (i = 0; i < len; i++) {
            if (str.charAt(i) == " ") 
                i++;
            else 
                trimStr = str.substring(i);
        }
        if (i == len) 
            return 0;
        
        // Check positive or negative sign
        char flag = '+';
        i = 0;
        if (str.charAt(0) == '+') {
            i++;
        }
        else if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }
        
        // Store in double type for large integers
        double result = 0;
        // check valid digits
        while (i < result.length() && str.charAt(i) > '0' && str.charAt(i) < '9') {
            result = result * 10 + str.charAt(i) - '0'; 
            i++;
        }
        if (flag == '-') 
            result = 0 - result;
            
        // handle overflow
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
            
        return (int)result;
    }
}



