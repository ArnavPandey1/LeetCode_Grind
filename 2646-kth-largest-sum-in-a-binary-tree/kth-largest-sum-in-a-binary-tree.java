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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);List<Long>l1=new ArrayList<>();
        while(!q.isEmpty()){
            int n=q.size();
            long s=0;
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
            l1.add(s);
        }
        Collections.sort(l1);
        if(l1.size()<k)
        return -1;
        long ans=-1;
        for(int i=l1.size()-1;i>=0&&k>0;i--){
            ans=l1.get(i);
            k--;
        }
        return ans;
    }
}