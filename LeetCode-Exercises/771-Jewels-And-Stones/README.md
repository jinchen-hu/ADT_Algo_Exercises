# [Jewels And Stones](https://leetcode.com/problems/jewels-and-stones/)

## Description

You're given strings `J` representing the types of stones that are jewels, and `S` representing the stones you have. Each character in `S` is a type of stone you have. You want to know how many of the stones you have are also jewels.

The letters in `J` are guaranteed distinct, and all characters in `J` and `S` are letters. Letters are case sensitive, so `"a"` is considered a different type of stone from `"A"`.

## Example

```
Input: J = "aA", S = "aAAbbbb"
Output: 3
```

```
Input: J = "z", S = "ZZ"
Output: 0
```

## Solution

```java
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(J.indexOf(S.charAt(i)) >= 0)
                count++;
        }
        return count;
    }
}
```

