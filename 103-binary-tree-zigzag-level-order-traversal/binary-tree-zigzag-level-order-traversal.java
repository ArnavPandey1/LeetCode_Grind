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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>l1=new ArrayList<>();
        if(root==null){
            return l1;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int l=-1;
        List<Integer>l2;
        while(!q.isEmpty()){
            l=l+1;
            int n=q.size();
            l2=new ArrayList<>();
            while(n>0){
                TreeNode t=q.remove();
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                l2.add(t.val);
                n--;
            }
            if(l% 2!=0)
            {
               Collections.reverse(l2);
            }
            l1.add(new ArrayList<>(l2));
        }
        return l1;
    }
}