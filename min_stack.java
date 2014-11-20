/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    // each time after one pushing or popping, the min element could be retrieved in constant time
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        /*
         if (minStack.peek() < x) {
         minStack.push(minStack.peek());
         }
         */
    }
    
    public void pop() {
        // check if minStack needs to pop
        // stack needs to pop anyway
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        // top element not popped out
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

