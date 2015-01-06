/*
 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 
 For example, Given s = “eceba”,
 
 T is "ece" which its length is 3.
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    // Maintain a sliding window with at most two distinct characters
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0 || s == null) return 0;
        int maxLen = 0;
        int left = 0, right = -1;
        for (int i = 1; i < s.length(); i++) {
            // when exploring forward to expand the sliding window, the characters in the window remains the same types
            if (s.charAt(i) == s.charAt(i - 1)) continue;
            if (right >= 0 && s.charAt(right) != s.charAt(i)) {
                maxLen= Math.max(i - left, maxLen);
                left = right + 1;
            }
            right = i - 1;
        }
        return Math.max(s.length() - left, maxLen);
    }
}