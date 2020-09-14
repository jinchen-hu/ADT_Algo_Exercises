# [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

## Description

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return *its sum*.

**Follow up:** If you have figured out the `O(n)` solution, try coding another solution using the **divide and conquer** approach, which is more subtle.

## Example

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

## Solution 1

## Explanation

1. State transition: dp[i] = max(dp[i-1]+nums[i], nums[i]), where dp[i] indicates the current maximum sum of subarrays
2. Initialization: dp[0] = nums[0]
3. Since we only need to focus on the previous value, an array is not needed

* Time complexity: O(n)
* Space complexity: O(1)

```java
class Solution {
    public int maxSubArray(int[] nums) {
	    int currentMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
```

