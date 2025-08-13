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
    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return traverse(in, in.length - 1, 0, post, post.length - 1, 0,map);
    }

    public TreeNode traverse(int[] in, int inhi, int inlo, int[] post, int phi, int plo, HashMap<Integer,Integer>map) {
        if (inlo > inhi || plo > phi) {
            return null;
        }
        TreeNode t = new TreeNode(post[phi]);
        int pos =map.get(t.val);
        t.left = traverse(in, pos - 1, inlo, post, phi-(inhi-pos)-1, plo,map);
        t.right = traverse(in, inhi, pos + 1, post, phi - 1, plo + (pos - inlo),map);
        return t;
    }
}