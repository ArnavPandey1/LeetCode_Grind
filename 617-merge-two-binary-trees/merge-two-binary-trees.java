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
    public TreeNode mergeTrees(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return null;
        } else if (r1 == null && r2 != null) {
            return r2;
        } else if (r2 == null && r1 != null) {
            return r1;
        } else {
            return createTree(r1, r2);
        }
    }

    public TreeNode createTree(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null)
        return null;
        int a=0;int b=0;
        if(r1==null && r2!=null){
            b=r2.val;
        }
        else if(r1!=null && r2==null){
            a=r1.val;
        }
        else{
            a=r1.val;
            b=r2.val;
        }
        TreeNode temp=new TreeNode(a+b);
        if(r1==null && r2!=null){
            temp.left=createTree(r1,r2.left);
        }
        else if(r1!=null && r2==null){
            temp.left=createTree(r1.left,r2);
        }
        else{
            temp.left=createTree(r1.left,r2.left);
        }
        if(r1==null && r2!=null){
            temp.right=createTree(r1,r2.right);
        }
        else if(r1!=null && r2==null){
            temp.right=createTree(r1.right,r2);
        }
        else{
            temp.right=createTree(r1.right,r2.right);
        }
        return temp;
    }
}