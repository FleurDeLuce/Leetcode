// Time Complexity: O(n^2), Space Complexity: O(n)
// Good explanation: https://www.youtube.com/watch?v=UfA_v0VmiDg
// http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
// Solution 1
public class Solution {
    public int numTrees(int n) {
        if (n < 2) return 1;
        int tree[] = new int[n + 1];
        tree[0] = 1;
        tree[1] = 1;
        // the selection of root each time decides the number of unique BST's
        // in each case, the number of BST is equal to 
        // the number of BST elements smaller than the root construct times
        // the number of BST elements larger than the root construct
        // summing all cases gives the total tree number
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