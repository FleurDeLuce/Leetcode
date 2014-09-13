/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
        	return s.length() == 0;

        if (p.length() == 1)
        	return (s.length() == 1 
        		&& ( s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // second char is not '*', then second char should match
        if (p.charAt(1) != '*') {
        	if (s.length() <= 0)
        		return false;
        	return ((s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.'))
        	       && isMatch(s.substring(1), p.substring(1))));
        }

        // second char is '*'
        while (s.length() > 0 
        	&&(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
        	if (isMatch(s, p.substring(2)))
        		return true;
        	s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
}