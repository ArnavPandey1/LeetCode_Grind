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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>l1=new ArrayList<>();
        if(root==null){
            return l1;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();int max=Integer.MIN_VALUE;
            while(n>0){
                TreeNode t=q.remove();
                 if(t.left!=null)
                 q.add(t.left);
                 if(t.right!=null)
                 q.add(t.right);
                 max=Math.max(max,t.val);
                 n--;
            }
            l1.add(max);
        }
        return l1;
    }
}