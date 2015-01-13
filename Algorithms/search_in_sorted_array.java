/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
//Solution 1: basic binary search, exceeds time limits
public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int size = A.length;
        int l = 0;
        int r = size - 1;
        int pivot = l;
        while (l < r) {
            pivot++;
        }
        // binary search on two subarrays divided by th pivot
        if (target < A[pivot]) binarySearch(A, 0, pivot - 1, target);
        if (target > A[pivot]) binarySearch(A, pivot + 1, size - 1, target);
        if (target == A[pivot]) return pivot;
        return -1;
    }
    
    public int binarySearch(int[] A, int start, int end, int target) {
        int mid = (start + end) / 2;
        while (start <= end) {
            if (A[mid] < target) end = mid - 1;
            else if (A[mid] > target) start = mid + 1;
            else if (A[mid] == target) return mid;
        }
        return -1;
    }
}

// Solution 2: search without knowing the pivot
public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int size = A.length;
        int l = 0;
        int r = size - 1;
        
        while (l <= r) {
        // Avoid overflow, same as m = (l + r) / 2
        int m = l + (r - l) / 2; 
        if (A[m] == target) return m;
        
        // the bottom half is sorted
        if (A[l] <= A[m]) {
          if (A[l] <= target && target < A[m])
            r = m - 1;
          else
            l = m + 1;
        }
        // the upper half is sorted
        else {
          if (A[m] < target && target <= A[r])
            l = m + 1;
          else 
            r = m - 1;
            }
        }
        return -1;
    }
}