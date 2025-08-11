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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        return false;
        return traverse(root,0,targetSum);
    }
    public static boolean traverse(TreeNode root,int s,int t){
        if(root==null)
        return false;
        s=s+root.val;
        if(s==t && root.left==null && root.right==null){
            return true;
        }
        return traverse(root.left,s,t)||traverse(root.right,s,t);
    }
}