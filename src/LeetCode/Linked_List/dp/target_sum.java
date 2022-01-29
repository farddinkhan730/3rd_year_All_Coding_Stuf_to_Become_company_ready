package LeetCode.Linked_List.dp;

import java.util.Arrays;

public class target_sum {
    public static int findTargetSumWays(int[] nums, int target) {
        int dp[]=new int[nums.length+1];
//        for (int i[]:dp
//             ) {
            Arrays.fill(dp,Integer.MAX_VALUE);
//        }
        return findTargetSumWays1(nums,target,0,0,dp);
    }
    public static int findTargetSumWays1(int[] nums, int t,int i,int s,int dp[]) {
        
        if(s==t){
            return 1;
        }
        if(i>=nums.length){
            return 0;
        }
//        if (dp[i]!=Integer.MAX_VALUE) return dp[i];

        int inc=findTargetSumWays1(nums,t,i+1,s-nums[i],dp);
        int inc1=findTargetSumWays1(nums,t,i+1,s+nums[i],dp);

        return inc+inc1;
    }

    public static void main(String[] args) {

        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
