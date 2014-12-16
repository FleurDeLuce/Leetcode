/*
 Given two strings S and T, determine if they are both one edit distance apart.
 */

// Solution
// Time complexity: O(), Space complexity: O()
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        if (lenS < lenT)
            return isOneEditDistance(t, s);
        
        if (lenS - lenT > 1)
            return false;
        
        int i = 0;
        int shift = lenS - lenT;
        // same length strings, compare non-matching letter
        while (i < lenS && s.charAt(i) == s) i++;
        // all string char matches,
        if (i == lenS) return shift > 0;
        
        if (shift == 0) i++;
        while (i < lenS && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == lenS;
    }
}
