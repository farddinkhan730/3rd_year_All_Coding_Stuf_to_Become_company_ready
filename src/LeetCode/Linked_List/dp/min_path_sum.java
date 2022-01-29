package LeetCode.Linked_List.dp;

public class min_path_sum {

        public static int minPathSum(int[][] g) {

            return minPathSum1(g,0,0,g.length);


        }
        public static int minPathSum1(int[][] g,int i,int j,int n) {

            if(i==n-1 && j==n-1) return g[i][j];
            if(i>=n || j>=n){
                return 0;
            }


            int a=g[i][j]+minPathSum1(g,i,j+1,n);
            int b=g[i][j]+minPathSum1(g,i+1,j,n);
            System.out.println(a+" "+ b);
            return Math.min(a,b);
        }

    public static void main(String[] args) {
        int a[][]={{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(minPathSum(a));
        String s="wra";
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        System.out.println(str);
        int n=22,b=7,result;
        result=n*b/b;
        System.out.println(result);
        }
}
