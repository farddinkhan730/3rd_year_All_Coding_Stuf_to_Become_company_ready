package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
class Edge1{
    int v;
    int nbr;
    double wt;

    public Edge1(int v, int nbr, double wt) {
        this.v = v;
        this.nbr = nbr;
        this.wt = wt;
    }
}
class Pair1{
    int v;
    double t;

    public Pair1(int v, double t) {
        this.v = v;
        this.t = t;
    }
}
public class Path_with_Maximum_Probability {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<Edge1> graph[]=new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1=edges[i][0];
            int v2=edges[i][1];
            double wt=succProb[i];
                graph[v1].add(new Edge1(v1,v2,wt));
            graph[v2].add(new Edge1(v2,v1,wt));
        }
        boolean visited[]=new boolean[n];

        PriorityQueue<Pair1> q=new PriorityQueue<>(new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                if (o1.t==o2.t) return 0;
                return o2.t>o1.t?1:-1;
            }
        });

        q.add(new Pair1(start,1));
        while (q.size()>0){
            Pair1 rem=q.poll();
            if(visited[rem.v]) continue;
            visited[rem.v]=true;

            n--;
            if (rem.v==end) return rem.t;
            for (Edge1 e:graph[rem.v]) {
                if (!visited[e.nbr]){
                    q.add(new Pair1(e.nbr,e.wt*rem.t));
                }
            }
        }
        return 0;

    }
    public static void main(String[] args) {
        int n=5;
              int edge[][]=  {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double b[]={0.37,0.17,0.93,0.23,0.39,0.04};
        int s=3;
        int d=4;
        System.out.println(maxProbability(n,edge,b,s,d));
    }
}