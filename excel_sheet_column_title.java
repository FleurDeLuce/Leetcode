/*
 Given a non-zero positive integer, return its corresponding column title as appear in an Excel sheet.
 
 For example:
 
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public String convertToTitle(int n) {
        String res = new String();
        while (n > 0) {
            res = (char)('A' + (n - 1) % 26) + res;
            n = (n - 1) / 26;
        }
        return res;
    }
}

/*
 public class Solution {
 public String convertToTitle(int n) {
 String res = new String();
 while (n != 0) {
 // this way integer directly converts to char in string
 res = "" + 'A' + (n - 1) % 26 + res;
 n = (n - 1) / 26;
 }
 return res;
 }
 }
 */
