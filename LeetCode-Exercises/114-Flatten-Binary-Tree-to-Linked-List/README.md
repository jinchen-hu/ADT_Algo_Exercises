# [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

## Description

Given a binary tree, flatten it to a linked list in-place.

## Example

```
For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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
    public void flatten(TreeNode root) {
        TreeNode pre;
        if (root==null || (root.left==null && root.right==null))
            return;
        while(root!=null){
          	// go to right subtree if left is null
            if(root.left==null){
                root=root.right;
            }
            else{
              	// go to left subtree
                pre=root.left;
              	// find the rightmost node of left subtree
                while(pre.right!=null){
                    pre=pre.right;
                }
								// concat right subtree to the rightmost node of left subtree
                pre.right=root.right;
              	// substitute right subtree with left subtree
                root.right=root.left;
              	// make left to be null
                root.left=null;
              	// go to right substree
                root=root.right;     
            }
        }       
    }
}
```



```

    1
   / \
  2   5
 / \   \
3   4   6

		1
	   \
			2
		 / \
		3   4
    	   \
    	    5
    	     \
    	      6
     
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

## 