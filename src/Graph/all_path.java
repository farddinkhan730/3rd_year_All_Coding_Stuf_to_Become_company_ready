package Graph;

import java.util.ArrayList;
import java.util.List;

public class all_path
{
//    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//
//         List<List<Integer>> ans=new ArrayList<>();
//
//         allPathsSourceTarget1(graph,ans,0,new boolean[graph.length],"0");
//
//         return ans;
//     }
//     static ArrayList<Integer> al=new ArrayList<>();
//     public static void allPathsSourceTarget1(int[][] graph, List<List<Integer>> ans, int src, boolean visited[],String s) {
//         if(graph[src].length==0 && src==graph.length-1){
//             s=s+src;
//             for (int i = 0; i <s.length() ; i++) {
//                 al.add(Integer.parseInt(s.substring(i,i+1)));
//             }
//             ans.add(al);
//             al=new ArrayList<>();
//             return;
//         }
//         visited[src]=true;
//         for(int i:graph[src]){
//             if(!visited[i]) {
//                 allPathsSourceTarget1(graph,ans,i,visited,s+i);
//             }
//         }
//         visited[src]=false;
//     }

//    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//
//        List<List<Integer>> ans=new ArrayList<>();
//
//        allPathsSourceTarget1(graph,ans,0,new boolean[graph.length],"");
//
//        return ans;
//    }
//    static ArrayList<Integer> al=new ArrayList<>();
//    public static void allPathsSourceTarget1(int[][] graph, List<List<Integer>> ans, int src, boolean visited[],String s) {
//        if(graph.length-1==src){
////            s=s+src;
////            for (int i = 0; i <s.length() ; i++) {
////                al.add(Integer.parseInt(s.substring(i,i+1)));
////            }
//
////            al.add(src);
//            List<Integer> completePath = new ArrayList<Integer>(al);
//            completePath.add(src);
//            ans.add(completePath);
////            al=new ArrayList<>();
//            return;
//        }
//        al.add(src);
//        visited[src]=true;
//        for(int i:graph[src]){
//            if(!visited[i]) {
//                allPathsSourceTarget1(graph,ans,i,visited,s+src);
//            }
//        }
//        al.remove(al.size()-1);
//
//        visited[src]=false;
//    }
int count=0;
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here


        allPathsSourceTarget1(edges,s,d,new boolean[edges.length]);
        return count;

    }
    public  void allPathsSourceTarget1(int[][] graph,  int src,int d, boolean visited[]) {
        if(src==d){
            count++;
            return;
        }
        visited[src]=true;
        for(int i:graph[src]){
            if(!visited[i]) {
                allPathsSourceTarget1(graph,i,d,visited);
            }
        }
        visited[src]=false;
    }

    public static void main(String[] args) {

        int graph[][]=  {{0,1},{0,3},{1,2},{3,2}};
        all_path obj =new all_path();
        System.out.println( obj.possible_paths(graph, graph.length, 0,2));
//        List<List<Integer>> al=allPathsSourceTarget(graph);
//        for (int i = 0; i <al.size() ; i++) {
//            for (int j:al.get(i)
//                 ) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
    }
}
