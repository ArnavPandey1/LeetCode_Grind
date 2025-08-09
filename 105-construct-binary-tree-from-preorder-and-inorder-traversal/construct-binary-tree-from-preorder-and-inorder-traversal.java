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
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return traverse(pre,in,0,0,in.length-1,map);
    }
    public static TreeNode traverse(int []pre,int []in, int idx, int start, int end,  HashMap<Integer,Integer>map){
        if(start>end){
            return null;
        }
        TreeNode t=new TreeNode(pre[idx]);
        int pos=map.get(pre[idx]);
        t.left=traverse(pre,in,idx+1,start,pos-1,map);
        t.right=traverse(pre,in,idx+(pos-start)+1,pos+1,end,map);
        return t;
    }
}