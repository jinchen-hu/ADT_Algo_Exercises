# [Number of Good Pairs](https://leetcode.com/problems/number-of-good-pairs/)

Given an array of integers `nums`.

A pair `(i,j)` is called *good* if `nums[i]` == `nums[j]` and `i` < `j`.

Return the number of *good* pairs.

 

**Example 1:**

```
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
```

**Example 2:**

```
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
```

**Example 3:**

```
Input: nums = [1,2,3]
Output: 0
```

## Solution

```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums){
            if(map.containsKey(i)){
                res += map.get(i);
                map.put(i, map.get(i)+1);
            } else{
                map.put(i,1);
            }
        }
        return res;
    }
}
```

