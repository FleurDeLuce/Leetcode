/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) return;
        int len = num.length;

        // from right to left, find the first non-increasing number (ascending from right)
        int i = len - 1;
        while (i > 0 && num[i - 1] >= num[i]) 
            i--;
        // all numbers are ascending from right
        if (i <= 0) {
            reverse(num, 0, len - 1);
            return;
        }
        // from right to left, find successor of the permute number
        int j = len - 1;
        while (num[j] <= num[i - 1])
        	j--;
        // swap two numbers
        swap(num, i - 1, j);

        // reverse all numbers after the successor
        reverse(num, i, len - 1);
    }
    
    public void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    
    public void reverse(int[] num, int start, int end) {
        while (start < end) 
            swap(num, start++, end--);
    }
} }
}