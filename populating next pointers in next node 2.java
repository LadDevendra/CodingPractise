// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        TreeLinkNode lastHead = root; //head of last level
        TreeLinkNode lastIndex = null; //running index over last level
        TreeLinkNode currHead = null; //head of current level
        TreeLinkNode currIndex = null; //running index of curr level
        
        //all levels
        while(lastHead != null){
            lastIndex = lastHead;
            //until last level finishes
            while(lastIndex != null){
                //if it has left child..
                if(lastIndex.left != null){
                    //if current level not initialized..i.e Head is null
                    if(currHead == null){
                        currHead = lastIndex.left;
                        currIndex = lastIndex.left;
                    }
                    else{   //if already initialized assign left of lastIndex as next of currIndex  
                        currIndex.next = lastIndex.left;
                        currIndex = currIndex.next;
                    }    
                }
                
                //if it has right child
                if(lastIndex.right != null){
                    //if current level is not initialized..ie. Head is null
                    if(currHead == null){
                        currHead = lastIndex.right;
                        currIndex = lastIndex.right;
                    }
                    else{  //if already initialized assign right of lastIndex as next of currIndex.
                        currIndex.next = lastIndex.right;
                        currIndex =currIndex.next;
                    }
                }
                
                //move to the next node in last level
                lastIndex = lastIndex.next;
            }
            //update the head
            lastHead = currHead;
            currHead = null;
        }
        
        
    }
}