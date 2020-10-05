# [Sort Colors](https://leetcode.com/problems/sort-colors/)

## Description

Given an array `nums` with `n` objects colored red, white, or blue, sort them **[in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers `0`, `1`, and `2` to represent the color red, white, and blue respectively.

## Example

```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

## Solution

```java
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, i = 0;
        while(i <= p2){
            if(nums[i] == 0){
                nums[i] = nums[p0];
                nums[p0] = 0;
                i++;
                p0++;
            }else if(nums[i] == 2){
                nums[i] = nums[p2];
                nums[p2] = 2;
                p2--;
            }else
                i++;
        }
    }
}
```

