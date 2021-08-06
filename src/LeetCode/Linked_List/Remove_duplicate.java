package LeetCode.Linked_List;

import java.util.HashSet;

class ListNode{
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Remove_duplicate {
        public ListNode deleteDuplicates(ListNode head) {
            HashSet<Integer> hs=new HashSet<>();
            while(head!=null){
                hs.add(head.val);
                head=head.next;

            }
            Object a[]=hs.toArray();
            ListNode temp=new ListNode(0);
            ListNode temp1=temp;
            for (int i = 0; i <a.length ; i++) {
                temp.next=new ListNode((int)a[i]);
                temp=temp.next;
            }
            return temp1.next;
        }
    public static void main(String[] args) {

    }
}
