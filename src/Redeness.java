import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Redeness
{

    public static void find_circle(String s[]){
        boolean b[]=new boolean[s.length];
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s.length;j++){
                if(i==j) continue;
                if(s[i].charAt(s[i].length()-1)==s[j].charAt(0)){
                    b[i]=true;
                    break;
                }
            }
        }
        for(int i=0;i<b.length;i++){
            if(b[i]==false){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String st[]=new String[n];
        for(int i=0;i<n;i++){
            st[i]=sc.next();

        }
        find_circle(st);
        // System.out.println(find_circle(st)?"True":"False");



    }
}

class mk4{
    public static void ans(int n,int key){
        int noofs=0;
        while(n!=key){
            StringBuilder str=new StringBuilder();
            StringBuilder str1=new StringBuilder();
            System.out.println(str);
            String s2=str.reverse().toString();
            int n1=Integer.parseInt(str.toString()),n2=Integer.parseInt(s2);
            n=Math.abs(n1-n2);
            noofs++;


        }
        System.out.println(noofs);

    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int key=6174;
        ans(n,key);
    }
}
class  graph{
    public static ArrayList<ArrayList<Integer>>   makegraph(String s[]){
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i <26 ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <s.length ; i++) {
           graph.get(s[i].charAt(0)-'a').add(s[i].charAt(s[i].length()-1)-'a');
        }
        return graph;

    }
    static String sp="";
    private static void markconnct(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src,String psf) {
        visited[src] = true;
        for(int i : adj.get(src)){
            if(!visited[i] ){
                markconnct(adj, visited, i,psf+i);
            }
        }
        if(sp.equals("")){
            sp=psf;
        }

    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String st[]=new String[n];
        for(int i=0;i<n;i++){
            st[i]=sc.next();
        }
        boolean visited[]=new boolean[26];
        ArrayList<ArrayList<Integer>> graph= makegraph(st);
        markconnct(graph,visited,st[0].charAt(0)-'a',"");
        System.out.println(sp);
        if (sp.length()==st.length)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
