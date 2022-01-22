package LeetCode.Linked_List.dp;

public class subsetsum {
    public static void subset(int nums[],int n,int sum){
        boolean dp[][]=new boolean[n+1][sum+1];
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i <dp[0].length ; i++) {
            dp[0][i]=false;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sum; j++) {
                if(nums[i-1]<=j ){
                    dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.println(dp[i][j]);
            }
        }

    }
    public static void main(String[] args) {
//        subset(new int[]{1,1,2,2,3,4,5,5,6,7},10,1);

        subset(new int[]{3,34,4,12,5,2},6,30);
    }
}
