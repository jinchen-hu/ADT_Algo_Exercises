# [Palindrome Number](https://leetcode.com/problems/palindrome-number/)

## Description

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

## Example

```
Input: 121
Output: true
```

```
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

## Solution 1

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while(left < right) {
        	Character leftChar = s.charAt(left++);
        	Character rightChar = s.charAt(right--);
        	if(leftChar == rightChar)
        		continue;
        	else
        		return false;
        }
        return true;
    }
}
```

## Solution 2

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x <10) return true;
        int a = 0;
        int b = x;
        while(x != 0){
            a = a*10 + x % 10;
            x = x / 10;
        }
        return a == b;
    }
}
```

