/*
 A peak element is an element that is greater than its neighbors.
 
 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 
 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 
 You may imagine that num[-1] = num[n] = -∞.
 
 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.s
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
// brute force method
public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        if (num.length < 3) {
            if (num[1] > num[0]) {
                return 1;
            }
            return 0;
        }
        
        // find the peak element in a group of 3
        int i = 0;
        int size = num.length;
        while (i < size - 3) {
            if (num[i] < num[i + 1] && num[i + 2] < num[i + 1]) {
                return i;
            }
            i++;
        }
        return 0;
    }
}



// Time complexity: O(log(n)), Space complexity: O(1)
// divide and conquer method, similar to binary search
public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        
        int low = 0;
        int high = num.length - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            // if mid is the peak
            if (num[mid - 1] < num[mid] && num[mid + 1] < num[mid])
                return mid;
            
            // if mid is not the peak, then the peak must be in the left or right half
            // if mid is smaller than the left neighbor, then the peak is in the left half, eithe peak or rising
            // otherwise peak is in the right half
            if(num[mid] < num[mid - 1] && mid >= 1)
                high = mid;
            else low = mid;
        }
        return num[low] > num[high] ? low : high;
    }
}

