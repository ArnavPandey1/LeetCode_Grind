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
    int s=0;
    public int sumNumbers(TreeNode root) {
        int rem=0;
        traverse(root,rem);
        return s;
    }
    public void traverse(TreeNode r,int rem){
          if(r==null)
          return ;
          rem=rem*10+r.val;
          if(r.left==null && r.right==null){
            s=s+rem;
          }
          traverse(r.left,rem);
          traverse(r.right,rem);
    }
}