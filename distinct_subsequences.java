/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

/*
Time complexity:
Space complexity:

Solution:
 http://blog.csdn.net/abcbc/article/details/8978146
 http://rleetcode.blogspot.com/2014/01/distinct-subsequences-java.html
 http://fisherlei.blogspot.com/2012/12/leetcode-distinct-subsequences_19.html
*/

// solution 1: recursion
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        if (T.length() == 0) {
        	return 1;
        } 
        int targetSize = T.length();
        int sourceSize = S.length();
        int count = 0;

        for (int i = 1; i <= sourceSize; i++) {
        	count +=  numDistinct(S.substring());
        }
        	
        return match[targetSize][sourceSize];
    }
} 

// solution 2: 2-d array
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        if (T.length() == 0) {
        	return 1;
        } 
        int targetSize = T.length();
        int sourceSize = S.length();
        // considering case of emtry string
        int[][] match = new int[targetSize + 1][sourceSize + 1];

        // # of appearance of string T in string "" is 0
        for (int j = 0; j < targetSize; j++) {
        	match[j][0] = 0;
        }

        // # of appearance of empty string ""(length is 0) in string S is 1
        for (int i = 0; i < sourceSize; i++) {
        	match[0][i] = 1;
        }


        for (int i = 1; i <= targetSize; i++) {
        	for (int j = 1; j <= sourceSize; j++) {
        		// anyhow S[j - 1] is matched to T[i - 1]
        		match[i][j] = match[i][j - 1];
        		// we can match S[j - 1] with T[i - 1] additionally now
        		if (T.charAt(i - 1) == S.charAt(j - 1)) {
        			match[i][j] += match[i - 1][j - 1];
        		}
        	}
        }
        return match[targetSize][sourceSize];
    }
}

// solution 3: 
