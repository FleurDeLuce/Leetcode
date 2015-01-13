/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1) return res;

    }
}


public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        for(int i = 1; i <= rowIndex; i++){
            row[i] = 1;
            for(int j = i - 1; j > 0; j--)
                row[j] = row[j] + row[j - 1];
        }
        return new ArrayList<Integer>(Arrays.asList(row));
    }
}