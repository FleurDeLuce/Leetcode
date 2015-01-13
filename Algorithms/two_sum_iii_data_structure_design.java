/*
 Design and implement a TwoSum class. It should support the following operations: add and find.
 
 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.
 
 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
 */

// Solution 1: store pairs and pair sum in a hashtable
// store all possible pair (C(n, 2)) sums in a hashtable, thus find is O(1) time
// store all newly added elements into a list, thus add is O(n) time
// in total, space is O(n^2) for the hashtable
// best for: when find operation exceeds add


// Solution 2: binary search + two pointers
// store all newly added elements in a sorted array, thus add is O(log(n))
// use two pointers to scan the sorted array, thus find is O(n)
// space is O(n) for the sorted array


// Solution 3: store input into a hashtable
// find is O(n) for iteration of the hashtable
// add is O(1)
// Space complexity: O(n)
public class TwoSum {
    private HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
    
    public void add(int number) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count + 1);
    }
    
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer>  entry : table.entrySet()) {
            int num = entry.getKey();
            int y = val - num;
            if (y == num) {
            }
        }
    }
}
