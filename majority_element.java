/*
 ray of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 
 You may assume that the array is non-empty and the majority element always exist in the array.
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = num.length();
        
        for (int i = 0; i < size; i++) {
            if (map.get(num[i]) == null) map.put(num[i], 1);
            else {
                int count = map.get(num[i]);
                map.put(num[i], count + 1);
            }
            if (count > size / 2) return num[i];
        }
    }
}
