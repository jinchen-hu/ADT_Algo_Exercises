# [Move Zeroes](https://leetcode.com/problems/move-zeroes/)

Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Example:**

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

## Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {
      // ci is the pointer pointing to the first 0
        for(int i=0, ci=0; i < nums.length ; i++){
            if(nums[i] != 0){
                if(ci != i){
                  	// swap the first ele after 0 and the frist 0
                    nums[ci] = nums[i];
                    nums[i] = 0;
                }
                ci++;
            }
        }
    }
}
```

