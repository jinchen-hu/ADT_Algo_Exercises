# [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

## Description

Given a binary search tree, write a function `kthSmallest` to find the **k**th smallest element in it.

## Example

**Example 1:**

```
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
```

**Example 2:**

```
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = root;
        int count = 0;
        // node == null, might get to the leaf but stack is not empty
        while(node!=null || !stack.isEmpty()){
            // go to leftmost
            while(node!=null){
                stack.push(node);
                node = node.left;
            } 
            node = stack.pop();
            count++;
            if(count==k) 
                return node.val;
            // get next smallest node
            node = node.right;
        }
        return -1;
    }
}
```

