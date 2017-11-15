// Design a Tic-tac-toe game that is played between two players on a n x n grid.

// You may assume the following rules:

// A move is guaranteed to be valid and is placed on an empty block.
// Once a winning condition is reached, no more moves is allowed.
// A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.


class TicTacToe {
    public int[] rows;
    public int[] cols;
    public int diagonal;
    public int reverseDiagonal;
    
    public int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        reverseDiagonal = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
                
     // O(1) because of this nice trick.. normal method yeilds O(n) by just sacnning row, column and diagonal if any.           
    public int move(int row, int col, int player) {
        //no validatios check since move is guaranteed to be a valid move.
        int val = player == 1? 1 : -1;
        
        rows[row] += val;
        cols[col] += val;
        if(row == col)
            diagonal += val;
        if(row + col == n-1)
            reverseDiagonal += val;
        
    return (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(reverseDiagonal) == n)                    ? player : 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */