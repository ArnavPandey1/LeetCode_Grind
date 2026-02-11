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
    String min = "~";

    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return min;
    }

    public void helper(TreeNode root, String ans) {
        if (root == null) {
            return;
        }
        char ch = (char) (97 + root.val);
        if (root.left == null && root.right == null) {
            ans = ch + ans;
            if (ans.compareTo(min) < 0) {
                min = "";
                min = min + ans;
            }
        }
        helper(root.left, ch + ans);
        helper(root.right, ch + ans);
    }
}