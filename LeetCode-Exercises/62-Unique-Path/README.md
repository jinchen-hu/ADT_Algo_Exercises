# [Unique Path](https://leetcode.com/problems/unique-paths/)

## Description

A robot is located at the top-left corner of a `m x n` grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

## Example

```
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

## Solution

```java
class Solution {
    public int uniquePaths(int m, int n) {
        // (m+n-2)! / (m-1! * n-1!) = C(m+n-2, m-1)
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 || n == 1)
            return 1;
        int sum = m+n-2;
        int small = Math.min(m, n) - 1;
        double res = 1;
        while(small >= 1){
            res *= sum --;
            res /= small--;
        }
        return (int)(Math.round(res));
    }
}
```

