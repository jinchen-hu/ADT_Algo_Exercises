# [Rotate Array](https://leetcode.com/problems/rotate-array/)

Given an array, rotate the array to the right by *k* steps, where *k* is non-negative.

**Follow up:**

- Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
- Could you do it in-place with O(1) extra space?

 

**Example 1:**

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**Example 2:**

```
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

## Solution

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Original List                   : 1 2 3|| 4 5 6 7
After reversing all numbers     : 7 6 5|| 4 3 2 1
After reversing first k numbers : 5 6 7|| 4 3 2 1
After revering last n-k numbers : 5 6 7|| 1 2 3 4 --> Result
```

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums,k, nums.length-1);
    }
    
    private void reverse(int[] nums, int left,  int right){
        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
```

