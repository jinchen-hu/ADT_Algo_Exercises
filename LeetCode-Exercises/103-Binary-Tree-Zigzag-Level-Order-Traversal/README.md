# [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

Given a binary tree, return the *zigzag level order* traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```



return its zigzag level order traversal as:

```
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        boolean goLeft = true;
        while(!level.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int size = level.size();
            for(int i = 0; i < size; i++){
                TreeNode current = level.poll();
                if(goLeft)
                    list.add(current.val);
                else
                    list.addFirst(current.val);
                if(current.left != null)
                    level.add(current.left);
                if(current.right != null)
                    level.add(current.right);
            }
            res.add(list);
            goLeft = !goLeft;
        }
        return res;
    }
}
```

