# [Letter Combinations Of A Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## Description

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

## Example

```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

## Solution

#### Explanation

```java
class Solution {
    String[] digitLetters = {"", "", "abc", "def", 
                             "ghi", "jkl", "mno", 
                             "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        backtrack(result, digits.toCharArray(), "");
        return result;
    }
    
    public void backtrack(List<String> result, char[] digits, String s) {
        if (s.length() == digits.length){
            result.add(s);
            return; 
        }
        int i = s.length();
        int digit = digits[i] - '0';
        for (char letter : digitLetters[digit].toCharArray()) {
            backtrack(result, digits, s + Character.toString(letter));
        }
    }
}
```

