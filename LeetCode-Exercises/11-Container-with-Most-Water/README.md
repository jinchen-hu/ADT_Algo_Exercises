# [Container with Most Water](https://leetcode.com/problems/container-with-most-water/)

## Description

Given *n* non-negative integers *a1*, *a2*, ..., *an* , where each represents a point at coordinate (*i*, *ai*). *n* vertical lines are drawn such that the two endpoints of line *i* is at (*i*, *ai*) and (*i*, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

**Note:** You may not slant the container and *n* is at least 2.

![img](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

## Solution 1

* Two for loops
* Time Complexity: O(n*2)
* Space Complexity: O(1)

```java
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int temp = Math.min(height[i], height[j]) * (j - i);
                area = Math.max(area, temp);
            }
        }
        return area;
    }
}
```

## Solution 2

## Explanation

1. Create two pointers point to the frist and last elements respectively
2. Compute the area between these two pointers and update the maximum value
3. Move the pointer with smaller value to the middle, only by this way, we are able to find a greater area
4. Repeat the step (2) and (3) untill the two pointers come across

* Time Complexity: O(n)
* Space Complexity: O(1)

![11-maxArea](../../common/11-maxArea.gif)

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        while(left < right){
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if(height[left] > height[right])
                right--;
            else
                left++;
        }
        return area;
    }
}
```

