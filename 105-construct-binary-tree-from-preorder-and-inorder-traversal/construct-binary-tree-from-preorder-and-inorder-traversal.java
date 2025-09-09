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
    public TreeNode buildTree(int[] pre, int[] in) {
        return traverse(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode traverse(int[] pre ,int plo,int phi,int []in,int inlo,int inhi){
        if(plo>phi || inlo>inhi){
            return null;
        }
        TreeNode t=new TreeNode(pre[plo]);
        int pos=search(in,inlo,inhi,pre[plo]);
        int le=pos-inlo;
        t.left=traverse(pre,plo+1,plo+le,in,inlo,pos-1);
        t.right=traverse(pre,plo+le+1,phi,in,pos+1,inhi);
        return t;
    }
    public int search(int[]in,int inlo,int inhi,int val){
        for(int i=inlo;i<=inhi;i++){
            if(in[i]==val)
            return i;
        }
        return -1;
    }
}