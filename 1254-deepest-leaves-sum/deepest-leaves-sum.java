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
    public int deepestLeavesSum(TreeNode root) {
        int s=0;
        if(root==null){
            return s;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();s=0;
            while(n>0){
               TreeNode t=q.remove();
               s=s+t.val;
               if(t.left!=null)
               q.add(t.left);
               if(t.right!=null)
               q.add(t.right);
               n--;
            }
            if(q.isEmpty())
            return s;
        }
        return s;
    }
}