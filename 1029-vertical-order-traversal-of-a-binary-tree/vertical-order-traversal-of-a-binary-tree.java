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
    class Pair{
        int row;
        int val;
        Pair(int row,int val){
            this.row=row;
            this.val=val;
        }
    }
    TreeMap<Integer,List<Pair>>map=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        traverse(root,0,0);
        for(int key:map.keySet()){
            List<Pair>l1=map.get(key);
            //sort by row first then by value;
            Collections.sort(l1, (a, b) -> {
                if (a.row == b.row) return a.val - b.val;
                return a.row - b.row;
            });
            List<Integer>l2=new ArrayList<>();
            for(Pair p:l1){
                l2.add(p.val);
            }
            ans.add(l2);
        }
        return ans;
    }
    public void traverse(TreeNode root,int curr,int row){
        if(root==null){
            return ;
        }
        if(!map.containsKey(curr)){
            map.put(curr,new ArrayList<>());
        }
        map.get(curr).add(new Pair(row,root.val));
        map.put(curr,map.get(curr));
        traverse(root.left,curr-1,row+1);
        traverse(root.right,curr+1,row+1);
    }
}