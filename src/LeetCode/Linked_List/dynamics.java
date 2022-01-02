package LeetCode.Linked_List;

import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class dynamics {

    public static int[] countBits(int n) {
       int arr[]=new int[n];
        for (int i = 0; i <n ; i++) {
        arr[i]=Integer.bitCount(i);

        }
        return arr;
    }
public static void main(String[] args) {
    int n=2;
    int a[]=countBits(n);
    for (int i = 0; i <a.length ; i++) {
        System.out.println(a[i]);
    }
}
}

class fibnoccci{
    public static int fib(int n){
        if(n==0 || n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
//    public static int fib1(int n,int crr,int dp[]){
//        if(n==0 || n==1){
//            return 1;
//        }
//        return dp[n]=fib(n-1)+fib(n-2);
//        if(dp[n]>-1){
//            return dp[n];
//        }
//    }
    public static void main(String[] args) {
        int n=2;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
//        fib1(n,dp);
        System.out.println(fib(n));
    }
}