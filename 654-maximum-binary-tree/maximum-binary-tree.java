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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode t=null;
        if(nums.length==0)
        return t;
        t=traverse(nums,0,nums.length-1);
        return t;
    }
    public TreeNode traverse(int []nums,int low,int high){
        if(low>high)
        return null;
        int pos=findMax(nums,low,high);
        TreeNode temp=new TreeNode(nums[pos]);
        temp.left=traverse(nums,low,pos-1);
        temp.right=traverse(nums,pos+1,high);
        return temp;
    }
    public int findMax(int []nums,int low,int high){
        int max=nums[low];int k=low;
        for(int i=low;i<=high;i++){
            if(max<nums[i]){
                max=nums[i];
                k=i;
            }
        }
        return k;
    }
}