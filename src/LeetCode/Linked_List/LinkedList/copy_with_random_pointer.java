package LeetCode.Linked_List.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;

public class copy_with_random_pointer {

// Definition for a Node.
static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
        public static Node copyRandomList(Node head) {
            ArrayList<Node> hs=new ArrayList<>();
            Node dc=new Node(0);
            Node temp=head,tempdc=dc;

            while(temp!=null){
                tempdc.next=new Node(temp.val);
                tempdc=tempdc.next;
                temp=temp.next;
            }
            tempdc=dc.next;
            while (tempdc!=null){
                System.out.println(tempdc.val);
                tempdc=tempdc.next;
            }

            int j=0;
            Node t=dc.next;
            temp=head;
            while(temp!=null){
                tempdc=dc.next;
//                boolean b=false;
                j=0;
                if(temp.random!=null && temp.next!=null && temp.random.next!=null) {
                    while (tempdc != null) {
                        if (temp.random.val == tempdc.val && temp.random.next.val == tempdc.next.val) {
                            hs.add(tempdc);
//                            b = true;
                            break;
                        }
                        j++;
                        tempdc = tempdc.next;
                    }
//                    if (!b){
//                        hs.add(new Node(temp.random.val));
//                    }
                }
                else{
                    tempdc=dc.next;
                    if(temp.random!=null){
                        while (tempdc!=null){
                            if(tempdc.val==temp.random.val){
                                hs.add(tempdc);
                            }
                            tempdc=tempdc.next;
                        }
                    }
                    else
                    hs.add(null);
                }
                temp=temp.next;
                t=t.next;
            }
            System.out.println(hs);
            t=dc.next;
            int i=0;
            while(t!=null){
                t.random=hs.get(i++);
                t=t.next;
            }
            return dc.next;

    }
    private Node head;
    private Node tail;
    private int size;

    public void addFrist(int item) {
        Node nn = new Node(item);
        if (this.size == 0) {

            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            nn.next = this.head;
            this.head = nn;
            this.size++;
        }

    }

    public void addLast(int item) {

        if (this.size == 0) {
            addFrist(item);
        } else {
            Node nn = new Node(item);
            this.tail.next = nn;
            this.tail = nn;
            this.size++;

        }

    }

    public void Crate_Cycle() {

        this.tail.next = this.head;
    }

    public void Display(Node temp) {


        while (temp != null) {
            if (temp.random!=null)
            System.out.println(temp.val+" "+temp.random.val);
            else
                System.out.println(temp.val+" "+temp.random);
            temp = temp.next;
        }
        System.out.println(".");
    }

    public boolean hasCycle() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        copy_with_random_pointer lc = new copy_with_random_pointer();
//        lc.addLast(1);
//        lc.addLast(2);
//        lc.addLast(3);
//        lc.addLast(4);
//        lc.addLast(5);
//        lc.addLast(6);
//        lc.addLast(8);
//        lc.Crate_Cycle();
        //lc.Display();
        Node ls=new Node(3);
        ls.next=new Node(5);
        ls.next.next=new Node(4);
        ls.next.next.next=new Node(-9);
        ls.next.next.next.next=new Node(-10);
        ls.next.next.next.next.next=new Node(5);
        ls.next.next.next.next.next.next=new Node(0);
        ls.next.next.next.next.next.next.next=new Node(6);
        ls.next.next.next.next.next.next.next.next=new Node(-6);
        ls.next.next.next.next.next.next.next.next.next=new Node(3);
        ls.next.next.next.next.next.next.next.next.next.next=new Node(-6);
        ls.next.next.next.next.next.next.next.next.next.next.next=new Node(9);
        ls.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-2);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-3);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-1);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(2);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-3);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-9);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-2);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(-8);
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next=new Node(5);

        ls.random=null;
        ls.next.random=ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.random=null;
        ls.next.next.next.random= ls.next.next.next.next.next;
        ls.next.next.next.next.random=ls.next.next;
        ls.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.random=null;
        ls.next.next.next.next.next.next.next.next.random= ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.random= ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.random=ls.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next.next.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=null;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=ls.next.next.next;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=null;
        ls.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.random=null;
        lc.Display(copyRandomList(ls));
//        System.out.println(lc.hasCycle());
//        Node ls1=new Node(7);
//        ls1.next=new Node(13);
//        ls1.next.next=new Node(11);
//        ls1.next.next.next=new Node(10);
//        ls1.next.next.next.next=new Node(1);
//        ls1.random=null;
//        ls1.next.random=ls1;
//        ls1.next.next.random=ls1.next.next.next.next;
//        ls1.next.next.next.random=ls1.next.next;
//        ls1.next.next.next.next.random=ls1;
//        lc.Display(copyRandomList(ls1));
    }
}
