// Time Complexity: O(n^2), Space Complexity: O(1)
// Solution 1
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length || matrix.length <= 1) return;
        int num = matrix.length;
        for (int layer = 0; layer < num / 2; layer++) {
            int first = layer;
            int last = num - 1 - layer;
            for (int i = first; i < last; i++) {
                // store top edge
                // the first row in this round is stored from left to right
                int top = matrix[first][i];
                // the first row (left to right) is replaced by first column (bottom to up)
                matrix[first][i] = matrix[num - 1 - i][first];
                // the first column (bottom to up) is replaced by last row (right to left)
                matrix[num - 1 - i][first] = matrix[last][num - 1 - i];
                // the last row (right to left) is replaced by the last column (top to bottom) 
                matrix[last][num - 1 - i] = matrix[i][last];
                // the last column (top to down) is replaced by the first row (left to right)
                matrix[i][last] = top;
            }
        }
    }
} 

// Solution 2
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length || matrix.length <= 1) return;
        int num = matrix.length;
        for (int layer = 0; layer < num / 2; layer++) {
            int first = layer;
            int last = num - 1 - layer;
            for (int i = first; i < last; i++) {
                // store top edge
                int top = matrix[layer][i];
                // left edge to top
                // top edge is replaced from left to right
                matrix[layer][i] = matrix[num - 1 - i][layer];
                // bottom edge to left
                // left edge is replaced from bottom to top
                matrix[num - 1 - i][layer] = matrix[num - 1 - layer][num - 1 - i];
                // right edge to bottom
                // bottom edge is replaced from right to left
                matrix[num - 1 - layer][num - 1 - i] = matrix[i][num - 1 - layer];
                // top edge to right
                // right edge is replaced from top to bottom
                matrix[i][num - 1 - layer] = top;
            }
        }
    }
}

// Solution 3
// First rotate by the antidiagonal, then upside down; or switch