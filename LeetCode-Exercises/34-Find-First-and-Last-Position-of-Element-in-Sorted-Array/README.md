# [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

## Description

Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).

If the target is not found in the array, return `[-1, -1]`.

## Example

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

## Solution

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0)
            return res;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left+right) / 2;
            if(target == nums[mid]){
                int l = mid, r = mid;
                while(l-1 >= 0 && nums[l-1] == target)
                    l--;
                while(r+1 <= nums.length -1 && nums[r+1] == target)
                    r++;
                res[0] = l;
                res[1] = r;
                return res;
            }
            
            if(nums[mid] < target)
                left = mid+1;
            if(nums[mid] > target)
                right = mid-1;
        }
        return res;
    }
}
```

