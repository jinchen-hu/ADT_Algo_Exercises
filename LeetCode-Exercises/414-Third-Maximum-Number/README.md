# [Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)

Given a **non-empty** array of integers, return the **third** maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

**Example 1:**

```
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
```



**Example 2:**

```
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
```



**Example 3:**

```
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
```

## Solution

```java
class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for(Integer i : nums){
            if(i.equals(max1) || i.equals(max2) || i.equals(max3))
                continue;
            // initial max's, or
            // reorder max's
            else if(max1 == null || i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if(max2 == null || i > max2){
                max3 = max2;
                max2 = i;
            }else if(max3 == null || i > max3)
                max3 = i;
        }
        return max3 == null ? max1 : max3;
    }
}
```

