# [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)

## Description

Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

## Example

```
s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
```

## Solution 1

#### Explanation

1. Create a HashMap storing char/occurance
2. Traverse the string
   * if the current character is in the map, update the key
   * else, add it in the map
3. Traverse the string to find the first element that occurs one

```java
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s == "")
            return -1;
        if(s.length() == 1)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else{
                map.put(c, 1);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
```

## Solution 2

#### Explanation

1. Since the given string only contains lowercase letters, we can use a int array to store the occurrance
2. Cross through the array to store the frequency of each letter
3. Cross through the array to find the first element that occurs once

```java
class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s == "")
            return -1;
        if(s.length() == 1)
            return 0;
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        for(int i = 0; i<s.length(); i++){
            if(count[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
```

