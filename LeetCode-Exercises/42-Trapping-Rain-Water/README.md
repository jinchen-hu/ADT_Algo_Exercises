# [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

**Example 2:**

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

 

**Constraints:**

- `n == height.length`
- `0 <= n <= 3 * 104`
- `0 <= height[i] <= 105`]

## Solution

The above code is easy to understand, but it needs the extra space of N. We can tell from it that we in fact only cares about the minimum of (left[i], right[i]). Specifically:

- If l[i + 1] < r[i], the maximum in the left side of i will determine the height of trapping water.
- If l[i + 1] >= r[i], the maximum in the right side of i will determine the height of trapping water.

Thus, we don't need to keep two complete arrays. We can rather keep only a left max and a right max, using constant variable. This problem is a typical two pointers problem.

Algorithm:

1. Initialize two pointers `left` and `right`, pointing to the begin and the end of our height array respectively.
2. Initialize the left maximum height and the right maximum height to be 0.
3. Compare height[left] and height[right]

- If height[left] < height[right]
  - 3.1.1 If height[left] >= left_max, the current trapping volume is (left_max - height[left])
  - 3.1.2 Otherwise, no water is trapped and the volume is 0
- 3.2 Iterate the left pointer to the right
- 3.3 If height[left] >= height[right]
  - 3.3.1 If height[right] >= right_max, the current trapping volume is (right_max - height[right])
  - 3.3.2 Otherwise, no water is trapped and the volume is 0
- 3.4 Iterate the right pointer to the left

```java
class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                area += maxLeft - height[left];
                left++;
            }else{
                maxRight = Math.max(maxRight, height[right]);
                area += maxRight - height[right];
                right--;
            }
        }
        return area;
    }
}
```

