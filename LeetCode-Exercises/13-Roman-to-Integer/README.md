# [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)

## Description

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, `2` is written as `II` in Roman numeral, just two one's added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9. 
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90. 
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

## Example

```
Input: s = "III"
Output: 3
```

```
Input: s = "IV"
Output: 4
```

```
Input: s = "IX"
Output: 9
```

```
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```

```
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## Solution

```java
class Solution {
    public int romanToInt(String s) {
       if(s == null || s.length() == 0)
           return 0;
        int res = 0;
        char prev = '*';
        for(int i = 0; i < s.length(); i++){
            res += helper(s.charAt(i), prev);
            prev = s.charAt(i);
        }
        return res;
    }
    
    private int helper(char curr, char prev){
        if(curr == 'I')
            return 1;
        if(curr == 'V')
            return prev == 'I' ? 3 : 5;
        if(curr == 'X')
            return prev == 'I' ? 8 : 10;
        if(curr == 'L')
            return prev == 'X' ? 30 : 50;
        if(curr == 'C')
            return prev == 'X' ? 80: 100;
        if(curr == 'D')
            return prev == 'C' ? 300: 500;
        if(curr == 'M')
            return prev == 'C' ? 800: 1000;
        return 0;
    }
}
```

