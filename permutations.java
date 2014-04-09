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
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        return getNextPerm(num, 0);
    }

    public void getNextPerm(int[] num, int start) {
        int size = num.length;
        ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
        if (start == size) {
            cur.add(permutations);
            return cur;
        }

        cur = getNextPerm(num, start + 1)
        for (ArrayList<Integer> p : cur) {
            for (int i = 0; i < cur.size() + 1; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(p);
                temp.add(i, num[start]);
                cur.add(temp);
            }
        }
    }
}



// iterative solution 1
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        permutation.add(num[0]);
        res.add(permutation);
     
        // numbers to insert in each iteration
        for (int i = 1; i < num.length; i++) {
            // clear nextPermutation from last time
            ArrayList<ArrayList<Integer>> nextPermuations = new ArrayList<ArrayList<Integer>>();
            // store current iteration's all unfinished permuatations
            // res is the same as last level of unfinished permutations
            for (ArrayList<Integer> p: res) {
                for (int j = 0; j < p.size() + 1; j++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(p);
                    temp.add(j, num[i]);
                    // must use deep copy to avoid changes to p in nextPermuations
                    // if use p.add(j, num[i]) to add and p.remove(j)
                    nextPermuations.add(new ArrayList<Integer>(temp)); 
                    // remove num[i] to insert it for the next insertion in different slot
                }
            }
            res = nextPermuations;
        } 
        return res;
    }
}



// iterative solution 2
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //start from an empty list
        res.add(new ArrayList<Integer>());
     
        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : res) {
                // number of insertion slot is the largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // add num[i] to different locations
                    l.add(j, num[i]); 
                    cur.add(new ArrayList<Integer>(l)); 
                    // remove num[i] to insert it for the next insertion in different slot
                    l.remove(j);
                }
            }   
            res = new ArrayList<ArrayList<Integer>>(cur);
        } 
        return res;
    }
}