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
    public void flatten(TreeNode root) {
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left==null){
                temp=temp.right;
            }
            else{
                TreeNode curr=temp.left;
                while(curr.right!=null){
                    curr=curr.right;
                }
                curr.right=temp.right;
                TreeNode t=temp.left;
                temp.right=t;
                temp.left=null;
                temp=t;
            }
        }
    }
}