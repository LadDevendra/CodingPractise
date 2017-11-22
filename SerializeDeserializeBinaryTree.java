//Serialize Deserialize binary tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //base
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(String.valueOf(node.val) + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else{
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            //remove last set of trailing nulls..
            if(temp == null)
                continue;
            //left node
            if(!arr[i].equals("#")){
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(temp.left);
            }
            else{
                temp.left = null;
                queue.add(null);
            }
            //move forward..
            i++;
            //right node
            if(!arr[i].equals("#")){
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(temp.right);
            }else{
                temp.right = null;
                queue.add(null);
            }
            //move forward..
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));