# [Min Stack](https://leetcode.com/problems/min-stack/)

## Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- push(x) -- Push element x onto stack.
- pop() -- Removes the element on top of the stack.
- top() -- Get the top element.
- getMin() -- Retrieve the minimum element in the stack.

## Example

```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

## Solution

```java
class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if(min.isEmpty() || x <= min.peek())
            min.push(x);
        main.push(x);
    }
    
    public void pop() {
        if(main.pop().equals(min.peek()))
            min.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

