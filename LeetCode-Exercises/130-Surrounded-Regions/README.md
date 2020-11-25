# [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)

Given a 2D board containing `'X'` and `'O'` (**the letter O**), capture all regions surrounded by `'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region.

**Example:**

```
X X X X
X O O X
X X O X
X O X X
```

After running your function, the board should be:

```
X X X X
X X X X
X X X X
X O X X
```

**Explanation:**

Surrounded regions shouldn’t be on the border, which means that any `'O'` on the border of the board are not flipped to `'X'`. Any `'O'` that is not on the border and it is not connected to an `'O'` on the border will be flipped to `'X'`. Two cells are connected if they are adjacent cells connected horizontally or vertically.

## Solution

```java
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        // find the 'o' on the topmost edge
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O')
               dfs(board, 0, j); 
        }
        // find the 'o' on the leftmost edge
        for(int i = 1; i < rows; i++){
            if(board[i][0] == 'O')
               dfs(board, i, 0); 
        }
        // find the 'o' on the rightmost edge
        for(int i = 1; i < rows; i++){
            if(board[i][cols-1] == 'O')
               dfs(board, i, cols-1); 
        }
        // find the 'o' on the bottommost edge
        for(int j = 1; j < cols-1; j++){
            if(board[rows-1][j] == 'O')
               dfs(board, rows-1, j); 
        }
        
        for(int i =0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
        
    }
    
    private void dfs(char[][] board, int i, int j){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]=='*' || board[i][j]=='X')
            return;
        board[i][j] = '*';
        
        dfs(board, i-1, j);// go up     
        dfs(board, i, j+1);// go left 
        dfs(board, i+1, j);// go down
        dfs(board, i, j-1);// go right
    }
}
```

