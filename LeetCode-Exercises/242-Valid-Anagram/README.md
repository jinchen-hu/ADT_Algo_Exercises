# [Valid Anagram](https://leetcode.com/problems/valid-anagram/)

## Description

Given two strings *s* and *t* , write a function to determine if *t* is an anagram of *s*.

## Example

```
Input: s = "anagram", t = "nagaram"
Output: true
```

```
Input: s = "rat", t = "car"
Output: false
```

## Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        char sChar[] = s.toCharArray();
        char tChar[] = t.toCharArray();
        int table[] = new int[26];
        for(char sLetter: sChar){
            table[sLetter - 'a']++;
        }
        
        for(char tLetter: tChar){
            if(--table[tLetter - 'a'] < 0)
                return false;
        }
        return true;
    }
}
```

