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
    int cam=0;
    public int minCameraCover(TreeNode root) {
        cam=0;
        if(traverse(root)==-1)
        cam++;
        return cam;
    }
    public int traverse(TreeNode root){
        if(root==null)
        return 0;
        int l=traverse(root.left);
        int r=traverse(root.right);
        if(l==-1 || r==-1)
        {
            cam++;
            return 1;
        }
        if(l==1 || r==1)
        return 0;
        else
        return -1;
    }
}