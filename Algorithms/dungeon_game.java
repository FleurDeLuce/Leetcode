/*
 The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 
 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 
 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 
 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 
 
 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 
 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 
 -2 (K)	-3	3
 -5	-10	1
 10	30	-5 (P)
 
 Notes:
 
 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */

// Solution: dynamic programming
//
// Time complexity: O(m*n), Space complexity: O(m*n)
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] hp = new int[m][n];
        // dynamic programming from the botoom-left square
        // only the last square is 1 - dungeon[m - 1][n - 1], which guarantees all squares before it is "1 + " - hp[m][n]
        hp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        
        // move upward
        for (int i = m  - 2; i >= 0; i--) {
            /* if dungeon[i][n - 1] is negative, then hp[i - 1][n - 1], which is knight walks before entering the dungeon[i][n - 1] square, should be - dungeon[i][n - 1] + 1;
             if it is positive or 0, then hp[i - 1][n - 1] is 1
             */
            hp[i][n - 1] = Math.max(hp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        
        // move rightward
        for (int j  =  n - 2; j >= 0; j--) {
            // current square HP         the square before's HP   current square dungeon value
            hp[m - 1][j] = Math.max(hp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        
        // move downward and rightward again
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(hp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(hp[i][j + 1] - dungeon[i][j], 1);
                // choose the direction, downward or rightward, whose cost is less
                hp[i][j] = Math.min(down, right);
            }
        }
        return hp[0][0];
    }
}