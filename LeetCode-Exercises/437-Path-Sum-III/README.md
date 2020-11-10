# [Path Sum III](https://leetcode.com/problems/path-sum-iii/)

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

**Example:**

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

## Solution 1

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
    // store the sum of current node from root
    HashMap<Integer, Integer> currentSum;
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        currentSum = new HashMap<>();
        currentSum.put(0, 1);
        dfs(root, 0, sum);
        return count;
    }
    
    public void dfs(TreeNode root, int curr, int target) {
        if (root == null)
            return;

        int temp = curr + root.val;
        // temp-sum indicates the diff between sum and target
        // e.g., the sum of the leaf 1 from root is 18, we need to
        // check if there exists a sum of its ancestor nodes equal to 18-8=10
        if (currentSum.containsKey(temp - target)) {
            count += currentSum.get(temp - target);
        }
        // Compute the sum of each node from the root
        if (currentSum.containsKey(temp))
            currentSum.replace(temp, currentSum.get(temp)+1);
        else 
            currentSum.put(temp, 1);
        
        dfs(root.left, temp, target);
        dfs(root.right, temp, target);

        if (currentSum.containsKey(temp)) {
            int v = currentSum.get(temp) - 1;
            if (v == 0) 
                currentSum.remove(temp);
            else 
                currentSum.replace(temp, v);
        }
    }
}
```

## Solution 2

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
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return dfs(root, sum) + pathSum(root.left, sum)+pathSum(root.right, sum);
    }
    
    public int dfs(TreeNode root,int sum){
        if(root == null)
            return 0;
        int count = 0;
        if(root.val == sum)
            count ++;
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
```

