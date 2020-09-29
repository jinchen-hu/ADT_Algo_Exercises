# [Combinations](https://leetcode.com/problems/combinations/)

## Description

Given two integers *n* and *k*, return all possible combinations of *k* numbers out of 1 ... *n*.

You may return the answer in **any order**.

## Example

```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

```
Input: n = 1, k = 1
Output: [[1]]
```

## Solution

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || k > n)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> temp, int start, int n, int k){
        if(k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i <= n; ++i){
            temp.add(i);
            helper(res, temp, i+1, n, k-1);
            temp.remove(temp.size() -1);
        }
    }
}
```

