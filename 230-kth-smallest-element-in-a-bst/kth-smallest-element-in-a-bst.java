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
    int c=0;int min=-1;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraverse(root,k);
        return min;
    }
    public  void inorderTraverse(TreeNode root,int k){
        if(root==null || c>k)
        return;
        inorderTraverse(root.left,k);
        c++;
        if(c==k){
            min=root.val;
            return;
        }
        inorderTraverse(root.right,k);
    }
}