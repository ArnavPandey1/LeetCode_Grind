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
        Pair(int val,int row){
            this.val=val;
            this.row=row;
        }
    }
    TreeMap<Integer,List<Pair>>map=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root,0,0);
        List<List<Integer>>l1=new ArrayList<>();
        for(List<Pair>l:map.values()){
            Collections.sort(l,(a,b)->{
                if(a.row==b.row){
                  return a.val-b.val;
                }
                else{
                   return a.row-b.row;
                }
            });
            List<Integer>l2=new ArrayList<>();
            for(int i=0;i<l.size();i++){
                l2.add(l.get(i).val);
            }
            l1.add(new ArrayList<>(l2));
        }
        return l1;
    }
    public void traverse(TreeNode root,int idx,int row){
        if(root==null){
            return ;
        }
        if(!map.containsKey(idx)){
            map.put(idx,new ArrayList<Pair>());
        }
        map.get(idx).add(new Pair(root.val,row));
        traverse(root.left,idx-1,row+1);
        traverse(root.right,idx+1,row+1);
    }
}