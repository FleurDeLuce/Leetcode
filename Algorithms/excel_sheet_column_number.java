/*
 Related to question Excel Sheet Column Title
 
 Given a column title as appear in an Excel sheet, return its corresponding column number.
 
 For example:
 
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            res = res * 26 + s.charAt(i) - 64;
            
        }
        return res;
    }
}