/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
	public int getNonRepeated(String s) {
		if (s == null || s.length() == 0) return 0;
		int size = s.length();
		int left = 0;
		int right = 0;
		int pos[] = new int[26];
		Arrays.fill(pos, -1);
		while (left <= right) {
			// found repeated characters
			if (pos[s.charAt(right)] > 0) {
				
			}
		}
	}
}




abcabcbb