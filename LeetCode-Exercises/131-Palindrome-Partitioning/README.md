# [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

Given a string *s*, partition *s* such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of *s*.

**Example:**

```
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
```

## Solution 1

```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s == "")
            return res;
        backtracking(res, new ArrayList<String>(), s, 0);
        return res;
    }
    private void backtracking(List<List<String>> res, List<String> cur, String s, int start){
        if(start >= s.length())
            res.add(new ArrayList<>(cur));
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(start, i, s)){
                cur.add(s.substring(start, i+1));
                backtracking(res, cur, s, i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(int r, int l, String s){
        while(r < l){
            if(s.charAt(r++) != s.charAt(l--))
                return false;
        }
        return true;
    }
}
```

## Solution 2

```java
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
```

