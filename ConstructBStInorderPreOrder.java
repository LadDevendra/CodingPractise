//Construct BSt Inorder + PreOrder

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	//might be a probem is tree has duplicate elements!!
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i< inorder.length; i++)
            inMap.put(inorder[i], i);
        TreeNode root = constructHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;       
    }
    public TreeNode constructHelper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart> preEnd || inStart> inEnd)
            return null;
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        if(inMap.containsKey(rootVal))
            rootIndex = inMap.get(rootVal);
        
        int numsLeft = rootIndex - inStart;
        root.left = constructHelper(pre, preStart+1, preStart+numsLeft, in, inStart, rootIndex-1, inMap);
        root.right = constructHelper(pre, preStart+numsLeft+1, preEnd, in, rootIndex+1, inEnd, inMap);
     return root;
    }
}