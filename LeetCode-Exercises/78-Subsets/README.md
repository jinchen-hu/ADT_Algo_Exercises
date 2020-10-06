# [Subsets](https://leetcode.com/problems/subsets/)

## Description

Given a set of **distinct** integers, *nums*, return all possible subsets (the power set).

**Note:** The solution set must not contain duplicate subsets.

## Example

```
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

## Solution

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> l, int[] nums, int start){
        res.add(new ArrayList<>(l));
        for(int i = start; i < nums.length; i++){
            l.add(nums[i]);
            helper(res, l, nums, i+1);
            l.remove(l.size()-1);
        }
    }
}
```

