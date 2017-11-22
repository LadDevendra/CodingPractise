//Validate Binary Search Tree

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
    public boolean isValidBST(TreeNode root) {
        return isValidUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static boolean isValidUtil(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        
        return (isValidUtil(root.left, min, root.val) && isValidUtil(root.right, root.val, max));
    }
    
}