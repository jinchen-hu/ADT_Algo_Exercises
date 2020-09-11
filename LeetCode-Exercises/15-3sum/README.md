# [3sum](https://leetcode.com/problems/3sum/)

## Desciption

Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

## Example

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

```
Input: nums = []
Output: []
```

## Solution

#### Explanation

1. Sort the given nums array
2. Cross through the array
   1. If the num[i] is equal to the former element, continue
   2. If the num[i] is greater than 0, break the loop since the array was sorted, the sum cannot be 0 if the smallest is greater than 0
   3. Left the next element be the left pointer, the last element be the right pointer
   4. When the left is smaller than right, do the while loop
      * if the sum is equal to 0, store these 3 numbers as a list in the result list, and move pointers to the mid
      * avoid repulicates through comparing the nums[left], nums[left-1] and nums[right], nums[right+1]
      * if sum is greater than 0, move the right pointer since nums[right] is too large
      * if sum is smaller than 0, move the left pointer since nums[left] is too small
   5. Return the list

![15-3sum](../../common/15-3sum.gif)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 || nums == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2 ; i++){
            // avoid duplicates
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            // array was sorted, if the first one is greater than 0
            // the sum cannot be 0 anymore
            if(nums[i] > 0)
                break;
            int left = i + 1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    // avoid duplicates
                    while(left < right && nums[left] == nums[left-1])
                        left++;
                    // avoid duplicates
                    while(left < right && nums[right] == nums[right + 1])
                        right--;
                }else if(sum > 0)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }
}
```

