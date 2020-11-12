# [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

Given an array of integers `nums` and an integer `k`, return *the total number of continuous subarrays whose sum equals to `k`*.

 

**Example 1:**

```
Input: nums = [1,1,1], k = 2
Output: 2
```

**Example 2:**

```
Input: nums = [1,2,3], k = 3
Output: 2
```

 ## Solution

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum += num;
            count += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
```

