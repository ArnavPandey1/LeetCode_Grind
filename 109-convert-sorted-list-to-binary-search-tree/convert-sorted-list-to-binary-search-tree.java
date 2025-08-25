/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer>l1=new ArrayList<>();
        while(head!=null){
            l1.add(head.val);
            head=head.next;
        }
        return createTree(l1,0,l1.size()-1);
    }
    public TreeNode createTree(List<Integer>l1,int low,int high){
        if(low>high)
        return null;
        int pos=(high+low)/2;
        TreeNode temp=new TreeNode(l1.get(pos));
        temp.left=createTree(l1,low,pos-1);
        temp.right=createTree(l1,pos+1,high);
        return temp;
    }
}