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
    public static List<List<Integer>> l1 = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int tar) {
         l1 = new ArrayList<>();
        if (root == null) {
            return l1;
        }
        List<Integer> l2 = new ArrayList<>();
        Traverse(root, tar, l2, 0);
        return l1;
    }

    public static void Traverse(TreeNode r, int tar, List<Integer> l2, int s) {
        if (r == null) {
            return;
        }
        l2.add(r.val);
        s = s + r.val;
        if (r.left == null && r.right == null) {
            if (s == tar) {
                l1.add(new ArrayList<>(l2));
            }
        }
        else{
        Traverse(r.left, tar, l2, s);
        Traverse(r.right, tar, l2, s);
        }
        l2.remove(l2.size() - 1);
    }
}