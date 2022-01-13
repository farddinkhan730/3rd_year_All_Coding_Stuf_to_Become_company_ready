package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class insertionclass {
    class Edge{
        int src;
        int dst;
        int val;
        Edge(int src,int dst){
            this.src=src;
            this.dst=dst;
        }
        Edge(int src,int dst,int val){
            this.src=src;
            this.dst=dst;
            this.val=val;
        }
    }
    static class Pair{
        int v;
        int t;
        int k;
        Pair(int v,int t){
            this.v=v;
            this.t=t;

        }

        public Pair(int v, int t, int k) {
            this.v = v;
            this.t = t;
            this.k = k;
        }
    }
    public static void addEdge(ArrayList<Integer>graph[], int v1, int v2){
        graph[v1].add(v2);
        graph[v2].add(v1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //No .of vertex
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int e = sc.nextInt(); //no of edge
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addEdge(graph, v1, v2);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                System.out.println("src" + i + " dest " + j);
            }
        }

//         adjecency matrix insertion

        }

    }
