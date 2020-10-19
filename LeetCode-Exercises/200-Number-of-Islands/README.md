# [Number of Islands](https://leetcode.com/problems/number-of-islands/)

## Description

Given an `m x n` 2d `grid` map of `'1'`s (land) and `'0'`s (water), return *the number of islands*.

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

## Example

**Example 1:**

```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

**Example 2:**

```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

## Solution

```java
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    search(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void search(char[][] grid, int i, int j){
        if(i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        // go up
        search(grid, i-1, j);
        // go down
        search(grid, i+1, j);
        // go right
        search(grid, i, j+1);
        // go left
        search(grid, i, j-1);
    }
}
```

