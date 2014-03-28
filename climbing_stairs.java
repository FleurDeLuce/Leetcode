/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
// recursive way
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        int prev = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur += prev;
            prev = temp;
        }
        return cur;
    }
}

// recursive way
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}