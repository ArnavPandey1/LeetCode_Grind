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
    public TreeNode buildTree(int[] in, int[] post) {
        return traverse(in,0,in.length-1,post,0,post.length-1);
    }
    public TreeNode traverse(int []in,int inlo,int inhi,int []post,int plo,int phi){
        if(inlo>inhi || plo>phi){
            return null;
        }
        TreeNode t=new TreeNode(post[phi]);
        int pos=search(in,inlo,inhi,post[phi]);
        int le=pos-inlo;
        t.left=traverse(in,inlo,pos-1,post,plo,plo+le-1);
        t.right=traverse(in,pos+1,inhi,post,plo+le,phi-1);
        return t;
    }
    public int search(int []in,int inlo,int inhi,int val){
        for(int i=inlo;i<=inhi;i++){
            if(in[i]==val){
                return i;
            }
        }
        return -1;
    }
}