package Arrays;

import javafx.print.Collation;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class barchart {
    public static void main(String[] args) {
        int n=5;
        int a[]={2,1,4,0,3};
        int max=a[0];
        for(int i=1;i<a.length;i++){
           if(max<a[i]) {
               max = a[i];
           }
        }
        for (int floor = max; floor >0 ; floor--) {
            for (int i = 0; i < a.length ; i++) {
                if(a[i]>=floor){
                    System.out.print("*");
                }
                else
                System.out.print(" ");
            }

            System.out.println();
        }

        int k=131;
        int m=String.valueOf(k).length()-1;
        int b[]=new int[m];
        for (int i = 0; i <=m; i++) {
            b[i]=Integer.parseInt(String.valueOf(k).substring(i,i+1));
        }
        for (int i = 0; i <=m ; i++) {
            System.out.println(b[i]);
        }
    }
}
class add_to_arr {
    public static void main(String[] args) {
        int num[] = {1, 2, 0, 0};
        int k = 34;
        int n = num.length - 1;
        int m = String.valueOf(k).length() - 1;
        int carry = 0;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        while (n >= 0 && k > 0) {
            int rem = k % 10;
            k = k / 10;
            int sum = num[n] + rem;
            if (carry > 0) {
                sum += carry;
                carry = 0;
            }
            if (sum > 9) {
                int d = sum % 10;
                carry = sum / 10;
                sum = d;
            }
            st.push(sum);
            m--;
            n--;
        }
        while (n >= 0) {
            int d = 0;
            d += num[n];
            if (carry > 0) {
                d += carry;
                carry = 0;
            }
            if (d > 9) {
                int d1 = d % 10;
                carry = d / 10;
                d = d1;
            }
            st.push(d);
            n--;
        }
        while (k > 0) {
            int d = 0;
            d += k % 10;
            k /= 10;
            if (carry > 0) {
                d += carry;
                carry = 0;
            }
            if (d > 9) {
                int d1 = d % 10;
                carry = d / 10;
                d = d1;
            }
            st.push(d);

        }
        while (!st.isEmpty()) {
            al.add(st.pop());
        }
        Collections.reverse(al);

    }

}
class help{
    static class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int d) {
            val = d;
            this.left=null;
            this.right=null;
        }
    }
    public static int sumRootToLeaf1(TreeNode root, int re,int i) {
        if (root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
           i=i+1;
            re+=root.val*2*i;
            return re;
        }

        int l=sumRootToLeaf1(root.left,re+=root.val*2*i,i+1);
        int r=sumRootToLeaf1(root.right,re+=root.val*2*i,i+1);
        return l+r;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(1);
        root.right=new TreeNode(1);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(1);
        System.out.println(sumRootToLeaf1(root,0,0));
        String s="100000111";
        int r=0,i=0,j=s.length()-1;
        while (j>=0){
            r+=(s.charAt(j--)-'0')*Math.pow(2,i++);
        }
        System.out.println(r);

    }
}

class f
{
    static boolean areAnagram(char[] str1, char[] str2)
    {
        String string1="Creative";
        String string2="Reactive";
        string1=string1.toLowerCase();
        string2=string2.toLowerCase();
        if (string1.length() != string2.length())
            return false;

        int count1[] = new int[256];
        int count2[] = new int[256];
        Arrays.fill(count1,0);
        Arrays.fill(count2,0);
        boolean isana=true;
        for (char c:string1.toCharArray()
             ) {
            count1[(int) c]++;

        }

        for (char c:string2.toCharArray()
        ) {
            count2[(int) c]++;
        }
        for (int i = 0; i <256 ; i++) {
            if(count1[i]!=count2[i]){
                isana=false;
                break;
            }
        }
        if (isana) System.out.println(1);
        else System.out.println(0);
        return false;
    }

    public static void main(String[] args) {
        char []s1="Creative".toCharArray();
        char []s2="Reactive".toCharArray();
//        System.out.println(areAnagram(s1,s2));

        String string1="Creative";
        String string2="Reactive";
        string1=string1.toLowerCase();
        string2=string2.toLowerCase();
        if (string1.length() != string2.length()){
            System.out.println(0);
            return;
        }
//            return false;


        int count1[] = new int[256];
        int count2[] = new int[256];
        Arrays.fill(count1,0);
        Arrays.fill(count2,0);
        boolean isana=true;
        for (char c:string1.toCharArray()
        ) {
            count1[(int) c]++;

        }

        for (char c:string2.toCharArray()
        ) {
            count2[(int) c]++;
        }
        for (int i = 0; i <256 ; i++) {
            if(count1[i]!=count2[i]){
                isana=false;
                break;
            }
        }
        if (isana) System.out.println(1);
        else System.out.println(0);
    }
        }