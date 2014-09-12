/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/


// Solution: 
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		int [] countTable = new int[256];
		Arrays.fill(countTable, -1);
		int max = 1;
		int start = 0;
		int end = 1;
		
		countTable[s.charAt(0)] = 0;
		while (end < length) {
		    // countTable records the position of occurred char
			// found a duplicate char
			if (countTable[s.charAt(end)] >= start) {
				start = countTable[s.charAt(end)] + 1;				
			}
			max = Math.max(max, end - start + 1);
			countTable[s.charAt(end)] = end;
			end++;
		}
		return max;
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