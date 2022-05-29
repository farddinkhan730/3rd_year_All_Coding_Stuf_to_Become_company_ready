import java.util.*;

class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class tion {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ll=new ArrayList<>();
        vl(root,ll,0);
        return ll;
    }
    static int c=-1;
    public static void vl(TreeNode root, List<List<Integer>> ll,int col) {
        if(root==null){
            return;
        }
        if(c>col){
            c=col;
        }
        vl(root.left,ll,col-1);
        if(col<0){
            if(ll.size()>(-c)+col){
                ll.get((-c)+col-1).add(root.val);
            }
            else{
                List<Integer> l=new ArrayList<>();
                l.add(root.val);
                ll.add(l);
            }
        }
        if(col>=0){
            int idx=-c+col;
            if(ll.size()>=idx+1){
                ll.get(idx).add(root.val);
            }
            else{
                List<Integer> l=new ArrayList<>();
                l.add(root.val);
                ll.add(l);
            }
        }
        vl(root.right,ll,col+1);


    }
    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null){
            return root;
        }
        // if(temp==null){
        //     temp=root;
        // }
        root.left=sufficientSubset(root.left,limit);
        root.right=sufficientSubset(root.right,limit);
        int sl=sum(root.left);
        int sr=sum(root.right);
//        System.out.println(sl+" "+ sr);
        if(sl<limit){
            root.left=null;
        }
        if(sr<limit){
            root.right=null;
        }
        return root;

    }
    public static int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=sum(root.left);
        int r=sum(root.right);
        return l+r+root.val;
    }

    public static void display(TreeNode h){
        if (h==null){
            return;
        }
        System.out.println(h.val);
        display(h.left);
        display(h.right);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
//        List<List<Integer>> l=verticalTraversal(root);
//        for (List<Integer> t:l) {
//            for (int i :t) {
//                System.out.println(i);
//            }
//        }
        TreeNode h=sufficientSubset(root,1);
        display(h);
    }
}
public class vb {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));


            }
        });
        List<List<Integer>> al=new LinkedList<>(pq);
        int x=nums1.length<k?nums1.length:k;
        int y=nums2.length<k? nums2.length : k;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j <y; j++) {
                List<Integer> l=new ArrayList<>();
                l.add(nums1[i]);
                l.add(nums2[j]);
                pq.add(l);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }

        System.out.println(pq);
        while (!pq.isEmpty()){
           if (k<1){
               break;
           }
          else   al.add(pq.poll());

      }

        return al;
    }

    public static void main(String[] args) {

        kSmallestPairs(new int[]{1,7,11},new int[] {2,4,6},3);
    }
}
class tree{
    static class Node{
        int key;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.key = val; }
//        Node(int val) {
//            this.key= val;
//            this.left = null;
//            this.right = right;
//        }
    }
    static int s=0;
    public static Node convertBST(Node root) {
        if(root==null){
            return root;
        }
        Node r=convertBST(root.right);
        if(root!=null){
            s+= root.key;
            root.key=s;
        }
        Node l=convertBST(root.left);
        return root;
    }
    public static void pree(Node roo){
        if (roo!=null)
            return;
        System.out.println(roo.key);
        pree(roo.left);
        pree(roo.right);
    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Node root=new Node(4);
        root.left=new Node(1);
        root.right=new Node(6);
        root.left.left=new Node(0);
        root.left.right=new Node(2);
        root.left.right.right=new Node(3);
        root.right.left=new Node(5);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);
//        while (sc.nextInt()!=-1)
//           root= search(root,sc.nextInt());
        pree(convertBST(root));
        List<Integer> queue=new LinkedList<>();

    }
}
class beautifullnumber{
//    public static int beautifull(int n){
//
//        int min=Integer.MAX_VALUE;
//        int count=0;
//        int t=n;
//        String s="";
//        while (t!=0){
//            int m=t%10;
//            if(m==5||m==6){
//                t/=10;
//                continue;
//            }
//            else {
//                while (m!=5){
//                    if (m==6){
//                        break;
//                    }
//                    count++;
//                }
//            }
//            t/=10;
//        }
//
//
//    }
}

class Son {
//    class Edge {
//        int src;
//        int nbr;
//
//        public Edge(int src, int nbr) {
//            this.src = src;
//            this.nbr = nbr;
//        }
//    }

    public void make_grapg(ArrayList<ArrayList<Integer>> graph,int v1,int v2){
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <edges.length ; i++) {
            int v1=edges[i][0];
            int v2=edges[i][1];
            make_grapg(graph,v1,v2);
        }
        int ans[]=new int[n];
        boolean visited[]=new boolean[n];
        for (int i = 0; i <n ; i++) {
            ans[i]=dfs(graph,i,visited,0);
            Arrays.fill(visited,false);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        return ans;
    }
    public int dfs(ArrayList<ArrayList<Integer>> graph,int src,boolean visited[],int an){
        visited[src]=true;
        an+=src;
        for (int nbr:graph.get(src)) {
            if (!visited[nbr]){
               return dfs(graph,nbr,visited,an);
            }
        }
        return an;
    }
}