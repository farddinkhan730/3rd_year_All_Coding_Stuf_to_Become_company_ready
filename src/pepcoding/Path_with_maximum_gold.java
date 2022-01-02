package pepcoding;

public class Path_with_maximum_gold {
        public static int getMaximumGold(int[][] grid,int dp[][]) {

//            for (int i = grid.length-1; i >=0 ; i--) {
//                dp[i][grid[0].length-1]=grid[i][grid[0].length-1];
//            }
                for (int j =grid[0].length-1;j>=0 ;j--) {
                    for (int i = grid.length - 1; i >= 0; i--) {
                        if (j == grid[0].length-1) {
                            dp[i][j] = grid[i][j];
                        }
                        else {
                            int m = 0, n = 0, q = 0;
                            if (i - 1 >= 0 && j + 1 < grid[0].length) {
                                m = dp[i - 1][j + 1];
                            }
                            if (j + 1 < grid[0].length) {
                                n = dp[i][j + 1];
                            }
                            if (i + 1 < grid.length && j + 1 < grid[0].length) {
                                q = dp[i + 1][j + 1];
                            }
                            dp[i][j] = Math.max(q, Math.max(m, n)) + grid[i][j];
                        }
                    }
                }

            int max=0;
            for (int i = 0; i <grid.length ; i++) {
                max=Math.max(dp[i][0],max);
            }
            return max;

        }

    public static void main(String[] args) {
            int grid[][]= {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
            int dp[][]=new int[grid.length][grid[0].length];
        System.out.println(getMaximumGold(grid,dp));
    }
}
