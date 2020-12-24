# [Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)

Given a *n* x *n* matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

**Example:**

```
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```

## Solution

```
The correctness of this algorithm is to ensure that the target value is within the range of [low, high] for each loop step.
For example, there is a matrix and the k = 14,
[11, 15, 20, 21]
[12, 16, 25, 26]
[16, 20, 30, 31]
[30, 31, 35, 38]
It is easy to find the target value is 31, and the algorithm will make sure the target value is within the range of [low, high].
First step, let low = 11, high = 38, and target value must in the range of [11, 38], so mid is 24, count = 8, count < k, let low = 24 + 1 = 25, now target value 31 is within the range of [25, 38].
Second step, low = 25, high = 38, mid = 31, count = 14, count = k, let high = mid = 31, now target value 31 is also within the range of [25, 31].
Third step, low = 25, high = 31, mid = 28, count = 10, count < k, let low = mid + 1 = 29, now target value 31 is also within the range of [29, 31].
Next step, low = 29, high = 31, mid = 30, count = 12, count < k, let low = mid + 1 = 31, now target value 31 is also within the range of [31, 31]. Now low == high, we find the target value.
Notice that every time the algorithm narrows the range, the target value must in the new range. When count >= k, the mid is big enough, the target value must in the range of [low, mid], so let high = mid. When count < k, the mid is small, the target value must in the range of [mid+1, high], so let low = mid + 1. This loop invariants will remain until the algorithm gets end (low == high).
```



```java
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        //int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][m-1];
        while(low < high){
            int mid = low+(high-low)/2;
            int count = 0;
            int j = m - 1;
            for(int i = 0; i < m; i++){
                while(j >=0 && matrix[i][j] > mid)
                    j--;
                count += j+1;
            }
            
            if(count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
```

