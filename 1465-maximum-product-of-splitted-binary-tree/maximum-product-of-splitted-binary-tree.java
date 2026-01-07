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
    long max = 0;
    long ts=0;
    public int maxProduct(TreeNode root) {
        ts = helper(root);
        helper2(root);
        return (int)(max%1000000007);
    }

    public long helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + helper(root.left) + helper(root.right);
    }
    public long helper2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long ls=helper2(root.left);
        long rs=helper2(root.right);
        max=Math.max(max,(ls+rs+root.val)*(ts-(ls+rs+root.val)));
        return (ls+rs+root.val);
    }
}