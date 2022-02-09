package LeetCode.Linked_List;

import java.util.Scanner;

public class reverse_k_group {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rev(ListNode head){
            ListNode curr=head,prev=null;
            while(curr!=null){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            return prev;
        }
        public static ListNode reverseEvenLengthGroups(ListNode head) {
            if(head==null || head.next==null ){
                return head;
            }
            int k=2;
            ListNode t=head.next,temp=t,prev=head;
            ListNode ans=head;
            ListNode temp3=null;
            ListNode temp2=null;
            while(temp!=null){
                ListNode temp1=temp;

                for(int i=1;i<k && temp1!=null;i++)
                {
                    temp1=temp1.next;

                }
                if(temp1==null){
                    break;
                }
                if(k%2==0){
                    temp2=temp1.next;
                    temp1.next=null;
                    ListNode tp=rev(temp);
                    if(prev!=null){
                        prev.next=temp1;
                        prev=temp;
                    }
                    temp3=temp;
                    temp.next=temp2;
                    temp=temp.next;
                }
                else{
                    prev=temp1;
                    temp=temp1;
                    temp=temp.next;
                    temp3=temp;
                }
                k++;
            }
            if(temp2!=null && temp2.next!=null){
                ListNode tpp=temp3.next;
                System.out.println(temp3.val+" "+temp3.next.val+" "+temp2.val+" "+ temp2.next.val);
                temp3.next=null;
                ListNode kp=rev(tpp);
                temp3.next=kp;
            }
            return ans;
        }
    public static void display(ListNode h){
        while (h!=null){
            System.out.println(h.val);
            h=h.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        reverse_k_group ls=new reverse_k_group();
        ListNode h=new ListNode(0);
        ListNode head=h;
        for (int i = 0; i <s ; i++) {
            head.next=new ListNode(sc.nextInt());
            head=head.next;
        }
        display( reverseEvenLengthGroups(h.next));
    }
}
