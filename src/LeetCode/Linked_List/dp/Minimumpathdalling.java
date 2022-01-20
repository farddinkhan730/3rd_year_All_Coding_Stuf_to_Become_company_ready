package LeetCode.Linked_List.dp;

import java.util.Arrays;

public class Minimumpathdalling {

        public static int minFallingPathSum(int[][] matrix) {
            int res=Integer.MAX_VALUE;
            int dp[][]=new int[matrix.length][matrix[0].length];
            for (int i = 0; i <matrix.length ; i++) {
                Arrays.fill(dp[i],-1);
            }
            for(int i=0;i<matrix[0].length;i++) {
               int  res1 = minFallingPathSum1(matrix, 0, i, matrix.length, matrix[0].length, 0,dp);
                if(res>res1) res=res1;
            }
            return res;
        }
        public static int minFallingPathSum1(int[][] matrix
                ,int cr,int cc,int r,int c,int psf,int dp[][]) {
            if( cc>=c || cc<0){
                return Integer.MAX_VALUE;
            }


            if (dp[cr][cc]>-1) return dp[cr][cc];
            psf+=matrix[cr][cc];
            if(cr==r-1){
                return psf;
            }


            int a=minFallingPathSum1(matrix,cr+1,cc-1,r,c,psf,dp);
            int b=minFallingPathSum1(matrix,cr+1,cc,r,c,psf,dp);
            int c1=minFallingPathSum1(matrix,cr+1,cc+1,r,c,psf,dp);
            return dp[cr][cc]=Math.min(a,Math.min(b,c1));
        }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}

class Solution {
    public static int minFallingPathSum(int[][] grid) {
        int path=0;
        for (int i = 0; i <grid[0].length ; i++) {
            path=minFallingPathSum1(grid,0,i);

        }
        return path;
    }
    static int path=0;
    public  static int minFallingPathSum1(int[][] grid,int cr,int cc) {
        if(cr==grid.length-1){
            path++;
            return grid[cr][cc];
        }
        int ans=Integer.MAX_VALUE;
        for(int c=0;c<grid.length;c++){
            if(c!=cc)
                ans=Math.min(ans, minFallingPathSum1(grid,cr+1,c));
        }
        return path+(ans!=Integer.MAX_VALUE?1:0);
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}