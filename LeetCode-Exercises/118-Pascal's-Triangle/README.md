# [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)

Given a non-negative integer *numRows*, generate the first *numRows* of Pascal's triangle.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)
In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**

```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## Solution

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            // add 1 to the first element
            row.add(0, 1);
            // iteratively compute sum's
            // since it starts from index 1,
            // this is equivalent to compute the sum from
            // the previous row
            for(int j = 1; j < row.size() -1; j++)
                row.set(j, row.get(j)+row.get(j+1));
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}
```

