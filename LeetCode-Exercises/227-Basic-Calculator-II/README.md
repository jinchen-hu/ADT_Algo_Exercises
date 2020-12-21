# [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)

Given a string `s` which represents an expression, *evaluate this expression and return its value*. 

The integer division should truncate toward zero.

 

**Example 1:**

```
Input: s = "3+2*2"
Output: 7
```

**Example 2:**

```
Input: s = " 3/2 "
Output: 1
```

**Example 3:**

```
Input: s = " 3+5 / 2 "
Output: 5
```

## Solution

```java
class Solution {
    public int calculate(String s) {
        if(s == null || s.length()==0)
            return 0;
        int res = 0, cur = 0, pre = 0;
        char op = '+';
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = s.charAt(i);
            if(c >= '0' && c<='9')
                cur = cur*10 + c - '0';
         
            if( "+-*/".indexOf(c) >= 0 || i == chars.length - 1){
                if(op == '+'){
                    res += pre;
                    pre = cur;
                }else if(op == '-'){
                    res += pre;
                    pre = -cur;
                }else if(op == '*'){
                    pre *= cur;
                }else if(op == '/'){
                    pre /= cur;
                }
                op = c;
                cur = 0;
            }
        }
        return res+pre;
    }
}
```

