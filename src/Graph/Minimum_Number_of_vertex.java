package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Minimum_Number_of_vertex {
    public  static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ls=new ArrayList<>();
        int visited[]=new int[n];
        Arrays.fill(visited,0);
        for (int i = 0; i < edges.size() ; i++) {
            for (int j = 0; j < edges.get(i).size()-1; j++) {
                int t=edges.get(i).get(j+1);
                visited[t]++;
//                System.out.println(t);
            }
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                ls.add(i);
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        int n=6;
        List<List<Integer>> edges=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            edges.add(new ArrayList<>());
        }
        edges.get(0).add(0);
        edges.get(0).add(1);
        edges.get(1).add(0);
        edges.get(1).add(2);
        edges.get(2).add(2);
        edges.get(2).add(5);
        edges.get(3).add(3);
        edges.get(3).add(4);
        edges.get(4).add(4);
        edges.get(4).add(2);
        findSmallestSetOfVertices(n,edges);

    }
}
