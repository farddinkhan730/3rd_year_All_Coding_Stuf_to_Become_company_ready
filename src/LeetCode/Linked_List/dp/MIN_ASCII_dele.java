package LeetCode.Linked_List.dp;

import java.util.Arrays;

public class MIN_ASCII_dele {
        int sum=0;
        public static int minimumDeleteSum(String text1, String text2) {
            int dp[][]=new int[text1.length()][text2.length()];
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],-1);
            }

            return lcs(text1,text2,0,0,dp);

        }
        public static int lcs(String s1, String s2,int i,int j,int dp[][]) {
            if(s1.length()<=i || s2.length()<=j){
                return 0;
            }
            if(dp[i][j]!=-1) return dp[i][j];
            int ans=0;
            if(s1.charAt(i)==s2.charAt(j)){
                int a=1+lcs(s1,s2,i+1,j+1,dp);
                ans=Math.max(ans,a);
            }
            else{
                int fc=lcs(s1,s2,i+1,j,dp);
                int rc=lcs(s1,s2,i,j+1,dp);
                ans=Math.max(fc,rc);
            }
            return dp[i][j]=ans;
        }

    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        System.out.println(minimumDeleteSum(s1,s2));
    }
}
