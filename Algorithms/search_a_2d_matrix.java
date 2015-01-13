/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) return false;
        
        int start = 0, end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / cols;
            int midY = mid % cols;
            
            if (matrix[midX][midY] == target) return true;
            else if (matrix[midX][midY] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}