/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// recursive solution 1: backward
// the max subproblem is n - 1, by inserting the 1st element to following n - 1 
/* 
   recursion notes:
   1. in main function, call recursive function from the topmost subproblem, 
      which is called first but handled last in the function call stack
   2. in recursive function:
      1> the base case is the subproblem called last but handled first 
      2> in other cases, the parameter changes in the way of reducing subproblem
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        return getPerm(num, 0);
    }

    public ArrayList<ArrayList<Integer>> getPerm(int[] num, int start) {
        int size = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();    
        if (start == size - 1) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(num[size - 1]);
            res.add(temp);
            return res;
        }

        ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
        cur = getPerm(num, start + 1);
        for (ArrayList<Integer> p : cur) {
            for (int i = 0; i < p.size() + 1; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(p);
                temp.add(i, num[start]);
                res.add(temp);
            }
        }
        return res;
    }
}

// recursive solution 2: forward
// the max subproblem is n - 1, by inserting nth element to first n - 1

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return res;
        return getPerm(num, num.length - 1);
    }

    public ArrayList<ArrayList<Integer>> getPerm(int[] num, int start) {
        int size = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();    
        if (start == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(num[0]);
            res.add(temp);
            return res;
        }

        ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
        cur = getPerm(num, start - 1);
        for (ArrayList<Integer> p : cur) {
            for (int i = 0; i < p.size() + 1; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(p);
                temp.add(i, num[start]);
                res.add(temp);
            }
        }
        return res;
    }
}

// iterative solution 1
// time complexity: O(n*n*(n-1)!) = O(n*n!)
// space complexity: O(n!)
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
