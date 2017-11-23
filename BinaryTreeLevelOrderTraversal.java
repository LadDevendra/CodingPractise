// Binary Tree Level Order Traversal

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) 
            return result;
        //BFS
        //we use queue for level wise traversal
//         List<List<Integer>> result = new ArrayList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         queue.offer(null);
//         List<Integer> level = new ArrayList<>();
//         level.add(root.val);
//         result.add(level);
//         level = new ArrayList<>();
//         while(!queue.isEmpty()){
//             TreeNode node = queue.poll();
//             if(node == null){
//                 if(!queue.isEmpty())
//                     queue.add(null);
//                 if(!queue.isEmpty())
//                 result.add(level);
//                 level = new ArrayList<>();
//             }
//             else {
//                 if(node.left!=null){
//                     queue.offer(node.left);
//                     level.add(node.left.val);
//                 }
//                 if(node.right!=null){
//                     queue.offer(node.right);
//                     level.add(node.right.val);
//                 }
//             }
                
//         }
//         return result;
        
        //DFS
        traverse(root, 0, result);
        return result;
    }
    public void traverse(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
            return;
        if(result.size() <= level)
            result.add(new ArrayList<>());
        
        List<Integer> levelList = result.get(level);
        levelList.add(root.val);
        
        traverse(root.left, level+1, result);
        traverse(root.right, level+1, result);
    }
}