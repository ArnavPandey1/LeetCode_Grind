/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
       Node dummy=new Node();
       Node t=dummy;
       Stack<Node>st=new Stack<>();
       Node temp=head;
       while(temp!=null || !st.isEmpty()){
         if(temp==null){
             temp=st.pop();
         }
          dummy.next=temp;
          temp.prev=dummy;
          dummy=dummy.next;
          if(temp.child != null){
            if(temp.next!=null)
            {
              st.push(temp.next);
            }
            Node k=temp.child;
            temp.child=null;
            temp=k;
          }
          else{
            temp=temp.next;
          }
       }
        Node p=t.next;
        t.next=null;
        p.prev=null;
        return p;
    }
}