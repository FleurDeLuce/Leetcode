/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */

// Solution
// Time complexity: O(n!), Space complexity: O(n)

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if (n < 1 || n == 2 || n == 3) return res;

        int[] queenColAtRow = new int[n];
        solveNQueensRecur(n, 0, queenColAtRow, res);
        return res;
    }

    public void solveNQueensRecur(int n, int curRow, int[] queenColAtRow, ArrayList<String[]> res) {
    	if (curRow == n) {
    		res.add(generateMap(n, queenColAtRow));
    		return;
    	}
    	// for each row, check if column satisfied one by one
    	// in time complexity calculation, in each for loop, as previously added one more queen, thus
    	// one fewer column to be checked in confliction avoidance
    	// n * (1 + (n - 1) * (2 + (n - 2) * 3 + ... + n * 1 ))...) = O(n!)
    	for (int col = 0; col < n; col++) {
    		queenColAtRow[curRow] = col;
    		if (ifNotConflict(curRow, queenColAtRow)) solveNQueensRecur(n, curRow + 1, queenColAtRow, res);
    	}
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

    public String[] generateMap(int n, int[] queenColAtRow) {
    	String[] map = new String[n];
    	for (int row = 0; row < n; row++) {
    		String line = "";
    		int queenCol = queenColAtRow[row];
    		for (int col = 0; col < n; col++) {
 				if (col != queenCol) line += ".";
 				else line += "Q"; 
    		}
    		map[row] = line;
    	}
    	return map;
    }
}

// Solution 2
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>(); 
        if (n == 2 || n == 3) return res;
        solveNQueens(0, new int[n], res);
        return res;
    }
    
    public void solveNQueens(int cur, int[] row, ArrayList<String[]> res) {
        int n = row.length;
        if (cur == n) {
            res.add(generateSol(row));
            return;
        }
        for(int i=0;i<n;i++){
            boolean valid = true;
            row[cur] = i;
            for (int j = 0; j < cur; j++){
                if (row[cur] == row[j] || cur - row[cur] == j - row[j] || cur + row[cur] == j + row[j]) {
                    valid = false;
                    break;
                }
          }
          if(valid) solveNQueens(cur + 1, row, res);
        }       
    }
    
    public String[] generateSol(int[] row){
        int n = row.length;
        String[] sol = new String[n];
        for(int i = 0; i < n; i++){
            String line = "";
            for (int j = 0; j < n; j++)
                if (j == row[i]) line += "Q";
                else line += ".";
            sol[i] = line;                
        }
        return sol;
    }
}