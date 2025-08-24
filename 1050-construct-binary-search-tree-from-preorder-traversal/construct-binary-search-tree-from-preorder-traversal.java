/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i=0;i<preorder.length;i++){
           root=insert(root,preorder[i]);
        }
        return root;
    }
    public TreeNode insert(TreeNode root,int val){
        if(root==null){
            TreeNode temp=new TreeNode(val);
            return temp;
        }
        if(root.val>val){
         root.left= insert(root.left,val);
        }
        else
        root.right=insert(root.right,val);
        return root;
    }
}