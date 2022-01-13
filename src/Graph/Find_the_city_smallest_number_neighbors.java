package Graph;
import Graph.Edge;
import java.util.ArrayList;
import java.util.Arrays;

public class Find_the_city_smallest_number_neighbors
{
    static int count=0,c=0;
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int wt=edges[i][2];
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        boolean visited[]=new boolean[n];
        for (int i = 0; i <n ; i++) {
            if(!visited[i])
            findTheCity1(graph,i,distanceThreshold,visited,0);
            Arrays.fill(visited,false);
            c=0;
        }
        return count;
    }

    public static void findTheCity1(ArrayList<Edge> graph[],int src,int distanceThreshold,
                             boolean visited[],int w) {
        if (w>distanceThreshold){
            return;
        }
        c++;
        if (w<=distanceThreshold){
            if (count<c && c<=distanceThreshold){
                count=c;
                return;
            }
        }
        visited[src]=true;
        for (Edge e:graph[src]) {
            if (!visited[e.dest]){
                findTheCity1(graph,e.dest,distanceThreshold,visited,w+e.wt);
            }
        }
//        visited[src]=false;
    }
        public static void main(String[] args) {
            int n=4;
            int edge[][]={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
            int dis=4;
            System.out.println(findTheCity(n,edge,dis));
    }
}