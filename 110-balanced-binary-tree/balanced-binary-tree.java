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
    public boolean isBalanced(TreeNode root) {
        return traverse(root);
    }
    public boolean traverse(TreeNode root){
         if(root==null)
         return true;
         int lh=height(root.left);
         int rh=height(root.right);
         if((lh-rh)<-1 || (lh-rh)>1)
         return false;
         return traverse(root.left)&&traverse(root.right);
    }
    public int height(TreeNode r){
        if(r==null)
        return 0;
        return 1+Math.max(height(r.left),height(r.right));
    }
}