package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Edge{
    int src;
    int dest;
    int wt;
    Edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
}
class Pair  {
    int v;
    int t;
    Pair(int v,int t){
        this.v=v;
        this.t=t;
    }
}
public class Network_Delay_time {

    public static int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Edge> graph[]=new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <times.length ; i++) {
                graph[times[i][0]].add(new Edge(times[i][0],times[i][1],times[i][2]));
        }
        int count=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.t-o2.t;
            }
        });
//        bfs(pq,graph,k,n);
        pq.add(new Pair(k,0));
        boolean visited[]=new boolean[n+1];
        while (pq.size()>0){
            Pair rem=pq.poll();
            if(visited[rem.v])
            {
                continue;
            }
            visited[rem.v]=true;
            n--;
            count=rem.t;
            for (Edge e:graph[rem.v]) {
                pq.add(new Pair(e.dest,rem.t+e.wt));
            }
        }
        return n==0?count:-1;
    }
    public static void main(String[] args) {
        int times[][]= {{1,2,1},{2,1,3}};
        int n = 2;
        int k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }
}
