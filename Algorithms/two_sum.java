/*
 Given an array of integers, find two numbers such that they add up to a specific target number.
 
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 
 You may assume that each input would have exactly one solution.
 
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (table.get(numbers[i]) == null) table.put(target - numbers[i], i);
            else {
                res[0] = table.get(numbers[i]) + 1;
                res[1] = i + 1;
            }
        }
        return res;
    }
    
}

// More complete solution with exception handling
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[] {map.get(target - x) + 1, i + 1};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
