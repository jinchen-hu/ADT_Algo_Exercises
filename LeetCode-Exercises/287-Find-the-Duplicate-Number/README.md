# [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one duplicate number** in `nums`, return *this duplicate number*.

**Follow-ups:**

1. How can we prove that at least one duplicate number must exist in `nums`? 
2. Can you solve the problem **without** modifying the array `nums`?
3. Can you solve the problem using only constant, `O(1)` extra space?
4. Can you solve the problem with runtime complexity less than `O(n2)`?

 

**Example 1:**

```
Input: nums = [1,3,4,2,2]
Output: 2
```

**Example 2:**

```
Input: nums = [3,1,3,4,2]
Output: 3
```

**Example 3:**

```
Input: nums = [1,1]
Output: 1
```

**Example 4:**

```
Input: nums = [1,1,2]
Output: 1
```

## Solution 1

```java
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }
}
```

## Solution 2

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int p1=nums[0],p2=nums[0];
        do{
            p1=nums[p1];
            p2=nums[nums[p2]];
        }while(p1!=p2);
        
        p1=nums[0];
        while(p1!=p2){
            p1=nums[p1];
            p2=nums[p2];
        }
        return p1;
    }
}
```

