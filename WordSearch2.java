// Word Search II

// Given a 2D board and a list of words from the dictionary, find all words in the board.

// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

// For example,
// Given words = ["oath","pea","eat","rain"] and board =

// [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// Return ["eat","oath"].
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

class Solution {
    public static final int size = 26;
    
    class TrieNode{
        TrieNode[] children;
        //optimization, tradeoff between time and space to get the word faster.
        String word;
        TrieNode(){
            children = new TrieNode[size];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if(words == null || board == null)
            return null;
        TrieNode root = buildTrie(words);
        //call for every word in board
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                findHelper(board, root, res, i, j);
            }
        }
        return res;
    }
    
    public void findHelper(char[][] board, TrieNode curr, List<String> res, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || curr == null)
            return;
        char c = board[i][j];
        if(c == '#' || curr.children[c-'a'] == null)
            return;
        if(curr.children[c-'a'].word != null){
            res.add(curr.children[c-'a'].word);
            curr.children[c-'a'].word = null;
        }
        board[i][j] = '#';
        findHelper(board, curr.children[c-'a'], res, i-1, j);
        findHelper(board, curr.children[c-'a'], res, i+1, j);
        findHelper(board, curr.children[c-'a'], res, i, j-1);
        findHelper(board, curr.children[c-'a'], res, i, j+1);
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        TrieNode curr;
        for(String word: words){
            curr = root;
            for(char c: word.toCharArray()){
                int i = c - 'a';
                if(curr.children[i] == null)
                    curr.children[i] = new TrieNode();
                curr = curr.children[i];
            }
            curr.word = word;
        }
        return root;
    }
}