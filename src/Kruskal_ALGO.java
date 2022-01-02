import java.util.*;

public class Kruskal_ALGO {

    class Edge
//    {
            implements Comparable<Edge>{
        int src,dst,weight;
        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    class Subset{
        int parent,rank;
    }
    int v,e;
    Edge edge[];
    Kruskal_ALGO(int v,int e){
        this.v=v;
        this.e=e;
        edge=new Edge[e];
        for (int i = 0; i <e ; i++) {
            edge[i]=new Edge();
        }
    }
    int find(Subset subset[],int i) {
        if(subset[i].parent!=i) {
            subset[i].parent=find(subset,subset[i].parent);
        }
        return subset[i].parent;
    }
    void union(Subset subset[],int x,int y) {

        int xroot = find(subset, x);
        int yroot = find(subset, y);

        if (subset[xroot].rank < subset[yroot].rank) {
            subset[xroot].parent = yroot;
        } else if (subset[xroot].rank > subset[yroot].rank) {
            subset[yroot].parent = xroot;
        } else {
            subset[xroot].parent = yroot;
            subset[yroot].rank++;
        }
    }
    void kruskal_Mst(){
        Edge re[]=new Edge[v];
        for (int i = 0; i < v; i++) {
            re[i]=new Edge();
        }
        Subset subset[]=new Subset[v];
        for (int i = 0; i < v; i++) {
            subset[i]=new Subset();
        }
        for (int i = 0; i < v; i++) {
            subset[i].parent=i;
            subset[i].rank=0;
        }
        int j=0,e=0;
        while (e<v-1){
            Edge next_edge=edge[j++];
            int x=find(subset,next_edge.src);
            int y=find(subset,next_edge.dst);

            if (x!=y){
                re[e++]=next_edge;
                union(subset,x,y);
            }
        }
        int minimumCost = 0;
        for (int i = 0; i < e; ++i)
        {
            System.out.println(re[i].src + " -- " + re[i].dst + " == " + re[i].weight);
            minimumCost += re[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);

    }
    public static void main(String[] args) {
        int v=4,e=5;
        Kruskal_ALGO graph=new Kruskal_ALGO(v,e);
        graph.edge[0].src=0;
        graph.edge[0].dst=1;
        graph.edge[0].weight=10;

        graph.edge[1].src=0;
        graph.edge[1].dst=2;
        graph.edge[1].weight=6;

        graph.edge[2].src=2;
        graph.edge[2].dst=3;
        graph.edge[2].weight=4;

        graph.edge[3].src=3;
        graph.edge[3].dst=1;
        graph.edge[3].weight=15;

        graph.edge[4].src=0;
        graph.edge[4].dst=3;
        graph.edge[4].weight=5;
//        Arrays.sort(graph.edge, new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return o1.weight-o2.weight;
//            }
//        });
        Arrays.sort(graph.edge);
        graph.kruskal_Mst();
        for (int i = 0; i < e; i++) {
            System.out.println(graph.edge[i].src+" " +graph.edge[i].dst+" " +graph.edge[i].weight);
        }
    }
}
class Graph_implementaion{

    static void addedge_addList(ArrayList<ArrayList<Integer>> adj,int src,int dst){
        adj.get(src).add(dst);
        adj.get(dst).add(src);
    }
    static void dfs_adj(ArrayList<ArrayList<Integer>> adj){

        ArrayList<Boolean> b=new ArrayList<Boolean>();
        Stack<ArrayList<Integer>> s=new Stack<>();
        s.push(adj.get(0));
        b.add(0,true);
        while (!s.isEmpty()){
            ArrayList temp=s.pop();
            for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));

            }

            ListIterator<ArrayList<Integer>> itr=adj.listIterator();
            while (itr.hasNext()){


                if(!b.get(adj.indexOf(itr.next()))){
                    s.push(itr.next());
                }
            }

        }
    }
    static void addedge_addMatrix(int mat[][],int src,int dst){
        mat[src][dst]=1;
        mat[dst][src]=1;
    }
    static void dfs(int mat[][],int current,boolean v[]){

        System.out.println(current);
        v[current]=true;
        for (int i = 0; i <mat.length ; i++) {
            if(mat[current][i]==1 && !v[i]){
                dfs(mat,i,v);
            }
        }
    }
    static  void  bfs(int mat[][],boolean v[],int i){

        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        v[i]=true;
        while (!q.isEmpty()){
            int temp=q.poll();
            System.out.println(mat[temp]);
            for (int j = 0; j < mat.length; j++) {
                if(!v[j] && mat[temp][j]==1){
                    q.add(j);
                    v[j]=true;
                }
            }
        }
    }
    static boolean haspathdfs(int mat[][],boolean v[],int srs,int dst){
        if (srs==dst){
//            System.out.println("True");
            return true;
        }
        v[srs]=true;
        for (int i = 0; i < mat.length; i++) {
            if(mat[srs][i]==1 && !v[i]){
                return  haspathdfs(mat,v,i,dst);
//                System.out.println(true);
//                return;
            }
        }
        return false;
    }
    public static void main(String[] args) {

//        Addjacency List
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <4 ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addedge_addList(adj,0,1);
        addedge_addList(adj,0,2);
        addedge_addList(adj,0,3);
//        addedge(adj,1,3);
//        addedge(adj,0,1);
        addedge_addList(adj,2,3);
        addedge_addList(adj,3,1);
        dfs_adj(adj);
//        for (int i = 0; i <adj.size() ; i++) {
//            System.out.println("\nAdjacency list of vertex " + i);
//            System.out.print("head ");
//            for (int j = 0; j <adj.get(i).size() ; j++) {
//                System.out.print(adj.get(i).get(j));
//            }
//            System.out.println();
//        }

//         Addjacency Matrix
//        int adjmat[][]=new int[4][4];
//        for (int i = 0; i <4 ; i++)
//        Arrays.fill(adjmat[i],0);
//
//        addedge_addMatrix(adjmat,0,1);
//        addedge_addMatrix(adjmat,0,2);
//        addedge_addMatrix(adjmat,0,3);
//        addedge_addMatrix(adjmat,2,3);
//        addedge_addMatrix(adjmat,3,1);
////        addedge_addMatrix(adjmat,0,1);
////        for (int i = 0; i <4 ; i++) {
////            for (int j = 0; j < 4; j++) {
////                System.out.print(adjmat[i][j] + "       ");
////            }
////            System.out.println();
////        }
//        boolean visited[]=new boolean[adjmat.length];
////        dfs(adjmat,0,visited);
////        bfs(adjmat,visited,0);
//        Arrays.fill(visited,false);
//        System.out.println( haspathdfs(adjmat,visited,2,1));
    }
}

class fib{

    static int fibnoc(int n,int dp[]){
        if(n==0){
            return 0;
        }
        if(n==1)
            return 1;
        if(dp[n]>0){
            return dp[n];
        }
//        System.out.println("hello " + n);
        return  dp[n]=fibnoc(n-1,dp)+fibnoc(n-2,dp);

    }
    public static void main(String[] args) {
        int n=10;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibnoc(n,dp));
    }
}
abstract  class mp{
    public abstract void mpp();
    abstract void cc();
}
class pc extends mp{

    @Override
    public void mpp() {
        System.out.println("hello");
    }

    @Override
    void cc() {
        System.out.println("Bye");
    }

    public static void main(String[] args) {
        pc obj=new pc();
        obj.cc();
        obj.mpp();
    }
}
class test{
    static  {
        System.out.println("static block");
    }

    public static void main(String[] args) {
        System.out.println("Main");
    }
}