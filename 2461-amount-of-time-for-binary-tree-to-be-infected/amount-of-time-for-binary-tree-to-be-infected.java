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
    static int time=0;
    public int amountOfTime(TreeNode root, int start) {
        time=0;
        calcTime(root,start);
        TreeNode nn=findNode(root,start);
        return Math.max(time,height(nn)-1);        
    }
    public static TreeNode findNode(TreeNode root,int target){
        if(root==null){
            return null;
        }
        if(target==root.val){
            return root;
        }
        TreeNode left=findNode(root.left,target);
        if(left!=null){
            return left;
        }
        return findNode(root.right,target);
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
    public static int calcTime(TreeNode root,int target){
        if(root==null){
            return 0;
        }
        if(root.val==target){
            return -1;
        }
        int left=calcTime(root.left,target);
        int right=calcTime(root.right,target);
        if(left<0){
            time=Math.max(time,Math.abs(left)+right);
            return left-1;
        }
        if(right<0){
            time=Math.max(time,Math.abs(right)+left);
            return right-1;
        }
        return Math.max(left,right)+1;
    }
}