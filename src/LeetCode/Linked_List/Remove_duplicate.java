package LeetCode.Linked_List;

import java.util.*;

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
    public static void main(String[] args){


    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Stack<Integer> s=new Stack<>();
        ListNode temp=head;
        while (temp!=null){
            if(s.contains(temp.val)){
                s.pop();
            }
            else {
                s.push(temp.val);
            }
            temp=temp.next;
        }
        ListNode tem=new ListNode(0);
        ListNode t=temp;
        Object[] a=s.toArray();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            tem.next=new ListNode((int)a[i]);
            tem=tem.next;
        }
        return t;








//        HashMap<Integer,Integer> mp=new HashMap<>();
//        ListNode temp=head;
//        while(temp!=null){
//            mp.put(temp.val,mp.getOrDefault(temp.val, 0) + 1);
//        }
//        ListNode tem=new ListNode(0);
//        ListNode tem1=temp;
//        for (Map.Entry<Integer,Integer> entry:mp.entrySet()){
//            if(entry.getValue()==0){
//                tem.next=new ListNode(entry.getKey());
//                tem=tem.next;
//            }
//        }
//        return tem1.next;
//

    }
}
class mod{
    public static void main(String[] args) {
        int add=10;
        add=add%10;
        System.out.println(add);
        ArrayList<Pair1> al=new ArrayList<>();
        al.add(new Pair1(4,44));
        al.add(new Pair1(1,23));
        al.add(new Pair1(2,34));
        Collections.sort(al, (o1, o2) -> o1.l-o2.l);

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i).s+" "+al.get(i).l);
        }
    }
}
class Pair1{
    int s;
    int l;
    public Pair1(int s, int i) {
        this.s = s;
        this.l = i;
    }
}
//class mm{
//    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
//        al.add(A);
//        int a[]=new int[5];
//        Arrays.copyOfRange(nums,i,j+1);
//    }
//}
class Main {
    public static void main (String[] args) {
        // Your code here
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();

            System.out.println(Math.max(z-x,z-y));
        }
    }
}
class Solution7542 {
    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length()-o2.length();
            }
        });
        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return nums[nums.length-k];




    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]={"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        System.out.println(kthLargestNumber(s,11));
//        int t=sc.nextInt();
//        while(t-->0){
//            int n=sc.nextInt();
//            int a[]=new int[n];sc.nextInt();
//
//        }
    }
}

class Solutin {
    public static int minSessions(int[] tasks, int sessionTime) {
//        boolean b[]=new boolean[tasks.length];
//        ArrayList<Integer> al=new ArrayList<>();
//        for(int i=0;i<tasks.length;i++){
//            al.add(tasks[i]);
//        }
        Arrays.sort(tasks);
        int sum=0;
        int s=0;
        for (int i = tasks.length-1; i >0 ; i--) {
            sum+=tasks[i];
            if(sum==sessionTime) {
                s++;
                sum = 0;
            }
        }
    return s;

    }

    public static void main(String[] args) {
        int a[]={3,1,3,1,1};
        System.out.println(minSessions(a,8));
        String s="010000000011111111111110";
        int sum=0;
        for (int i = 0; i <s.length() ; i++) {
            sum+=(s.charAt(s.length()-1-i)-'0')*Math.pow(2,i);
//            System.out.println(sum);
        }


        System.out.println(Integer.parseInt("0110",2));

    }
}