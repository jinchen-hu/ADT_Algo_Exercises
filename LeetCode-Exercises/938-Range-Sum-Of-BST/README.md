# [Range Sum Of BST](https://leetcode.com/problems/range-sum-of-bst/submissions/)

## Description

Given the `root` node of a binary search tree, return the sum of values of all nodes with value between `L` and `R` (inclusive).

The binary search tree is guaranteed to have unique values.

## Example

```
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
```

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        if(root.val < L)
            return rangeSumBST(root.right, L, R);
        if(root.val > R)
            return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
```

