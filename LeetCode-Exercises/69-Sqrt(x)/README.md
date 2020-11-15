# [Sqrt(x)](https://leetcode.com/problems/sqrtx/)

Given a non-negative integer `x`, compute and return *the square root of* `x`.

Since the return type is an integer, the decimal digits are **truncated**, and only **the integer part** of the result is returned.

 

**Example 1:**

```
Input: x = 4
Output: 2
```

**Example 2:**

```
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
```

## Solution 

```java
class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int start = 1;
        int end = x/2;
        
        while(start < end) {
            // start is not always moving and hence we can get stuck in infinite loop with mid calculation
            // Adding 1 to mid everytime to ensure we always move the mid
            int mid = (start + (end-start)/2) + 1;
            
            // use division instead of multiplication to avoid overflow
            int div = x/mid;
            if(div == mid) return mid;
            if(div > mid) start = mid;
            else end = mid-1;
        }
        
        return start;
    }
}
```

