// Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

// You receive a valid board, made of only battleships or empty slots.
// Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
// At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.


class Solution {
    public int countBattleships(char[][] board) {
        
     // O(m*n) time and O(m*n) space!
    //     boolean[][] visited = new boolean[board.length][board[0].length];
    //     int battleShips = 0;
    //     for(int i = 0; i< board.length; i++){
    //         for(int j = 0; j < board[i].length; j++){
    //             if(!visited[i][j] && board[i][j] == 'X'){
    //                 battleShips++;
    //                 visited[i][j] = true;
    //                 DFS(board, visited, i, j);
    //             }
    //         }
    //     }
    //     return battleShips;
    // }
    // public void DFS(char[][] board, boolean[][] visited, int i, int j){
    //     if(i+1 < board.length && !visited[i+1][j] && board[i+1][j] == 'X'){
    //         visited[i+1][j] = true;
    //         DFS(board, visited, i+1, j);
    //     }
    //     if(j+1 < board[0].length && !visited[i][j+1] && board[i][j+1] == 'X'){
    //         visited[i][j+1] = true;
    //         DFS(board, visited, i, j+1);
    //     }
        
     //O(m*n) time O(1) space!
     int battleShips = 0;
     int m = board.length;
     if(m == 0)
         return 0;
     int n = board[0].length;
     //If there is no X on left or top of a battleship then it is a start of battleship
     for(int i =0; i< m; i++){
         for(int j =0; j< n; j++){
             if(board[i][j] == 'X')
                 if((i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X'))
                    battleShips++;
         }
     }
      return battleShips;
    }
}