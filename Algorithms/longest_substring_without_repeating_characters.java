/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/


// Solution: 
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		int [] exist = new int[256];
		Arrays.fill(exist, -1);
		int maxLen = 1;
		int left = 0;
		int right = 1;
		
		// exist records the position of occurred char
		exist[s.charAt(0)] = 0;
		while (right < len) {
			// found a duplicate char
			// in this iteration of substring searching, if found a char positioned 
			// between left and right, then it is duplicated
			if (exist[s.charAt(right)] >= left) {
				left = exist[s.charAt(right)] + 1;				
			}
			maxLen = Math.max(maxLen, right - left + 1);
			exist[s.charAt(right)] = right;
			right++;
		}
		return maxLen;
	}
}

// Solution 2
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) 
			return 0;
		int len = s.length();
		int maxLen = 0;
		int left = 0, right = 0;
		boolean exist[] = new boolean[256];
		Arrays.fill(exist, false);

		while (right < len) {
			// found a repeating character
			if (exist[s.charAt(right)]) {
				// now, right and left points to the same char, thus the substring ends in right - 1, and the length is right - 1 - left + 1
				maxLen = Math.max(maxLen, right - left);
				// start checking a new string starting from the first char not the same char as right
				while (s.charAt(left) != s.charAt(right)) {
					exist[s.charAt(left)] = false;
					left++;
				}
				left++;
				right++;
			}
			else {
				exist[s.charAt(right)] = true;
				right++;
			}
		}
		maxLen = Math.max(maxLen, len - left);
		return maxLen;
	}
}