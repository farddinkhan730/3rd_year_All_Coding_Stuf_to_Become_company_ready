package LeetCode.Linked_List.dp;

import java.util.Arrays;

public class Subsequence {

        public boolean isSubsequence(String s, String t) {
            if(s.length()<=0 || t.length()<=0){
                return false;
            }
            if(s.length()>t.length()){
                return false;
            }

            int dp[]=new int[256];


            return false;
        }
        public static boolean isSubsequence1(String s, String t,boolean dp[],int cidx,int cidx1) {
            int i=0,j=0;
            int temp=0;
            boolean result=false;
            boolean check[]=new boolean[t.length()];
            Arrays.fill(check,false);
           while(i<s.length()){
            boolean b=false;
                   result=false;
               while (j<t.length()){
                   if( i<s.length() && s.charAt(i)==t.charAt(j) && !check[j]){
                       b=true;
                       temp=j;
                       check[j]=true;
                       result=true;

                       i++;
                   }
                   j++;
               }
               if(!b){
                   break;
               }
               b=false;
               j=temp;
           }

            return result;
        }

    public static void main(String[] args) {
        System.out.println( isSubsequence1("b","abc",new boolean[3],0,0));
    }

}
