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
    public int sumOfLeftLeaves(TreeNode root) {
       return traverse(root,false);
    }
    public static int traverse(TreeNode t,boolean flag){
       if(t==null)
       return 0;
       if(flag==true&&t.left==null && t.right==null){
        return t.val;
       }
       int sll=traverse(t.left,true);
       int srl=traverse(t.right,false);
       return sll+srl;
    }
}