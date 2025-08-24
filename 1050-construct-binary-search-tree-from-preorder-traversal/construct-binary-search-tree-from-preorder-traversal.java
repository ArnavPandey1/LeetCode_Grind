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
    // --O(N^2) Approach
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     TreeNode root=null;
    //     for(int i=0;i<preorder.length;i++){
    //        root=insert(root,preorder[i]);
    //     }
    //     return root;
    // }
    // public TreeNode insert(TreeNode root,int val){
    //     if(root==null){
    //         TreeNode temp=new TreeNode(val);
    //         return temp;
    //     }
    //     if(root.val>val){
    //      root.left= insert(root.left,val);
    //     }
    //     else
    //     root.right=insert(root.right,val);
    //     return root;
    // }
    //O(N)  Approach   
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return createBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode createBST(int preorder[],int low,int high){
        if(idx==preorder.length || preorder[idx]<low || preorder[idx]>high)
        return null;
        TreeNode temp=new TreeNode(preorder[idx++]);
        temp.left=createBST(preorder,low,temp.val);
        temp.right=createBST(preorder,temp.val,high);
        return temp;
    }
}