# [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Description

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

## Example

```
Input: s = "()[]{}"
Output: true
```

```
Input: s = "([)]"
Output: false
```

## Solution

```java
class Solution {
    public boolean isValid(String s) {
        //if the string is empty, return true
        if(s == null || s.length() == 0)
            return true;
        //if the length of string is odd, return false
        int len = s.length();
        if(len % 2 == 1)
            return false;
        //create a stack that stores character type
        Stack<Character> stack = new Stack<>();
        
        //traverse the string
        for(int i = 0; i < len; ++i){
            char c = s.charAt(i);
            //if it is open parenthese, add in the stack
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if(c == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(c == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(c == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
}
```

