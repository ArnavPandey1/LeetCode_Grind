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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (root.val == key) {
            return delete(root);
        }
        TreeNode temp = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = delete(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = delete(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return temp;
    }

    public TreeNode delete(TreeNode rt) {
        if (rt.right == null)
            return rt.left;
        else if (rt.left == null) {
            return rt.right;
        }
        TreeNode t = findRightMostOfLeft(rt.left);
        t.right = rt.right;
        return rt.left;
    }

    public TreeNode findRightMostOfLeft(TreeNode r) {
        TreeNode temp = r;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }
}