package Graph;


import sun.reflect.generics.tree.Tree;

import java.util.*;

class graph {
    static class Edge{
        int src;
        int dst;
        int wt;

        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
        public Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }
    static class Pair{
        int src;
        int dst;
        public Pair(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }
    public static void dfs(ArrayList<Edge> grapg[],int src,boolean visited[]){
        System.out.println(src);
        visited[src]=true;
        for (Edge e: grapg[src]) {
            if (!visited[e.dst]){
                dfs(grapg,e.dst,visited);
            }
        }
    }
    public static void bfs(ArrayList<Edge> graph[],int src,int visited[]){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        while (!q.isEmpty()){
            Pair p=q.poll();
            System.out.println(p.src);
            for (Edge i:graph[p.src]);
        }
    }
//        Adjacency list implementation
    public static void build_graph(ArrayList<Edge> al[],int src,int dst){
            al[src].add(new Edge(src,dst));
            al[dst].add(new Edge(dst,src));
    }
    public static void main(String[] args) {

        ArrayList<Edge>[] graph=new ArrayList[4];
        for (int i = 0; i <graph.length ; i++) {
            graph[i]=new ArrayList<>();
        }
        build_graph(graph,0,1);
        build_graph(graph,1,2);
        build_graph(graph,2,3);
        build_graph(graph,3,0);
        dfs(graph,0,new boolean[graph.length]);
    }

}
class example{
    class student{
        int roll;
        int name;
        int age;

        public student(int roll, int name) {
            this.roll = roll;
            this.name = name;
            age=26;
        }
    }

    public static void main(String[] args) {
        student[] s=new student[5];



    }
}
class Bstree{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }
        public TreeNode(int data) {
            this.data = data;
            left=right=null;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public  static TreeNode  insert(TreeNode root,int data){
        if(root==null){
            TreeNode new_node=new TreeNode(data);
            return new_node;
        }
        if(root.data>data){
            root.left=insert(root.left,data);

        }
        else if (root.data<data){
            root.right=insert(root.right,data);
        }
        return root;
    }

    public static void pre(TreeNode root){
        if (root==null){
            return;
        }

        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }

    public static void inorder(TreeNode root){
        if (root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(TreeNode root){
        if (root==null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(8);
//        root.left=new TreeNode(3);
//        root.left.left=new TreeNode(1);
//        root.left.right=new TreeNode(6);
//        root.left.right.left=new TreeNode(4);
//        root.left.right.right=new TreeNode(7);
//        root.right=new TreeNode(10);
//
//        root.right.right=new TreeNode(14);
//        root.right.right.left=new TreeNode(13);
//        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(6);
//        root.left.right=new TreeNode(4);
//        root.right.left=new TreeNode(5);
        TreeNode root=new TreeNode(1);
        insert(root,5);
        insert(root,4);
        insert(root,6);
        insert(root,3);
        insert(root,7);
        insert(root,2);

        System.out.println("Preorder");
        pre(root);
//        System.out.println();
//        System.out.println("inorder");
//        inorder(root);
//        System.out.println();
//        System.out.println("PostOrder");
//        postorder(root);

    }
}
class  Tree_implement_Array{
    int arr[];
    int last_used_idx;

    public Tree_implement_Array(int n) {
        this.arr = new int[n+1];
        last_used_idx=0;
    }
    public void insert(int val){
        if (last_used_idx==arr.length-1){
            System.out.println("List is full");
            return;
        }
        arr[++last_used_idx]=val;
    }
    public void pre(int i){
        if (i>last_used_idx){
            return;
        }
        System.out.print(arr[i]+" ");
        pre(2*i);
        pre(2*i+1);
    }
    public void inorde(int i){
        if (i>last_used_idx){
            return;
        }
        inorde(2*i);
        System.out.print(arr[i]+" ");
        inorde(2*i+1);
    }

    public void post(int i){
        if (i>last_used_idx){
            return;
        }
        post(2*i);
        post(2*i+1);
        System.out.print(arr[i]+" ");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int level=sc.nextInt();
        Tree_implement_Array tree=new Tree_implement_Array((int)(Math.pow(2,level)-1));
//        put values level wise
        for (int i=0;i<((int)Math.pow(2,level)-1);i++){
            tree.insert(sc.nextInt());
        }

        tree.pre(1);
        System.out.println();
        tree.inorde(1);
        System.out.println();
        tree.post(1);
    }
}