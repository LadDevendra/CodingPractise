//  Word Search

//  Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                //start the recursive algo if first word matches.
                //choose
                if(word.charAt(0) == board[i][j] && search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int i, int j, int index){
        //index reaches end of string succesfully. so return true.
        if(word.length() == index)
            return true;
        
        //all conditions that could make it false, i, j bounds, match with char and if already visited
        if(i<0 || i>= board.length || j<0 || j>= board[i].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        
        //explore
        visited[i][j] = true;
        if(search(board, word, i+1, j, index+1) || search(board, word, i-1, j, index+1) || search(board, word, i, j+1, index+1)
          || search(board, word, i, j-1, index+1))
            return true;
        
        //unchoose
        visited[i][j] = false;
        return false;
    }
}