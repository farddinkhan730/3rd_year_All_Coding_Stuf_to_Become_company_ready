package Graph;
import Graph.insertionclass.Pair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class cheapest_flight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>graph[]=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <n ; i++) {
            int v1=flights[i][0];
            int v2=flights[i][1];
            int wt=flights[i][2];
            graph[v1].add(new Edge(v1,v2,wt));
        }
        if(k==0){
            for (Edge i :graph[src]) {
                if(i.dest==dst){
                    return i.wt;
                }
            }
        }
        boolean v[]=new boolean[n];
        PriorityQueue<Pair> q=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.t-o2.t;
            }
        });
        q.add(new Pair(src,0));
        while (q.size()>0){
            Pair rem=q.poll();

            if (rem.v==dst) return rem.t;
            if (rem.k>k){
                continue;
            }
            v[rem.v]=true;
            k--;
            for (Edge e:graph[rem.v]) {
//                if (!v[e.dest])
                q.add(new Pair(e.dest,e.wt+rem.t,rem.k+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n=3;
        int f[][]={{0,1,100},{1,2,100},{0,2,500}};
        int s=0;
        int d=2,k=1;
        System.out.println(findCheapestPrice(n,f,s,d,k));
    }
}
