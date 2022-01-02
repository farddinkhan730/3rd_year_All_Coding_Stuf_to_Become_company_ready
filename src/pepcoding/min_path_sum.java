package pepcoding;

public class min_path_sum {
//    public int minPathSum(int[][] grid) {
//
////        return minPathSum1(grid,0,0,grid.length,0);
//
//    }
    public static int minPathSum1(int[][] grid,int cr,int cc,int row,int col,int sum,int dp[][]) {
        if(cc>=col || cr>=row){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc]!=0){

            return dp[cr][cc];
        }
        sum+=grid[cr][cc];
        dp[cr][cc]=sum;
                if(dp[cr][cc]==0 && cr==row-1 && cc==col-1){
                    return sum;
                }
//        if(dp[cr][cc]==0 && cr==row-1 && cc==col-1){
//            return dp[cr][cc]=sum;
//        }

        int lm=minPathSum1(grid,cr,cc+1,row,col,sum,dp);
        int rm=minPathSum1(grid,cr+1,cc,row,col,sum,dp);

        return Math.min(lm,rm);
    }
    public static int minPathSum2(int[][] grid,int cr,int cc,int row,int col,int sum,int dp[][]) {

        for (int i = dp.length-1; i >=0 ; i--) {
            for (int j = dp[0].length-1; j >=0 ; j--) {
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=grid[i][j];
                }
                else if(i==dp.length-1 ){
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }
                else if(j==dp[0].length-1){
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }
                else {
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int g[][]={{1,2},{1,1}};
        int dp[][]=new int[g.length][g[0].length];
        System.out.println(
                minPathSum2(g,0,0,g.length,g[0].length,0,dp)
    );
    }
}
