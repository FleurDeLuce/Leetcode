/*
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 
 You may assume that each input would have exactly one solution.
 
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

// Solution 1: Binary Search
// Time complexity: O(nlog(n)), for each of the n numbers, binary search takes log(n) time
// Space complexity: O(1)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = bsearch(numbers, target - numbers[i],  i + 1);
            if (j != -1) {
                return new int[] { i + 1, j + 1 };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    private int bsearch(int[] A, int key, int start) {
        int L = start, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < key) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && A[L] == key) ? L : -1;
    }
}

// Solution 2: Two Pointers
// Time complexity: O(n), space complexity: O(1)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{left + 1, right + 1};
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}