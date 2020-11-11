# [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string **s** and a **non-empty** string **p**, find all the start indices of **p**'s anagrams in **s**.

Strings consists of lowercase English letters only and the length of both strings **s** and **p** will not be larger than 20,100.

The order of output does not matter.

**Example 1:**

```
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```



**Example 2:**

```
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

## Solution

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()==0 || s.length() < p.length())
            return res;
        
        int[] arr = new int[26];
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int count = ps.length;
        int start = 0;
        for(char c : ps){
            arr[c-'a']++;
        }
        for(int i = 0; i < ss.length; i++){
            if(arr[ss[i]-'a'] > 0)
                count--;
            arr[ss[i]-'a']--;
            // if matching, update start
            while(count == 0){
                if(i-start+1 == ps.length)
                    res.add(start);
                if(++arr[ss[start++]-'a'] > 0)
                    count++;
                //start++;
            }
        }
        return res;
    }
}

```

