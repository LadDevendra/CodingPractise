//Implement TRIE

class Trie {

    public TreeNode root;
    
    class TreeNode{
        public TreeNode[] links;
        public int R = 26;
        public boolean isEnd;
        public TreeNode(){
            links = new TreeNode[R];
        }
            //utility functions
            //put, get, containsKey
            public boolean containsKey(char ch){
                return links[ch-'a'] != null;
            }
            public TreeNode get(char ch){
                return links[ch-'a'];
            }
            public void put(char ch, TreeNode node){
                links[ch-'a'] = node;
            }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
    root = new TreeNode();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for(int i=0; i< word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
                node.put(ch, new TreeNode());
            node = node.get(ch);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = searchPrefix(word);
        return node!=null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = searchPrefix(prefix);
        return node!=null;
    }
    
    public TreeNode searchPrefix(String word){
        TreeNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch))
                node = node.get(ch);
            else 
                return null;
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */