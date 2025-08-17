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
    List<Integer> l1 = new ArrayList<>();

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
         traverse(root); 
         l1.add(val);
         return traverse2(0,l1.size()-1); 
    }

    public TreeNode traverse2(int low, int high) {
        if (low > high)
            return null;
        int pos = findMax(low, high);
        TreeNode temp = new TreeNode(l1.get(pos));
        temp.left = traverse2(low, pos - 1);
        temp.right = traverse2(pos + 1, high);
        return temp;
    }

    public int findMax(int low, int high) {
        int max = l1.get(low);
        int k = low;
        for (int i = low; i <= high; i++) {
            if (max < l1.get(i)) {
                max = l1.get(i);
                k = i;
            }
        }
        return k;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        l1.add(root.val);
        traverse(root.right);
    }

}