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
        return traverse(pre,in,0,0,in.length-1);
    }
    public static TreeNode traverse(int []pre,int []in, int idx, int start, int end){
        if(start>end){
            return null;
        }
        TreeNode t=new TreeNode(pre[idx]);
        int pos=find(in,start,end,pre[idx]);
        t.left=traverse(pre,in,idx+1,start,pos-1);
        t.right=traverse(pre,in,idx+(pos-start)+1,pos+1,end);
        return t;
    }
    public static int find(int []in,int start,int end,int v){
        for(int i=start;i<=end;i++){
            if(in[i]==v){
                return i;
            }
        }
        return -1;
    }
}