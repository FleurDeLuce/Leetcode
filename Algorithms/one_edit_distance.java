/*
 Given two strings S and T, determine if they are both one edit distance apart.
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS > lenT)
            return isOneEditDistance(t, s);
        if (lenT - lenS > 1)
            return false;
        
        int i = 0;
        int shift = lenT - lenS;
        // stop when reaches the first non-matching letter or all letters in s matches
        while (i < lenS && s.charAt(i) == t.charAt(i)) i++;
        // all letters in s matches, previously eliminates the condition when lenT - lenS > 1
        // thus here if shift > 0 (ie. shift == 1), not one edit distance away
        if (i == lenS) return shift > 0;
        // reaches the first non-matching letter in the middle, skip it
        if (shift == 0) i++;
        // check if the remaining letters from two strings match until the end
        while (i < lenS && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == lenS;
    }
}
