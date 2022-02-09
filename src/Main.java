import javax.xml.soap.Node;
import java.util.*;

//
//import java.util.*;
//
//public class Main {
//    private class Node {
//        int data;
//        Node next;
//        Node(int data){
//            this.data=data;
//            this.next=null;
//        }
//        Node(){
//            this.next=null;
//        }
//
//    }
//
//    private Node head;
//    private Node tail;
//    private int size;
//
//    // private Node tamp = head;
//
//    public int getfirst() throws Exception {
//        if (size == 0) {
//            throw new Exception(" LL is empty");
//
//        }
//
//        return this.head.data;
//    }
//
//    public int getlast() throws Exception {
//        if (size == 0) {
//            throw new Exception(" LL is empty");
//
//        }
//
//        return this.tail.data;
//    }
//
//    public int getat(int k) throws Exception {
//        if (size == 0) {
//            throw new Exception(" LL is empty");
//
//        }
//        if (k < 0 || k >= size) {
//            throw new Exception(" Invailed index");
//
//        }
//
//        Node temp = this.head;
//        for (int i = 1; i <= k; i++) {
//            temp = temp.next;
//        }
//
//        return temp.data;
//    }
//
//    public void display() {
//
//        Node temp = this.head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//
//    }
//    public void display1(Node t) {
//
//        Node temp = t;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//
//    }
//    public void addLast(int item) {
//        Node nn = new Node();
//
//        nn.data = item;
//        nn.next = null;
//        if (this.size == 0) {
//            this.head = nn;
//            this.tail = nn;
//            this.size++;
//
//        } else {
//            this.tail.next = nn;
//            this.tail = nn;
//            this.size++;
//        }
//    }
//
//    public void addfirst(int item) {
//        Node nn = new Node();
//
//        nn.data = item;
//        nn.next = null;
//        if (this.size == 0) {
//            nn.next = this.head;
//            this.head = nn;
//            this.tail = nn;
//            this.size++;
//
//        } else {
//            nn.next = this.head;
//            this.head = nn;
//            this.size++;
//        }
//    }
//
//    private Node getnode(int k) throws Exception {
//        if (size == 0) {
//            throw new Exception(" LL is empty");
//
//        }
//        if (k < 0 || k >= size) {
//            throw new Exception(" Invailed index");
//
//        }
//
//        Node temp = this.head;
//        for (int i = 1; i <= k; i++) {
//            temp = temp.next;
//        }
//
//        return temp;
//    }
//
//    public void addat(int k, int item) throws Exception {
//        if (this.size == 0) {
//            throw new Exception("LL is empty");
//        }
//        if (k == 0) {
//            addfirst(item);
//        } else if (k == this.size) {
//            addLast(item);
//        } else {
//            Node nn = new Node();
//
//            nn.data = item;
//            nn.next = null;
//
//            Node nm1 = getnode(k - 1);
//            Node np1 = getnode(k);
//            nm1.next = nn;
//            nn.next = np1;
//            this.size++;
//
//        }
//
//    }
//
//    public int removefirst() throws Exception {
//        if (this.size == 0) {
//            throw new Exception("LL is empty");
//        }
//        int tamp = this.head.data;
//        if (this.size == 1) {
//            this.head = null;
//            this.tail = null;
//            this.size = 0;
//        } else {
//            this.head = this.head.next;
//            this.size--;
//        }
//
//        return tamp;
//    }
//
//    public int removelast() throws Exception {
//        if (this.size == 0) {
//            throw new Exception("LL is empty");
//        }
//        int tamp = this.tail.data;
//        if (this.size == 1) {
//            this.head = null;
//            this.tail = null;
//            this.size = 0;
//        } else {
//            Node sm2 = getnode(this.size - 2);
//
//            sm2.next = null;
//            tail = sm2;
//            this.size--;
//
//        }
//        return tamp;
//    }
//
//    public int removeat(int k) throws Exception {
//        if (this.size == 0) {
//            throw new Exception("LL is empty");
//        }
//
//        if (k < 0 || k >= size) {
//            throw new Exception(" Invailed index");
//
//        }
//
//        if (k == 0) {
//            return removefirst();
//        } else if (k == this.size - 1) {
//            return removelast();
//        } else {
//            Node nn = new Node();
//
//            Node nm1 = getnode(k - 1);
//            nn = nm1.next;
//            Node np1 = nn.next;
//            nm1.next = np1;
//            this.size--;
//            return nn.data;
//        }
//
//    }
//
//    public int kthformlast(int k) {
//
//        // Write your Code  here
//        Node temp=kthformlast1(this.head,k);
//        return temp!=null?temp.data:0;
//
//    }
//
//    public Node rev(Node head){
//        Node curr=head,prev=null;
//        while (curr!=null){
//            Node next=curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=next;
//        }
//        return prev;
//    }
//    public Node sum(Node head1,Node head2) {
//        Node h1=rev(head1);
//        Node h2=rev(head2);
//        Node add=new Node();
//        Node sumad=add;
//        int carry=0;
//        while (h1!=null || h2!=null){
//            if (h1!=null && h2!=null){
//                int ad=h1.data+h2.data;
//                if(carry>0){
//                    ad+=carry;
//                    carry=0;
//                }
//                carry=ad/10;
//                add.next=new Node(ad%10);
//                h1=h1.next;
//                h2=h2.next;
//            }
//            else if(h1!=null){
//                int ad=h1.data;
//                if (carry>0){
//                    ad+=carry;
//                    carry=0;
//                }
//                carry=ad/10;
//                add.next=new Node(ad%10);
//                h1=h1.next;
//            }
//            else if (h2!=null){
//                int ad=h2.data;
//                if (carry>0){
//                    ad+=carry;
//                    carry=0;
//                }
//                carry=ad/10;
//                add.next=new Node(ad%10);
//                h2=h2.next;
//            }
//            add=add.next;
//        }
//        if (carry>0){
//            add.next=new Node(carry);
//            add=add.next;
//        }
//
//    return rev(sumad.next);
//    }
//
//    int i;
//    public Node kthformlast1(Node head,int k) {
//
//        // Write your Code  here
//        if(head.next==null){
//            return head;
//        }
//        Node temp=kthformlast1(head.next,k);
//        if (i!=k)i++;
//        if(k==i){
//            return temp;
//        }
//        return head;
//    }
//    public int len(Node head){
//        int i=0;
//        while (head!=null){
//            i++;
//            head=head.next;
//        }
//        return i;
//    }
//    public int intersect(Node headA,Node headB){
//        Node A = headA;
//        Node B = headB;
//        int l1=len(A);
//        int l2=len(B);
//
//        for (int j = 0; j <(l1>l2?l1:l2) ; j++) {
//            if (l1>l2){
//                A=A.next;
//            }
//            else {
//                B=B.next;
//            }
//        }
//        while (A!=null && B!=null){
//            if (A==B){
//                return A.data;
//            }
//        }
//        return 0;
//
////        while (A != B) {
////            if (A != null) {
////                A = A.next;
////            } else {
////                A = headB;
////            }
////
////            if (B != null) {
////                B = B.next;
////            } else {
////                B = headA;
////            }
////        }
////        return A==null?0:A.data;
//    }
//    public static void main(String[] args) throws Exception {
//
//        Scanner sc = new Scanner(System.in);
//
//        Main list = new Main();
//        Main list1 = new Main();
//        int item = sc.nextInt();
//
//        for (int i = 0; i <item ; i++) {
//            int it = sc.nextInt();
//            list.addLast(it);
//        }
//        int item1 = sc.nextInt();
//        for (int i = 0; i <item1 ; i++) {
//            int m1 = sc.nextInt();
//            list1.addLast(m1);
//        }
////        list.display1(list.sum(list.head, list1.head));
//        System.out.println(list.intersect(list.head,list1.head));
//    }
//}
//class mnn{
//    public static String mk(String s){
//
//        char c[]=s.toCharArray();
////        HashMap<Character,Integer> hm=new HashMap<>();
//        Arrays.sort(c);
//        char lrn='1',lrga='a';
//        for (int i = 0; i <s.length() ; i++) {
//            if (c[i]>lrn){
//                lrn=c[i];
//            }
//            if (c[i]>lrga){
//                lrga=c[i];
//            }
//        }
//        int l=0,la=0;
//        for (int i = 0; i <c.length ; i++) {
//            if(c[i]==lrn){
//                l++;
//            }
//            if (c[i]==lrga){
//                la++;
//            }
//        }
//        int idx=Math.abs(la-l);
//        char cr=' ';
//        if(idx<c.length){
//            cr=s.charAt(idx);
//        }
//        String str="";
//        for (int i = 0; i <c.length ; i++) {
//            if (c[i]==cr){
//                continue;
//            }
//            if (c[i]==' '){
//                c[i]='$';
//                str+=c[i];
//            }
//            else str+=c[i];
//
//        }
//
//        return str;
//    }
//    public static void main(String[] args) {
//        System.out.println(mk("999 aa 22aa"));
//    }
//}
//
//class Main45{
//
//    static int getOcc(String str,char c){
//        int occ = 0;
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)==c)
//                occ++;
//        }
//        return occ;
//    }
//
//    static String rearrange(String str,int sp){
//        StringBuilder sb = new StringBuilder();
//        char c = str.charAt(sp);
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)==' ')
//                sb.append('$');
//            else if(!(c==str.charAt(i) && str.charAt(i)!=' '))
//                sb.append(str.charAt(i));
//        }
//        return sb.substring(0);
//    }
//
//    static void solution(String str){
//        TreeMap<Character,Integer> occ = new TreeMap<>();
//        for(int i=0;i<str.length();i++){
//            occ.put(str.charAt(i),getOcc(str,str.charAt(i)));
//        }
//        int maxChar = 0;
//        int maxNum = 0;
//        for(int i=0;i<str.length();i++){
//            if(str.charAt(i)!=' ' && str.charAt(i)>='A' && str.charAt(i)<='z') {
//                if (maxChar < occ.get(str.charAt(i))) {
//                    maxChar = occ.get(str.charAt(i));
//                }
//            }
//            else if(str.charAt(i)>='0' && str.charAt(i)<='9') {
//                if (maxNum < occ.get(str.charAt(i))) {
//                    maxNum = occ.get(str.charAt(i));
//                }
//            }
//        }
//        System.out.println(rearrange(str,Math.abs(maxChar-maxNum)));
//        System.out.println(occ);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        solution(sc.nextLine());
//        sc.close();
//    }
//
//}
// class stackk{
//    public static void main(String[] args) {
//        Stack<String> inputstack=new Stack();
//        Stack<String> instrstack=new Stack<>();
//        inputstack.push("dairyminl");
//        inputstack.push("kitkat");
//        inputstack.push("chocolical");
//        inputstack.push("meillies");
//        inputstack.push("darkcho");
//        inputstack.push("screami");
//        inputstack.push("chocomad");
//
//        instrstack.push("20");
//        instrstack.push("35");
//        instrstack.push("45");
//        instrstack.push("24");
//        instrstack.push("65");
//
//        instrstack.push("20");
//        instrstack.push("30");
//        Stack<String> outstack=new Stack();
//        Stack<String> outstrstack=new Stack();
//        int counter1=instrstack.size();
//        int counter2=inputstack.size();
//        while (!instrstack.isEmpty() || counter2<(counter1)*2){
//            Integer noofc=Integer.parseInt(instrstack.pop());
//            String choco=inputstack.pop();
//            if (noofc%2==0 || choco.contains("ne")){
//                noofc*=9;
//                outstack.push(noofc.toString());
//            }
//            else if (noofc%3==0 ||choco.contains("e")){
//                noofc*=4;
//                outstack.push(noofc.toString());
//            }
//            else {
//                noofc*=36;
//                outstack.push(noofc.toString());
//            }
//            inputstack.push(choco);
//            counter2+=1;
//        }
//        while (!inputstack.isEmpty()){
//            while (!outstack.isEmpty()){
//                outstrstack.push(inputstack.pop()+"_"+outstack.pop());
//            }
//        }
//        System.out.println(outstrstack);
//
////        Stack<String> tempstack=new Stack();
////        Stack<String> tempstack2=new Stack();
////
////        while (!instack.isEmpty()){
////            tempstack.push(instack.pop());
////        }
////        while (!tempstack.isEmpty()){
////            String str1=tempstack.pop();
////            for (int i = 0; i <str1.length()-1 ; i++) {
////                if (str1.substring(i,i+1).equals(str1.substring(i+1,i+2)))
////                tempstack2.push(str1);
////            }
////        }
////        while (!tempstack2.isEmpty())
////            outstack.push(tempstack2.pop());
////        System.out.println(outstack);
//    }
//}
//class hm{
//    public static void find(String s){
//        String str[]=s.split("[a-z]+");
//        ArrayList<Integer> al=new ArrayList<>();
//        for (int i = 0; i <str.length ; i++) {
//            if (str[i]==" "){
//                continue;
//            }
//            System.out.println(str[i]);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner s=new Scanner(System.in);
//        String str=s.nextLine();
//        find(str);
//    }
//}
//
//class mk{
//    public void resmat(int a[][]){
//
//    }
//    public static void main(String[] args) {
//        Scanner s=new Scanner(System.in);
//        int r=s.nextInt();
//        String str="";
//        int size;
//        int m[][]=new int[r][];
//        s.next();
//        for (int i = 0; i <r ; i++) {
//            String sn[]=s.next().split(",");
//
//                for (int j = 0; j < sn.length; j++) {
//                    m[i][j] = Integer.parseInt(sn[j]);
//                }
//        }
//        for (int i = 0; i < m.length; i++) {
//            for (int j = 0; j < m[0].length; j++) {
//                System.out.println(m[i][j]);
//            }
//        }
//        System.out.println(str);
//    }
//}
class anu{
    public static void result(String s1,String s2,int n){
        if(s2.length()<n){
            System.out.println(s1+s2);
            return;
        }
        String ans="";
        while (s1.length()>=n || s2.length()>=n){
            if (s1.length()>=n){
                ans+=s1.substring(0,n);
                s1=s1.substring(n);
            }
            if (s2.length()>=n){
                ans+=s2.substring(0,n);
                s2=s2.substring(n);
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int n=sc.nextInt();
//        System.out.println(s1+" "+s2+" "+n);
        result(s1,s2,n);
    }
}
class anura{
    public static void find_occur(String s){
        String ans="";
        String consans="";
        char c[]=s.toCharArray();
        Arrays.sort(c);
        for (int i = 0; i <c.length ; i++) {
            if (c[i] == 'a' || c[i] == 'o' || c[i] == 'e' || c[i] == 'i' || c[i] == 'u') {
                ans += c[i];
            } else {
                consans += c[i];
            }
        }
        if (!ans.isEmpty()) {
            int idx = s.indexOf(ans.charAt(0));
            ans += idx;
        }
        else {
            ans="NA-1";
        }
        ans+=consans;
        if (!consans.isEmpty()){
            int idx=s.lastIndexOf(consans.charAt(consans.length()-1));
            ans+=idx;
        }

        System.out.println(ans);


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        find_occur(s1);
    }
}
class lution {
//    class pair{
//        int p1,p2;
//        pair(int p1,int p2){
//            this.p1=p1;
//            this.p2=p2;
//        }
//    }
    public static int findPairs(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        int l=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
//                pair p=new pair(nums[i],nums[j]);
                if(Math.abs(nums[i]-nums[j])==k && (!hs.contains(nums[j])||!hs.contains(nums[i]))){
                    hs.add(nums[i]);
                     hs.add(nums[j]);
                     l++;
                }
            }
        }
        return l;

    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{6,3,5,7,2,3,3,8,2,4}
        ,2));
    }

}