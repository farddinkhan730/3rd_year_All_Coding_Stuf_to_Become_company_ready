package Graph;

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
        edgepair p[]=new edgepair[edges.length+1];
        Arrays.fill(p,new edgepair(0,0));
        boolean visited[]=new boolean[edges.length+1];
        for (int i = 1; i < edges.length+1; i++) {
           if(!visited[i]) {
               find(ls, i, 0,visited,0,p);
           }
        }
        int a[]=new int[2];
        boolean b=false;
        for (int i = edges.length-1; i >=0 ; i--) {
            int s=edges[i][0];
            int d=edges[i][1];
            for (int j = 0; j < edges.length ; j++) {
                if(s==p[j].s && d==p[j].d && !b){
                    a[0]=s;
                    a[1]=d;
                    b=true;
                    break;
                }
            }
        }
        return a;
    }
    public static void find(List<List<Integer>> ls,int src,int pre,boolean visited[],int idx,edgepair[] p){
        if(visited[src]){
            p[idx++]=new edgepair(pre,src);
            return;
        }
        visited[src]=true;
        for (int i:ls.get(src)) {
            if (!visited[i])
            find(ls,i,src,visited,idx,p);
        }
        visited[src]=false;
    }
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
