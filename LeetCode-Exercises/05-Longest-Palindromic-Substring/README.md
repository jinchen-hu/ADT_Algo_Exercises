# [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

## Description

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

## Example

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

## Solution

#### Explanation

1. Two kinds of palindromes, odd length and even length
2. Experiment from the first centre
   1. The first element for odd length
   2. The first two elements for even length
3. Extends the substring to the two sides
4. Compare the length and update the longest substring each time

* Time Complexity: O(n*2)
* Space Complexity: O(n*2)

```java
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s == "" || s.length() <=1)
            return s;
        String longest = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            int left = i, right = i;
            //odd length
            String oddLongest = helper(s, i, i);
            //even length
            String evenLongest = helper(s, i, i+1);
            String temp = oddLongest.length() > evenLongest.length() ? oddLongest : evenLongest;
            if(temp.length() > longest.length())
                longest = temp;
        }
        return longest;
    }
    
    public String helper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
```

