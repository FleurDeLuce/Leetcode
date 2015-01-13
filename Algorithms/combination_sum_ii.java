/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

// Solution: 
// Time complexity: O(n!), Space complexity: O(n)
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0 || target < 1) 
            return res;
        // sort the candidate array to prevent duplicate solutions
        Arrays.sort(num);
         ArrayList<Integer> curList = new ArrayList<Integer>(); 
        getCombinationSum(target, 0, 0, num, curList, res);
        return res;
    }
    
    public void getCombinationSum(int target, int curSum, int start, int[] num, 
                                ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> res) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        int size = num.length;
        // prevent duplicate solutions (same elements in different order)
        for (int i = start; i < size; i++) {
            if (num[i] > target) break;
            // prevent duplicate solutions (same elements from num array)
            if (i > start && num[i] == num[i - 1]) continue;
            curList.add(num[i]);
            // each time, add all num from certain start index to current list for new current sum
            getCombinationSum(target, curSum + num[i], i + 1, num, curList, res);
            curList.remove(curList.size() - 1);
        }
    }
}