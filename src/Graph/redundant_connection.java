package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class redundant_connection {
    static class edgepair{
        int s;
        int d;
        edgepair(int s,int d){
            this.s=s;
            this.d=d;
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {

        List<List<Integer>> ls=new ArrayList<>();
        for (int i = 0; i < edges.length+1; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i <edges.length ; i++) {
                addEdge(ls,edges[i][0],edges[i][1]);
        }


        boolean visited[]=new boolean[edges.length+1];
        ArrayDeque<List<Integer>> aq=new ArrayDeque<>();
        aq.add(ls.get(0));
        while (aq.size()>0){
            List<Integer> rem=aq.remove();
//            if(visited[rem])
        }
        return new int[3];
    }
//    public static void find(List<List<Integer>> ls,int src,int pre,boolean visited[],int idx,edgepair[] p){
//        if(visited[src]){
//            p[idx++]=new edgepair(pre,src);
//            return;
//        }
//        visited[src]=true;
//        for (int i:ls.get(src)) {
//            if (!visited[i])
//            find(ls,i,src,visited,idx,p);
//        }
//        visited[src]=false;
//    }
    public static void addEdge(List<List<Integer>>graph, int v1, int v2){
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }
    public static void main(String[] args) {
        int a[][]={{1,2},{2,3},{3,4},{1,4},{1,5}};
        int an[]=findRedundantConnection(a);
        for (int i = 0; i <an.length ; i++) {
            System.out.println(an[i]);
        }
    }
}

class Solution5 {

    public static void addEdge(List<List<Integer>>graph, int v1, int v2){
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public static int makeConnected(int n, int[][] connections) {

        List<List<Integer>> ls=new ArrayList<>();
        for (int i = 0; i <= connections.length; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i <connections.length ; i++) {
            addEdge(ls,connections[i][0],connections[i][1]);
        }

        int count=0;
        boolean visited[]=new boolean[connections.length+1];
        ArrayDeque<Integer> aq=new ArrayDeque<>();
        aq.add(0);
        while (aq.size()>0){
            int rem=aq.remove();

            if(visited[rem]){
                count++;
                continue;
            }
            visited[rem]=true;
            for(int i:ls.get(rem)){
                if(!visited[i])
                aq.add(i);
            }
        }
        return count+connections.length>=n?count:-1;
    }

    public static void main(String[] args) {
        int a[][]={{0,1},{0,2},{1,2}};
//                ,
//                {3,4},{1,4},{1,5}};
        System.out.println(makeConnected(4,a));

    }
}
