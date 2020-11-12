# [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

Given an array of integers where 1 ≤ a[i] ≤ *n* (*n* = size of array), some elements appear twice and others appear once.

Find all the elements of [1, *n*] inclusive that do not appear in this array.

Could you do it without extra space and in O(*n*) runtime? You may assume the returned list does not count as extra space.

**Example:**

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

## Solution 1

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if(nums.length == 0)
            return res;
        
        int count[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            count[nums[i]-1]++;    
        }
        for(int i = 1; i <= nums.length;i++)
            if(count[i-1] == 0) 
                res.add(i);
        
        return res;
    }
}
```

## Solution 2

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        for(int num : nums){
            int i = Math.abs(num);
            if(nums[i-1] > 0)
                nums[i-1] *= -1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) 
                res.add(i + 1);
        }
        return res;
    }
}
```

