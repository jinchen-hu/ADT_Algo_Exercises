# [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## Description

Given preorder and inorder traversal of a tree, construct the binary tree.

**Note:**
You may assume that duplicates do not exist in the tree.

## Example

```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```

Return the following binary tree:

```
    3
   / \
  9  20
    /  \
   15   7
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
    // Iterative.
    // Simulate the preorder traversal, backtrack with inorder.
    
    // In preorder traversal, we start from root, go left until reaching left most node (pushing nodes to stack along the path), and then 
    // backtrack to the first node with non-null right child, go to its right child and repeat. 
    
    // Note the backtracking is entirely following the inorder, which gives us a way to locate the first node with non-null right child,
    // i.e. keep poping stack top if it's equal to next inorder value, the next preorder val is just the right child of last poped node.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
           || preorder.length != inorder.length) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        
        int n = preorder.length;
        TreeNode lastPoped = null;
        for (int i = 1, j = 0; i < n; i++) {
            // backtracking following inorder, need to backtrack at the beginning 
            // since we already pushed root node into stack before the loop
            while (j < n && !stack.isEmpty() && stack.peek().val == inorder[j]) {
                lastPoped = stack.pop();
                j++;
            }
            TreeNode curr = new TreeNode(preorder[i]);
            if (lastPoped == null) {
                // still going left
                stack.peek().left = curr;
            } else {
                // backtracked to lastPoped and going right
                lastPoped.right = curr;
            }
            stack.push(curr);
            lastPoped = null;
        }
        return root;
    }
}
```

