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
    long max=Long.MIN_VALUE;
    long total=0;
    public int maxProduct(TreeNode root) {
        max=Long.MIN_VALUE;
        total=helper(root);
        helper1(root,total);
        return (int)(max%1000000007);
    }
    public long helper(TreeNode root){
       if(root==null){
         return 0;
       }
       long s1=helper(root.left);
       long s2=helper(root.right);
       return (root.val+s1+s2)%1000000007;
    }
    public long helper1(TreeNode root,long total){
        if(root==null){
            return 0;
        }
        long s1=helper1(root.left,total);
        long s2=helper1(root.right,total);
        long s=(root.val+s1+s2)%1000000007;
        max=Math.max(max,(total-s)*s);
        return s;
    }
}