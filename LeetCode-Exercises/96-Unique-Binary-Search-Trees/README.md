# [Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)

## Description

Given *n*, how many structurally unique **BST's** (binary search trees) that store values 1 ... *n*?

## Example

```
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

## Solution 1

```java
class Solution {
   public int numTrees(int n) {
       int[] G = new int[n + 1];
       G[0] = 1; G[1] = 1;
       for (int i = 2; i <= n; ++i) {
           for (int j = 1; j <= i; ++j) { // sum
               G[i] += G[j - 1] * G[i - j];
           }
       }
       return G[n];
   }
}
```

## Solution 2

```java
public int numTrees(int n) {
  long C = 1;
  for (int i = 0; i < n; ++i) { // i stops at n - 1
    C = C * 2 * (2 * i + 1) / (i + 2); // calculate C_i+1
  }
  return (int) C;
}
```