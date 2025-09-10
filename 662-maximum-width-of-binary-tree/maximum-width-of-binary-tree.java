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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair>q=new LinkedList<>();
       q.add(new Pair(root,0));int max=1;
       while(!q.isEmpty()){
             int flag=0;
             int n=q.size();int a=0;int b=0;
             while(n>0){
                Pair p=q.remove();
                if(flag==0)
                {
                    flag=1;
                    a=p.idx;
                }
                if(p.node.left!=null)
                q.add(new Pair(p.node.left,2*p.idx+1));
                if(p.node.right!=null)
                q.add(new Pair(p.node.right,2*p.idx+2));
                n--;
                if(n==0)
                {
                  b=p.idx;
                }
             }
             max=Math.max(max,(b-a)+1);
       } 
       return max;
    }
}