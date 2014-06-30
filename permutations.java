/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// recursive solution: insert in all positions of (n - 1)
// recursive solution
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        getPermutation(num, permutation, res);
    }
    
    public void getPermutation(int[] num, ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> res) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int size = num.length;
        if (permutation.size() == len) {
            res.add(permutation);
        }
        if (permutation.size() == 0) {
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            
        }
    }
    
    public ArrayList<Integer> insertAllPositions() {
        
    }
}

// recursive solution: swap



// iterative solution
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //start from an empty list
        result.add(new ArrayList<Integer>());
     
        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                // number of insertion slot is the largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // add num[i] to different locations
                    l.add(j, num[i]); 
                    ArrayList<Integer> calPermute = new ArrayList<Integer>(l);
                    current.add(calPermute); 
                    // remove num[i] to insert it for the next insertion in different slot
                    l.remove(j);
                }
            }   
            result = new ArrayList<ArrayList<Integer>>(current);
        } 
        return result;
    }
}