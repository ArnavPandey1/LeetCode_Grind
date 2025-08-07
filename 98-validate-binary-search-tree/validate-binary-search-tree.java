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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        return true;
        List<Integer>l1=new ArrayList<>();
        traverse(l1,root);
        for(int i=1;i<l1.size();i++){
            if(l1.get(i)<=l1.get(i-1))
            return false;
        }
        return true;
    }
    public  static void traverse( List<Integer>l1,TreeNode t){
        if(t==null)
        return;
        traverse(l1,t.left);
        l1.add(t.val);
        traverse(l1,t.right);
        return;
    }
}