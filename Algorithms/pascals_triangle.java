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
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();      
        if(numRows == 0) return result;
        
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> thisRow = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0) thisRow.add(1);
                else if(j < i){
                    int thisNum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    thisRow.add(thisNum);
                }
                else if(j == i) thisRow.add(1);                
            }
            result.add(thisRow);
        }        
        return result;       
    }
}


// solution 2
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            if(i > 0) {
                for(int j = 0; j < res.get(i - 1).size() - 1; j++) {
                    temp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
                }
            temp.add(1);
            }
            
            res.add(temp);
        }
        return res;
    }
}