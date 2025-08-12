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
    static int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        int n=traverse(root);
        return max;
    }
    public static int traverse(TreeNode r){
        if(r==null)
        return 0;
        int lh=traverse(r.left);
        int rh=traverse(r.right);
        max=Math.max(lh+rh,max);
        return 1+Math.max(lh,rh);
    }
}