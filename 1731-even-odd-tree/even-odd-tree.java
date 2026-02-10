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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> l1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.remove();
                if (level % 2 == 0) {
                    if (temp.val % 2 == 0) {
                        return false;
                    }
                    if (l1.size() != 0 && l1.get(l1.size() - 1) >= temp.val) {
                        return false;
                    }
                    l1.add(temp.val);
                } else {
                    if (temp.val % 2 != 0) {
                        return false;
                    }
                    if (l1.size() != 0 && l1.get(l1.size() - 1) <= temp.val) {
                        return false;
                    }
                    l1.add(temp.val);
                }
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            level++;
        }
        return true;
    }
}