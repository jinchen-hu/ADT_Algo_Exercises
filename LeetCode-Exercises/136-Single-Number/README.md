# [Single Number](https://leetcode.com/problems/single-number/)

## Description

Given a **non-empty** array of integers, every element appears *twice* except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

## Example

```
Input: [2,2,1]
Output: 1
```

```
Input: [4,1,2,1,2]
Output: 4
```

## Solution 1

```java
class Solution {
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
}
```

## Solution 2

```java
class Solution {
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (map.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }
}
```

