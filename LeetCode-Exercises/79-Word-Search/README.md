# [Word Search](https://leetcode.com/problems/word-search/)

## Description

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

## Example

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
```

## Solution

#### Explanation

1. Scan board, find starting position with matching word first letter
2. From starting position, DFS (4 (up, down, left, right 4 directions) match word's rest letters
3. For each visited letter, mark it as visited, here use `board[i][j] = '*'` to represent visited.
4. If one direction cannot continue, backtracking, mark start position unvisited, mark `board[i][j] = word[start]`
5. If found any matching, terminate
6. Otherwise, no matching found, return false

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length == 0 || word.length() == 0)
            return false;
        // Traverse the board 
        for(int ver= 0; ver < board.length; ver++){
            for(int hor = 0; hor < board[0].length; hor++){
                // Go to next word if find the frist matching
                if(word.charAt(0) == board[ver][hor] && helper(board, word, ver, hor, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int rows, int cols, int position){
        // returns true if finding all matching
        if(position == word.length())
            return true;
        // returns false if out of the board or not matching
        if(rows < 0 || rows >= board.length || cols < 0 || cols >= board[0].length
          || board[rows][cols] != word.charAt(position))
            return false;
        // mark the current char visited
        board[rows][cols] = '*';
        // Try all four directions
        // go up
        boolean flag = helper(board, word, rows - 1, cols, position + 1)
            // go right
            || helper(board, word, rows, cols + 1, position + 1)
            // go down
            || helper(board, word, rows + 1, cols, position + 1)
            // go left
            || helper(board, word, rows, cols - 1, position + 1);
        // Backtracking if no matching
        board[rows][cols] = word.charAt(position);
        return flag;
    }
}
```

