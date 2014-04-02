// Time Complexity: O(n^2), Space Complexity: O(n)
// Solution 1
public class Solution {
    public int numTrees(int n) {
        if (n < 2) return 1;
        int tree[] = new int[n + 1];
        tree[0] = 1;
        tree[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                tree[i] += tree[j] * tree[i - 1 - j];
            }
        }
        return tree[n];
    }
}

// Solution 2: Catalan Number
/*
public class Solution {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        return factor(2 * n) / (factor(n + 1) * factor(n));
    }
    
    public int factor(int n) {
        if (n < 1) return 1;
        int[] factor = new int[n + 1];
        factor[1] = 1;
        for (int i = 2; i <= n; i++) {
            factor[i] = n * factor[i - 1];
        }
        return factor[n];
    }
}
*/