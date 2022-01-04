package Graph;

import com.sun.org.glassfish.external.amx.AMX;

import java.util.ArrayList;
import java.util.List;

public class MAximum_network_Rank {
    static class Edge {
        int v;
        int nbr;
        int deg;

        Edge(int v, int nbr, int deg) {
            this.v = v;
            this.nbr = nbr;
            this.deg = deg;
        }
    }

    public static void addEdge(List<List<Integer>> graph, int v1, int v2) {
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            addEdge(ls, roads[i][0], roads[i][1]);
        }
        int max = 0;
        for (int i = 0; i < ls.size(); i++) {
            for (int j = i + 1; j < ls.size(); j++) {
                int n1 = ls.get(i).size() + ls.get(j).size() - (ls.get(i).contains(j)?1:0);
                max = Math.max(max, n1);

            }
        }

        return max;
    }

    public static void main(String[] args) {
        int m[][] = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};

        System.out.println(maximalNetworkRank(8, m));
    }
}

class Solution
{
    public static int maximalNetworkRank(int n, int[][] roads)
    {
        // [1] FILL UP INITIAL DATA STRUCTURES
        int mnr = 0; // always defaults to a zero anyways
        // O(N^2) + O(N) space here
        int[][] adjMat = new int[n][n];
        int[] hood = new int[n];

        // O(E) time for edges
        for(int i = 0; i < roads.length; ++i)
        {
            int[] edge = roads[i];
            int src = edge[0];
            int dst = edge[1];
            adjMat[src][dst] = 1;
            adjMat[dst][src] = 1;
            hood[src]++;
            hood[dst]++;
        }

        // [2] EXECUTE THY ALGORITHM
        // O(N^2) number pairs to iterate over
        for(int i = 0; i < n; ++i)
        {
            for(int j = i + 1; j < n; ++j)
            {
                int cur_mnr = hood[i] + hood[j] - adjMat[i][j];
                mnr = Math.max(mnr, cur_mnr);
            }
        }

        return mnr;
    }

    public static void main(String[] args) {
        int m[][] = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};

        System.out.println(maximalNetworkRank(8,m));

    }
}