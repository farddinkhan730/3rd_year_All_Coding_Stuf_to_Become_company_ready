package LeetCode.Linked_List.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class coin_change {
    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int dp[]=new int[amount+1];
        // Arrays.fill(dp,-1);
//        dp[0]=1;
        int prev=0;
        Arrays.sort(coins);
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<dp.length;j++){
                prev = dp[j - coins[i]];
                if(j == coins[i])
                    dp[j] = 1;
                else if(dp[j] == 0 && prev > 0)
                    dp[j] = prev + 1;
                else if(dp[j] > 0 && prev > 0)
                    dp[j] = Math.min(dp[j],prev + 1);
            }
        }
        return dp[amount];
        // ==0?-1:dp[amount];
    }

    public static void main(String[] args) {
         int c[]={1,2,5};
        System.out.println(coinChange(c,11));
    }

}
class N_queen{
    static int count=0;
    public static void queen(int n,int q[][],int cr){

        if(cr==n){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    if(q[i][j]==1){
                        System.out.println("Q");
                    }
                    else {
                        System.out.println("_");
                    }
                }
            }
            count++;
            return ;
        }
        for (int i = 0; i < n; i++) {
            if(kyaqueenrkhu(q,cr,i,n)){
                q[cr][i]=1;
                queen(n,q,cr+1);
                q[cr][i]=0;
            }
        }
    }
public static boolean kyaqueenrkhu(int board[][],int cr,int cc,int n){

    for (int row = 0; row <=cr-1 ; row++) {
        if(board[row][cc]==1){
            return false;
        }
    }
    int row=cr;
    int col=cc;

    while (row>=0 && col>=0){
        if(board[row][col]==1){
            return false;
        }
        row--;
        col--;
    }
    row=cr;
    col=cc;

    while (row>=0 && col<n){
        if(board[row][col]==1){
            return false;
        }
        row--;
        col++;
    }
    return true;
}
    public static void main(String[] args) {
        int n=4;
        int q[][]=new int[n][n];
        queen(n,q,0);
        System.out.println(count);
    }
}
 class NQueen {

    static int count;
    private static boolean kyaQueenRakhun(int[][] board, int cr, int cc, int n) {
        // TODO Auto-generated method stub

        for(int row = 0; row <= cr - 1; row++) {
            if(board[row][cc] == 1) {
                return false;
            }
        }

        int row = cr;
        int col = cc;

        while(row >= 0 && col >= 0) {
            if(board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = cr;
        col = cc;

        while(row >= 0 && col < n) {
            if(board[row][col] == 1) {
                return false;
            }

            row--;
            col++;
        }

        return true;
    }
    private static void queenComb(int[][] board, int cr, int n) {
        // TODO Auto-generated method stub

        if(cr == n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 1) {
                        System.out.print("Q ");
                    } else {
                        System.out.print("_ ");
                    }
                }

                System.out.println();
            }

            System.out.println("************************");
            count++;
            return;
        }

        for(int cc = 0; cc < n; cc++) {
            if(kyaQueenRakhun(board, cr, cc, n)) {
                board[cr][cc] = 1;
                queenComb(board, cr + 1, n);
                board[cr][cc] = 0;
            }
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n = 4;
        int[][] board = new int[n][n];
        queenComb(board, 0, n);
        System.out.println(count);
    }

}
