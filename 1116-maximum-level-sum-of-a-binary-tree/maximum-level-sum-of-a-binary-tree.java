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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);int l=1;int ans=1;int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n=q.size();
            int s=0;
            while(n>0){
                TreeNode t=q.remove();
                s=s+t.val;
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                n--;
            }
            if(max<s){
               ans=l;
               max=s;
            }
            l++;
        }
        return ans;
    }
}