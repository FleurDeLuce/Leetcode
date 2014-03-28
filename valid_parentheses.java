/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() %2!=0) return false;
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c== '(' || c=='[' || c=='{')
                stack.push(c);
            else if (c== ')'){
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                else stack.pop();
            } 
            else if (c== ']'){
                if(stack.isEmpty() ||stack.peek() != '[')
                    return false;
                else stack.pop();
            }
            else if (c== '}'){
                if(stack.isEmpty() ||stack.peek() != '{')
                    return false;
                else stack.pop();
            } 
        }
        return stack.isEmpty();
    }
}