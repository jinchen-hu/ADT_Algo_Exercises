# [Combination Sum](https://leetcode.com/problems/combination-sum/)

## Description

Given a **set** of candidate numbers (`candidates`) **(without duplicates)** and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

The **same** repeated number may be chosen from `candidates` unlimited number of times.

**Note:**

- All numbers (including `target`) will be positive integers.
- The solution set must not contain duplicate combinations.

## Example

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```

```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

## Solution

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target < 0 || candidates == null || candidates.length == 0)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
        
    }
    private void helper(List<List<Integer>> res, ArrayList<Integer> comb, int[] cand, int target, int index){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(target < 0)
            return;
        for(int i = index; i < cand.length; i++){
            if(target < cand[i])
                break;
            comb.add(cand[i]);
            helper(res, comb, cand, target-cand[i], i);
            comb.remove(comb.size()-1);
        }
    }
}
```

