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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();
        preorderTraverse(root, l1);
        return construct(l1);
    }

    public TreeNode construct(List<Integer> l1) {
        return createTree(l1, 0, l1.size() - 1);
    }

    public TreeNode createTree(List<Integer> l1, int low, int high) {
        if (low > high)
            return null;
        int pos = (high + low) / 2;
        TreeNode temp = new TreeNode(l1.get(pos));
        temp.left = createTree(l1, low, pos - 1);
        temp.right = createTree(l1, pos + 1, high);
        return temp;
    }

    public void preorderTraverse(TreeNode root, List<Integer> l1) {
        if (root == null)
            return;
        preorderTraverse(root.left, l1);
        l1.add(root.val);
        preorderTraverse(root.right, l1);
    }
}