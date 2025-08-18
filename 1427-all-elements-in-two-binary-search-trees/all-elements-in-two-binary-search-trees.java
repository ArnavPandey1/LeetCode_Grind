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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        traverse(root1, l1);
        traverse(root2, l2);
        int ll1 = 0;
        int ll2 = 0;
        while (ll1 < l1.size() && ll2 < l2.size()) {
            if (l1.get(ll1) < l2.get(ll2)) {
                l3.add(l1.get(ll1));
                ll1++;
            } else if (l1.get(ll1) > l2.get(ll2)) {
                l3.add(l2.get(ll2));
                ll2++;
            } else {
                l3.add(l1.get(ll1));
                ll1++;
                l3.add(l2.get(ll2));
                ll2++;
            }
        }
        while (ll1 < l1.size()) {
            l3.add(l1.get(ll1));
            ll1++;
        }
        while (ll2 < l2.size()) {
            l3.add(l2.get(ll2));
            ll2++;
        }
        return l3;

    }

    public void traverse(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        traverse(root.left, l);
        l.add(root.val);
        traverse(root.right, l);
    }
}