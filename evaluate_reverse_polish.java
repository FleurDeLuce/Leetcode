/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
// Solution 1: iterative with stack
// time: O(n), space: O(logn)
// all operators and numbers of the array, n in total, end with a binary tree
// thus the stack to hold numbers has depth of tree height
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<Integer>();
        for (String tk : tokens) {
            if (!isOperator(tk)) st.push(Integer.parseInt(tk));
            else st.push(calc(st.pop(), st.pop(), tk));
        }
        return st.pop();
    }
    
    public boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/"));
    }
    
    public int calc(int a, int b, String op) {
        switch (op.charAt(0)) {
            case '+': 
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
            default:
                return 0;
        }
    }
}

// Solution 2: recursive
// time: O(n), space: O(logn)
