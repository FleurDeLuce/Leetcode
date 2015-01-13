/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return null;
        if (n == 1) return "1";
        String tempStr = "1";
        
        for (int i = 1; i < n; i++) {
            tempStr = count(tempStr);
        }
        return tempStr;
    }
    
    public String count(String s) { // use current sequence to generate next sequence
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            // consecutive duplicates
            while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                i++;
                count++;
            }
            res = res + count + chars[i];
        }
        return res;
    }
}