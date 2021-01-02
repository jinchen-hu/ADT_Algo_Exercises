# [Find a Corresponding Node of a Binary Tree in a Clone of That Tree](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)

Given two binary trees `original` and `cloned` and given a reference to a node `target` in the original tree.

The `cloned` tree is a **copy of** the `original` tree.

Return *a reference to the same node* in the `cloned` tree.

**Note** that you are **not allowed** to change any of the two trees or the `target` node and the answer **must be** a reference to a node in the `cloned` tree.

**Follow up:** Solve the problem if repeated values on the tree are allowed.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/02/21/e1.png)

```
Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2020/02/21/e2.png)

```
Input: tree = [7], target =  7
Output: 7
```

**Example 3:**

![img](https://assets.leetcode.com/uploads/2020/02/21/e3.png)

```
Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4
```

**Example 4:**

![img](https://assets.leetcode.com/uploads/2020/02/21/e4.png)

```
Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
Output: 5
```

**Example 5:**

![img](https://assets.leetcode.com/uploads/2020/02/21/e5.png)

```
Input: tree = [1,2,null,3], target = 2
Output: 2
```

## Solution

```java
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == target || original == null) {
            return cloned;
        }
        
        TreeNode oleft = original.left;
        TreeNode cleft = cloned.left;
        TreeNode left = getTargetCopy(oleft, cleft, target);
        if(left != null)   //Found the target node in left subtree.
            return left;
        
		//Target node is not in left subtree, then it must be in right subtree.
        TreeNode oright = original.right;
        TreeNode cright = cloned.right;
        TreeNode right = getTargetCopy(oright, cright, target);
        
        return right;
    }
}
```

