/*
*/

// Solution 1: recursion
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n < 1 || k < 0 || k > n) return res;
        
        ArrayList<Integer> lastLevel = new ArrayList<Integer>(); 
        getComb(res, n, k, 1, lastLevel);
        return res;
    }
    
    public void getComb(ArrayList<ArrayList<Integer>> res, int n, int k, int start, ArrayList<Integer> lastLevel) {
        if (lastLevel.size() == k) {
            res.add(new ArrayList<Integer>(lastLevel));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            lastLevel.add(i);
            getComb(res, n, k, i + 1, lastLevel);
            lastLevel.remove(lastLevel.size() - 1);
        }
    }
}

// Solution 2: iterative