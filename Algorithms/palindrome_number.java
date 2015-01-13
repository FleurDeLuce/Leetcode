/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

// Reverse and compare, but may overflow
// Compare each digit
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int d = 1;
        // get the largest d 
        while (x / d >= 10) d *= 10;
        while (x > 0) {
            // fist digit
            int h = x / d;
            // last digit
            int l = x % 10;
            if (h != l) return false;
            // Remove the last digit
            x = x % d / 10;
            // x has been removed 2 digits, first and last, thus d as well
            d /= 100;
        }
        return true;
    }
}