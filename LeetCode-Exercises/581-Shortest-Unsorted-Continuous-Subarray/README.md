# [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)

Given an integer array `nums`, you need to find one **continuous subarray** that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return *the shortest such subarray and output its length*.

 

**Example 1:**

```
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```

**Example 2:**

```
Input: nums = [1,2,3,4]
Output: 0
```

**Example 3:**

```
Input: nums = [1]
Output: 0
```

## Solution 1

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1)
            return 0;
        int left=nums.length-1, right=0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]<nums[stack.peek()]){
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right-left >=0? right-left+1 : 0;
    }
}
```

## Solution 2

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
```

## Solution 3

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length;
        int right = 0;
        int max = nums[0];
        int min = nums[nums.length-1];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length-1-i]);
            right = nums[i] < max ? i : right;
            left = nums[nums.length-1-i] > min ? nums.length-1-i : left;
        }
        return right-left>0 ? right-left+1:0;
    }
}
```

