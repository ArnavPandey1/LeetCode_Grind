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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);int leftValue=-1;
        while(!q.isEmpty()){
            int n=q.size();
            int l=-1;
            while(n>0){
                TreeNode t=q.remove();
                if(l==-1){
                    leftValue=t.val;
                    l=1;
                }
                if(t.left!=null)
                q.add(t.left);
                if(t.right!=null)
                q.add(t.right);
                n--;
            }
        }
        return leftValue;
    }
}