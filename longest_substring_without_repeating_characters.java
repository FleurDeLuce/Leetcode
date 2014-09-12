/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/


// Solution: 
// Time complexity: O(n), Space complexity: O(n)
/*
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) 
			return 0;
		int len = s.length();
		int curLen = 1;
		int maxLen = 1;
		int prevIndex = 0;
		int[] exist = new int[256];
		Arrays.fill(exist, -1);

		exist[s.charAt(0)] = 0;
		int i = 0;
		for (i = 1; i < len; i++) {
			prevIndex = exist[s.charAt(i)];
			if(prevIndex == -1 || i - curLen > prevIndex)
				curLen++;
		}
	}
}
*/

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