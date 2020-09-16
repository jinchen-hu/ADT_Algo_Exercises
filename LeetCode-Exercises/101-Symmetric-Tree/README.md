# [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

## Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

## Example

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

## Solution

#### Explanation

* Since it is a symmetric binary tree, its left subtree is symmetric to right subtree
* This is, the values of roots of two subtrees is identical, and right subtree's right subtree is symmetric to left subtree's subtree, right subtree's left subtree is symmetric to left subtree's right subtree

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.right, root.left);
    }
    
    private boolean helper(TreeNode right, TreeNode left){
        if(right == null && left == null)
            return true;
        if(right == null || left == null)
            return false;
        return right.val == left.val && helper(right.right, left.left) && helper(right.left, left.right);
    }
}
```

