/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */

// Solution
// Time complexity: O(n!), Space complexity: O(n)

public class Solution {
    public int totalNQueens(int n) {
        if (n < 1 || n == 2 || n == 3) return 0;
        int[] queenColAtRow = new int[n];
        return totalNQueensRecur(n, 0, queenColAtRow);
    }

    public int totalNQueensRecur(int n, int curRow, int[] queenColAtRow) {
        int sum = 0;
        if (curRow == n) {
            return 1;
        }
        // for each row, check if column satisfied one by one
        // in time complexity calculation, in each for loop, as previously added one more queen, thus
        // one fewer column to be checked in confliction avoidance
        // n * (1 + (n - 1) * (2 + (n - 2) * 3 + ... + n * 1 ))...) = O(n!)
        for (int col = 0; col < n; col++) {
            queenColAtRow[curRow] = col;
            if (ifNotConflict(curRow, queenColAtRow)) sum += totalNQueensRecur(n, curRow + 1, queenColAtRow);
        }
        return sum;
    }

    public Boolean ifNotConflict(int curRow, int[] queenColAtRow) {
        for (int row = 0; row < curRow; row++) {
            // check if two queens sharing the same column
            if (queenColAtRow[row] == queenColAtRow[curRow]) return false;
            // check if sharing diagonal and anti-diagonal
            if (Math.abs(queenColAtRow[row] - queenColAtRow[curRow]) == Math.abs(row - curRow)) return false;
        }
        return true;
    }
}