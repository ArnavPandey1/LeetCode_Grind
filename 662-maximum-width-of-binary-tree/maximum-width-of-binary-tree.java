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
    class Pair {
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx) {
            this.node=node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        Queue<Pair> q = new LinkedList<>();
        int max=0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pStart = q.peek();
            Pair pEnd=q.peek();
            int n = q.size();
            while (n > 0) {
                pEnd = q.remove();
                if (pEnd.node.left != null) {
                    q.add(new Pair(pEnd.node.left, 2 * pEnd.idx + 1));
                }
                if (pEnd.node.right != null) {
                    q.add(new Pair(pEnd.node.right, 2 * pEnd.idx + 2));
                }
                n--;
            }
            max=Math.max(max,pEnd.idx-pStart.idx+1);
        }
        return max;
    }
}