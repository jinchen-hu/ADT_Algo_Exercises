# [Decode String](https://leetcode.com/problems/decode-string/)

Given an encoded string, return its decoded string.

The encoding rule is: `k[encoded_string]`, where the *encoded_string* inside the square brackets is being repeated exactly *k* times. Note that *k* is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, *k*. For example, there won't be input like `3a` or `2[4]`.

**Example 1:**

```
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
```

**Example 2:**

```
Input: s = "3[a2[c]]"
Output: "accaccacc"
```

**Example 3:**

```
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
```

**Example 4:**

```
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
```

## Solution

```java
class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> needRepeats = new ArrayDeque<>();
        Deque<Integer> repeats = new ArrayDeque<>();
        int repeat = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                repeat = repeat*10 + c - '0';
            }else if(c == '['){
                repeats.push(repeat);
                repeat = 0;
                needRepeats.push(sb);
                sb = new StringBuilder();
            }else if(c == ']'){
                sb = needRepeats.pop().append(sb.toString().repeat(repeats.pop()));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

