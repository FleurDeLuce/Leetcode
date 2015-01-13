/*
Given a number represented as an array of digits, plus one to the number.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
	int len = digits.length;
	for (int i = len - 1; i >= 0; i--) {
	    if (digits[i] != 9) {
	        digits[i]++;
	        return digits;
	    }
	    digits[i] = 0;
	}
	
	int[] newDigits = new int[len + 1];
	// default new array is all zero
	newDigits[0] = 1;
	return newDigits;
    }
}