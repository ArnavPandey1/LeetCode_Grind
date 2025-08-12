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
    static int min;
    public int minDepth(TreeNode root) {
        if(root==null)
        return 0;
        min=Integer.MAX_VALUE;
        traverse(root,1);
        return min;
    }
    public static void traverse(TreeNode r,int c){
        if(r==null){
            return;
        }
        if(r.left==null && r.right==null){
            min=Math.min(min,c);
        }
        traverse(r.left,c+1);
        traverse(r.right,c+1);
    }
}