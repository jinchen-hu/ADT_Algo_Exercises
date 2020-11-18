# [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

Given an `m x n` `matrix`, return *all elements of the* `matrix` *in spiral order*.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg)

```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg)

```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

## Solution

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        while(left<=right && top <=bottom){
            for(int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            for(int i = top+1; i <= bottom; i++)
                res.add(matrix[i][right]);
            if(left<right && top < bottom){
                for(int i = right-1; i > left; i--)
                    res.add(matrix[bottom][i]);
                for(int i = bottom; i > top; i--)
                    res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
```

