# [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## Description

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Note:** For the purpose of this problem, we define empty string as valid palindrome.

## Example

```
Input: "A man, a plan, a canal: Panama"
Output: true
```

```
Input: "race a car"
Output: false
```

## Solution

```java
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (!isAlphanumeric(chars[left])) {
                left++;
                if (left == right) {
                    return true;
                }
            }

            while (!isAlphanumeric(chars[right])) {
                right--;
                if (left == right) {
                    return true;
                }
            }

            if (lowerCase(chars[left]) != lowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return 'a' <= c && c <= 'z'
            || 'A' <= c && c <= 'Z'
            || '0' <= c && c <= '9';
    }

    private char lowerCase(char c) {
        return 'A' <= c && c <= 'Z' ? (char) (c - 'A' + 'a') : c;
    }
}
```

