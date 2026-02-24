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
    int total = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper("",root);
        return total;
    }

    public void helper(String ans,TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.left==null && root.right==null){
            total+=helper2(ans+root.val);
            return ;
        }
        helper(ans+root.val,root.left);
        helper(ans+root.val,root.right);
    }
    public int helper2(String ans){
        int k=0;int t=0;
        for(int i=ans.length()-1;i>=0;i--){
            char ch=ans.charAt(i);
            t=t+(ch=='1'?1:0)*(int)Math.pow(2,k++);
        }
        return t;
    }
}