# [Length Of Last Word](https://leetcode.com/problems/length-of-last-word/)

## Description

Given a string *s* consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a **maximal substring** consisting of non-space characters only.

## Example

```
Input: "Hello World"
Output: 5
```

## Solution 1

#### Explanation

* Uses split method to split string as an array with the delimiter " "

```java
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0)
            return 0;
        String words[] = s.split(" ");
        return words[words.length - 1].length();
    }
}
```

## Solution 2

1. Traverse the string from the end
2. If the current character is " " and the length is not 0, break. This means we have read the last word and all invalid spaces (like trimLast())

```java
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = 0;
        for(int i = s.length() - 1; i >=0; --i){
            if(s.charAt(i) != ' ')
                len++;
            else if (len == 0)
                continue;
            else
                break;
        }
        return len;
    }
}
```

