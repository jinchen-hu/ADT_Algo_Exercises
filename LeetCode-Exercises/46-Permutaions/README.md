# [Permutations](https://leetcode.com/problems/permutations/)

## Description

Given a collection of **distinct** integers, return all possible permutations.

## Example

```
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## Solution

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> comb, int[] nums){
        if(comb.size() == nums.length){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(comb.contains(nums[i]))
                continue;
            comb.add(nums[i]);
            helper(res, comb, nums);
            comb.remove(comb.size() - 1);
        }
    }
}
```

