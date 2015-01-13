/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
*/

/*
The rule of Sudoku: 1. Each row must have the number 1-9 occuring just once.

　　　　　　　　　     2. Each column must have the number 1-9 occuring just once.

　　　　　　　　　     3. The number 1-9 must occur just once in each of sub-boxes of the grid.
*/
/*
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return false;

        int row_num = board.length;
        int col_num = board[0].length;

        // check row
        for (int i = 0; i < col_num; i++) {

        }

        // check colum
        for (int i = 0; i < row_num; i++) {

        }

        // check each square

    }
}
*/
public class Solution {
    public boolean isValidSudoku(char[][] board){
            boolean [][] rows=new boolean[9][9];
            boolean [][] cols=new boolean[9][9];
            boolean [][] blocks=new boolean[9][9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    rows[i][j] = false;
                    cols[i][j] = false;
                    blocks[i][j] = false;
                }
            }
            for (int i = 0; i < 9; ++i) {  
                for (int j = 0; j < 9; ++j) {
                    int c = board[i][j] - '1';
                    if (board[i][j] == '.') continue;  
                    if (rows[i][c] || cols[j][c] || blocks[i - i % 3 + j / 3][c])  
                        return false;  
                    rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;  
                }  
            }  
            return true;  
        }
}


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][] table = new int[27][9];
        int [][] squareIndex = new int [][] {{0,1,2}, {3,4,5}, {6,7,8}};
        for(int i=0; i<9; i++){ // rows
            for(int j=0; j<9; j++){ // cols
                if(board[i][j]=='.')
                    continue;
                if(!Character.isDigit(board[i][j]))
                    return false;
                int val = Character.getNumericValue(board[i][j]);
                // Rows
                if(table[i][val-1]!=0)
                    return false;
                table[i][val-1]=1;
                // Columns
                if(table[j+9][val-1]!=0)
                    return false;
                table[j+9][val-1]=1;
                // Squares
                int sNdx = squareIndex[i/3][j/3];
                if(table[sNdx+18][val-1]!=0)
                    return false;
                table[sNdx+18][val-1]=1;
            }
        }
        return true;
    }
}
