/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        // add two strings reversely
        int iA = a.length() - 1, iB = b.length() - 1;
        int carry = 0;
        String res = "", cur = "";
        // 
        while (iA >= 0 || iB >= 0) {
            carry += iA >= 0 ? a.charAt(iA--) - '0' : 0;
            carry += iB >= 0 ? b.charAt(iB--) - '0' : 0;
            cur = (carry & 1) == 1 ? "1" : "0";
            res = cur + res;
            // carry /= 2
            carry = carry >> 1;
        }
        res = carry == 1 ? ("1" + res) : res;
        return res;
    }
}