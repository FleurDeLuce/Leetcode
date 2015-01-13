/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

// Solution 1
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String res = new String();
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String dir : dirs) {
            if (dir.length() == 0 || dir.equals(".")) continue;
            else if (dir.equals("..")) {
                // return to its parent directory
                if (!stack.empty()) stack.pop();
            }
            else {
                stack.push(dir);
            }
        }
        if (stack.empty()) return "/";

        // reconstruct path string
        Stack<String> reverseStack = new Stack<String>();
        while (!stack.empty()) {
            reverseStack.push(stack.pop());
        }

        while (!reverseStack.empty()) {
            res += "/" + reverseStack.pop();
        }
        return res;
    }
}

// Solutio 2
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String res = new String();
        String[] dirs = path.split("/");
        LinkedList<String> stack = new LinkedList<String>();
        for (String dir : dirs) {
            if (dir.length() == 0 || dir.equals(".")) continue;
            else if (dir.equals("..")) {
                // return to its parent directory
                if (!stack.isEmpty()) stack.pop();
            }
            else {
                stack.push(dir);
            }
        }
        if (stack.isEmpty()) return "/";

        // reconstruct path string
        while (!stack.isEmpty()) {
            res += "/" + stack.removeLast();
        }
        return res;
    }
}

// Solution 3
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String str = new String();
        int len = path.length();
        for (int i = 0; i < len; i++) {
            if (path.charAt(i))
        }
        return str;
    }
}