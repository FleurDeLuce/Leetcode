/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int size = A.length;
        int lastRed = 0;
        int firstBlue = size - 1;
        int i = 0;
        // check firstBlue since there might be no "2" in the array
        while (i <= firstBlue) {
            // if the lastRed is filled with a zero, it's guaranteed that 
            // elements before it and itself are all 0, thus nothing need to be changed before 
            // and i++ to move on
            if (A[i] == 0) swap(A, i++, lastRed++);
            // when firstBlue is filled with a two, only elements after it and itself are all 2
            // since we scan forward left to right, after swap an element with firstBlue
            // thus not move forward before we check the new i
            else if (A[i] == 2) swap(A, i, firstBlue--);
            else if (A[i] == 1) i++;
        }
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


