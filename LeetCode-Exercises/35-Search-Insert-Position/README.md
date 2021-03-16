# Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 

**Example 1:**

```
Input: nums = [1,3,5,6], target = 5
Output: 2
```

**Example 2:**

```
Input: nums = [1,3,5,6], target = 2
Output: 1
```

**Example 3:**

```
Input: nums = [1,3,5,6], target = 7
Output: 4
```

**Example 4:**

```
Input: nums = [1,3,5,6], target = 0
Output: 0
```

**Example 5:**

```
Input: nums = [1], target = 0
Output: 0
```

## Solution

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target)
                return mid;
            
            // if the mid value is less than the target
            // the target must be in right half
            if(nums[mid] < target)
                left = mid+1;
            else
                right = mid;
        }
        
        return nums[left] < target ? left+1 : left;
        
    }
}
```

