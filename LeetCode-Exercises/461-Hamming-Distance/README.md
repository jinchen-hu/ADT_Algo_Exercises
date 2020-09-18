# [Hamming Distance](https://leetcode.com/problems/hamming-distance/)

## Description

The [Hamming distance](https://en.wikipedia.org/wiki/Hamming_distance) between two integers is the number of positions at which the corresponding bits are different.

Given two integers `x` and `y`, calculate the Hamming distance.

## Example

```
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
```

## Solution 1

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x !=0 || y != 0){
            if(x%2 != y%2)
                count++;
            x /= 2;
            y /= 2;
        }
        return count;
    }
}
```

## Solution 2

```java
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
```

