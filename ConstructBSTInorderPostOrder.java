//Construct BST Inorder + PostOrder



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i< inorder.length; i++)
            inMap.put(inorder[i], i);
        TreeNode root = BuildHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        return root;
    }
    
    public TreeNode BuildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = -1;
        if(inMap.containsKey(rootVal))
            rootIndex = inMap.get(rootVal);
        
        int leftSize = rootIndex - inStart;
        root.left = BuildHelper(inorder, inStart, rootIndex-1, postorder, postStart, postStart+leftSize-1, inMap);
        root.right = BuildHelper(inorder, rootIndex+1, inEnd, postorder, postStart+leftSize, postEnd-1, inMap);
        
        return root;
    }
}