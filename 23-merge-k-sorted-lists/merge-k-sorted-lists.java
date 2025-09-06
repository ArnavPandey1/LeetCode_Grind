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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            pq.add(lists[i]);
        }
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            ListNode t=pq.remove();
            if(t.next!=null){
                pq.add(t.next);
            }
            dummy.next=t;
            dummy=dummy.next;
        }
        return temp.next;
    }
}