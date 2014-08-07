/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */

// Solution: 
// Time complexity: O(), Space complexity: O()
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0 || target < 1) 
            return res;
        // sort the candidate array
        Arrays.sort(candidates);
         ArrayList<Integer> index = new ArrayList<Integer>(); 
        getCombinationSum(target, 0, 0, candidates, index, res);
        return res;
    }
    
    public void getCombinationSum(int target, int curSum, int curIndex, int[] candidates, 
                                ArrayList<Integer> index, ArrayList<ArrayList<Integer>> res) {
        if (curSum > target) return;
        if (curSum == target) {
        	res.add(index);
        	return;
        }
        int num = curSum.length();
        for (int i = curIndex; i < n; i++) {
        	index.add(i);
        	getCombinationSum(target, curSum + candidates[i], curIndex + 1, candidates, index, res);
        }
    }
}