/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

//Time Complexity: O(n), Space Complexity: O(n)

// Think from top down, then
// minpathsum(2) = Math.min(3 + minpathsum(3), 4 + minpathsum(4))
// similarly, we can track down to the lowest level, then what we need is 
// bottom level: minpathsum(6) = Math.min(4, 1), minpathsum(5) = Math.min(1, 8), 
// minpathsum(7) = Math.min(8, 3)
// Therefore, the solution tracks bottom-up, and we can use dp to store intermediate path sum, i.e., minpathsum
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int levels = triangle.size();
        int[] minPathSum = new int[levels]; 
        // fill in the dp array with last row's elements
        int lastRowEle = triangle.get(levels - 1).size();
        for (int i = 0; i < lastRowEle; i++) {
            minPathSum[i] = triangle.get(levels - 1).get(i);
        }
        for (int i = levels - 2; i >= 0; i--) {
            int curRowEle = triangle.get(i + 1).size();
            for (int j = 0; j + 1 < curRowEle; j++) {
                // each time we just need to store next level's min path sum
                minPathSum[j] = triangle.get(i).get(j) + Math.min(minPathSum[j], minPathSum[j + 1]);
            }
        }
        return minPathSum[0];
    }
}