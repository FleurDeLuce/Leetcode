/*
 Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 
 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */

/*
public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> rangeList = new ArrayList<String>();
        int size = A.length;
        for (int i = 0; i < size - 1; i++) {
            int diff = A[i + 1] - A[i];
            if (diff == 0)
                rangeList.add(String.valueOf(A[i]));
            else if (diff == 2)
                rangeList.add(String.valueOf(A[i] + 1));
            else if (diff > 2)
                rangeList.add(getString(A[i] + 1, A[i + 1] - 1);
        }
        rangeList.add(getString());
        return rangeList;
    }
                              

    public String getString(int start, int end) {
        return start == end ? String.valueOf(start) : "" + start + "->" + end;
    }
}
                              
*/

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> rangeList = new ArrayList<String>();
        int size = A.length;
        // add 2 elements to the beginning and end to avoid pesky edge cases of the first and last element
        // insert extra element before the first element in array
        int prev = lower - 1;
        for (int i = 0; i <= size; i++) {
            // insert the extra element after the end of array
            int curr = (i == size) ? upper + 1 : A[i];
            if (curr - prev >= 2)
                rangeList.add(getString(prev + 1, curr - 1));
            prev = curr;
        }
        return rangeList;
    }
    
    
    public String getString(int start, int end) {
        return start == end ? String.valueOf(start) : "" + start + "->" + end;
    }
}

