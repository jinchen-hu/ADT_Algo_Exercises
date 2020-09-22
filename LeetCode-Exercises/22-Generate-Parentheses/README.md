# [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

## Description

Given *n* pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

## Example

For example, given *n* = 3, a solution set is:

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

## Solution

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        if(n==0)
            return null;
        List<String> list = new LinkedList<>();
        helper(list, "", 0, 0, n);
        return list;
    }
    private void helper(List<String> list, String cur, int left, int right, int n){
        if(right == n){
            list.add(cur);
            return;
        }
        if(left < n)
            helper(list, cur+"(", left+1, right, n);
        if(right < left)
            helper(list, cur+")", left, right+1, n);
    }
}
```

