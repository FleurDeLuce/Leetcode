/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

// Solution: Manacher's algorithm
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public String longestPalindrome(String s) {
        String T = preprocess(s);
        int len = T.length();
        int[] P = new int[len];
        
        // C as current center
        int C = 0;
        // R as current right edge
        int R = 0;
        P[0] = 0;
        P[len - 1] = 0;

        for (int i = 1; i < len - 1; i++) {
        	int i_mirror = (C - i) + C;
        	P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;

        	// Expand the palindrome string centered at i
        	// T.charAt(i - P[i] - 1)) is the character i minus current palindromic radius P[i]
        	while (T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1)) 
        		P[i]++;

        	// Adjust center and right edge
        	if (P[i] > R - i) {
        		C = i;
        		R = i + P[i];
        	}
        }

        // Find the max in P
        int maxLen = 0;
        int curIndex = 0;
        for (int i = 1; i < len - 1; i++) {
        	if (P[i] > maxLen) {
        		maxLen = P[i];
        		curIndex = i;
        	}
        }
        int startIndex = (curIndex - 1 - maxLen) / 2;
        return s.substring(startIndex, startIndex + maxLen);
    }

    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    // $ and @ are prepended and appended to each end to avoid bounds checking
    public String preprocess(String s) {
    	int len = s.length();
    	if (len == 0) return "$@";
    	String ret = "^";
    	for (int i = 0; i < len; i++) ret += "#" + s.charAt(i);
    	ret += "#@";
    	return ret;
    }
}