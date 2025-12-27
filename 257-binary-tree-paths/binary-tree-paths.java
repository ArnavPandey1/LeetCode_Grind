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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>l1=new ArrayList<>();
        traverse("",root,l1);
        return l1;
    }
    public void traverse(String ans,TreeNode root,List<String>l1){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            l1.add(ans+root.val);
            return ;
        }
        traverse(ans+root.val+"->",root.left,l1);
        traverse(ans+root.val+"->",root.right,l1);
    }
}