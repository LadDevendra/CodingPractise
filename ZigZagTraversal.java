//ZigZag traversal 

//level wise ...Arraylist for outside and linkedList for inside so that we get constant insertion in both

//can be done using two Stacks as well just like BST.java


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        traverse(root, 0, result);
        return result;
    }
    public void traverse(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
            return;
        
        if(result.size() <= level){
            result.add(new LinkedList<>());
        }
        List<Integer> levelList = result.get(level);
        if(level%2 == 0)
            levelList.add(root.val);
        else
            levelList.add(0, root.val);
        
        traverse(root.left, level +1, result);
        traverse(root.right, level +1, result);
    }
}