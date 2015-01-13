/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n < 1) return res;

        generateParenthesisRecur(n, 0, 0, "", res);
        return res;
    }

    public void generateParenthesisRecur(int n, int left, int right, String curString, List<String> res) {
    	if (left < right || left > n || right > n) return;
    	if (left == n && right == n) {
    		res.add(curString);
    		return;
    	}

    	if (left == n && left > right) {
    		generateParenthesisRecur(n, left, right + 1, curString + ")", res);
    		return;
    	}
    	
    	if (left < n && left >= right) {
    		generateParenthesisRecur(n, left + 1, right, curString + "(", res);
    		generateParenthesisRecur(n, left, right + 1, curString + ")", res);
    		return;
    	}
    }
}