# [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
- You may assume that *nums1* has enough space (size that is **equal** to *m* + *n*) to hold additional elements from *nums2*.

**Example:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

## Solution

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int mid = m+n-1;
        while(mid>=0 && p2>=0){
            nums1[mid--] = p1 >=0 && nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
    }
}
```

