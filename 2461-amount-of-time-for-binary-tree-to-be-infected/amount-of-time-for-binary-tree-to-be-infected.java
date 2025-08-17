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
    int timer = 0;
    TreeNode tar = null;

    public int amountOfTime(TreeNode root, int start) {
        timer = 0;
        if (root == null) {
            return timer;
        }
        traverse(root, start);
        int ht = height(tar);
        return Math.max(ht - 1, timer);
    }

    public int traverse(TreeNode rt, int target) {
        if (rt == null)
            return 0;
        if (rt.val == target) {
            tar = rt;
            return -1;
        }
        int l = traverse(rt.left, target);
        int r = traverse(rt.right, target);
        if (l < 0) {
            timer = Math.max(timer, -1 * l + r);
            return l - 1;
        }
        if (r < 0) {
            timer = Math.max(timer, -1 * r + l);
            return r - 1;
        }
        return 1 + Math.max(l, r);
    }

    public int height(TreeNode rt) {
        if (rt == null)
            return 0;
        int l = height(rt.left);
        int r = height(rt.right);
        return 1 + Math.max(l, r);
    }
}