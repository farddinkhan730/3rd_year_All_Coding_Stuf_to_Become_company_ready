package Graph;

import java.util.*;

//public class juspay {
//
//    static class pair{
//        int v,sum;
//        pair(int v,int sum){
//            this.v=v;
//            this.sum=sum;
//        }
//    }
//    static int ans=0;
//    public  static  int solution(int arr[]){
//        int n=arr.length;
//        List<List<Integer>> g=new ArrayList<>();
//        for (int i = 0; i <=n ; i++) {
//            g.add(new ArrayList<>());
//        }
//        for (int i = 0; i <n ; i++) {
//            if(arr[i]!=-1){
//                g.get(i).add(arr[i]);
//            }
//        }
//        int largesum=0;
//        for (int i = 0; i <=n ; i++) {
//            ans=0;
//            boolean mark[]=new boolean[n+1];
//            bfs(g,i,mark,i);
//            largesum=Math.max(largesum,ans);
//        }
//        return largesum==0?-1:largesum;
//    }
//    static void bfs( List<List<Integer>> g, int src, boolean mark[], int st){
//        Queue<pair> q=new LinkedList<>();
//        q.add(new pair(src,src));
//        while (!q.isEmpty()){
//            pair a=q.poll();
//            mark[a.v]=true;
//            for (int e:g.get(a.v)) {
//                if (e==st && mark[e]){
//                    ans=a.sum ;
//                }
//                if (!mark[e]){
//                    q.add(new pair(e,a.sum+e));
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
////        int a[]={4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
//        int a[]={4,5,1,6,5,2,1,5,10,10};
//
////        System.out.println(a.length);
//
//        System.out.println(solution(a));
//    }
//}
////
//class jpay {
//
//    static class pair{
//        int v,sum;
//        pair(int v,int sum){
//            this.v=v;
//            this.sum=sum;
//        }
//    }
//    public  static  int solution(int arr[]){
//        int n=arr.length;
//        List<List<Integer>> g=new ArrayList<>();
//        for (int i = 0; i <=n ; i++) {
//            g.add(new ArrayList<>());
//        }
//        for (int i = 0; i <n ; i++) {
//            if(arr[i]!=-1){
//                g.get(i).add(arr[i]);
//            }
//        }
//        int a[]=bfs(g,n);
//        int v=0;
//        int mx=-1;
//        for (int i = 0; i < a.length; i++) {
//            if(a[i]>mx){
//                mx=a[i];
//                v=i;
//            }
//        }
//
////        int largesum=0;
////        for (int i = 0; i <n ; i++) {
////            boolean mark[]=new boolean[n+1];
////            bfs(g,i,mark);
////            largesum=Math.max(largesum,ans);
////        }
//        return v;
//    }
//    static int[] bfs( List<List<Integer>> g,int n){
//        int indeg[]=new int[n];
//        for (int i = 0; i <n+1; i++) {
//            for (int e:g.get(i)){
//                indeg[e]++;
//            }
//        }
//        return indeg;
//
//    }
//
//    public static void main(String[] args) {
//        int a[]={4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
////        int a[]={4, 4,1,11,3,8,8,8,0,8,-1,9};
//
////        System.out.println(a.length);
//        System.out.println(solution(a));
//    }
//
//}
//
//

 class jsy {

    static class pair{
        int v,dst;
        pair(int v,int dst){
            this.v=v;
            this.dst=dst;
        }
    }

    static int sdst[],ddst[];
    public  static  int solution(int arr[],int src,int dst) {
        int n = arr.length;
        sdst = new int[n];
        ddst = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                g.get(i).add(arr[i]);
            }
        }
        boolean mark[]=new boolean[n+1];
        bfs(g,src,mark,true);
        bfs(g,dst,mark,false);

        for (int i = 0; i <sdst.length ; i++) {
            System.out.print(sdst[i]+" ");
        }
        System.out.println();
        for (int i = 0; i <ddst.length ; i++) {
            System.out.print(ddst[i]+" ");
        }
        return 0;
    }
    static void bfs( List<List<Integer>> g, int src,boolean mark[],boolean b){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,0));
        while (!q.isEmpty()){
            pair a=q.poll();
            mark[a.v]=true;
            if (b){
                sdst[src]=a.dst;
            }
            else {
                ddst[src]=a.dst;
            }
            for (int e:g.get(a.v)) {

                if (!mark[e]){
                    q.add(new pair(e,a.dst+1));
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]={4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
//        int a[]={4,5,1,6,5,2,1,5,10,10};

//        System.out.println(a.length);

        System.out.println(solution(a,9,2));
    }
}