/*
 Compare two version numbers version1 and version1.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 
 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 
 Here is an example of version numbers ordering:
 
 0.1 < 1.1 < 1.2 < 13.37
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
// split numbers by dot, and compare each part before dot in pair
public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2) || version1 == null || version2 == null) return 0;
        
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        int len1 = tokens1.length;
        int len2 = tokens2.length;
        int len = Math.max(len1, len2);
        for (int i = 0; i < len; i++) {
            int num1 = 0;
            if (i < len1)
                num1 = Integer.parseInt(tokens1[i]);
            int num2 = 0;
            if (i < len2)
                num2 = Integer.parseInt(tokens2[i]);
            if (num1 < num2)
                return -1;
            if (num1 > num2)
                return 1;
        }
        return 0;
    }
}