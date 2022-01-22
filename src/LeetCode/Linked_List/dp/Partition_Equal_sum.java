package LeetCode.Linked_List.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Partition_Equal_sum {

        public static boolean canPartition(int[] nums) {
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
            }
            if(sum%2!=0){
                return false;
            }
            sum/=2;

            return subset(nums,nums.length,sum/2);


        }
    public static boolean subset(int nums[],int n,int sum){
        boolean dp[][]=new boolean[n+1][sum+1];
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i <dp[0].length ; i++) {
            dp[0][i]=false;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sum; j++) {
                if(j<nums[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                if(nums[i-1]<=j ){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));

    }
}
class mini_diff_bt_targe_chose_ele{
   static ArrayList<Integer> al=new ArrayList<>();
    public static int minimizeTheDifference(int[][] mat, int target) {
        int n=Integer.MAX_VALUE;
        for(int i=0;i<mat.length;i++){
            int m= min1(mat,target,0,i);
            System.out.println(al.size());
            n=Math.min(n,Math.abs(m-target));

        }
        return n;
    }
    public static int min1(int[][] mat, int tar,int i,int j) {
        if(i>=mat.length || j>=mat[i].length)
            return 0;
        if (i==mat.length-1 ){
            return mat[i][j];
        }
        int sum=0;
        if (sum>tar) return 0;
        for(int c=0;c<mat[i].length;c++){
            int n=mat[i][j]+min1(mat,tar,i+1,c);
            // if(n<=tar){
            sum=n;
            // }
        }
        al.add(sum);
        return sum;
    }

    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 13;
        minimizeTheDifference(mat,target);
    }
}
