import java.util.Arrays;
import java.util.Scanner;

public class N_Queen {
    static int count;
    public static boolean is_place(int board[][],int cr,int cc,int n){
        for (int i = 0; i<=cr-1 ; i++) {
            if(board[i][cc]==1){
                return false;
            }
        }

        int x=cr,y=cc;
        while (x>=0 && y<n){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y++;
        }
        x=cr;
        y=cc;
        while (x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y--;
        }
        return true;

    }
    public static  void  place_Queen(int board[][],int i,int n){
        if(i==n){
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if(is_place(board,i,j,n)){
                board[i][j]=1;
                place_Queen(board,i+1,n);
                board[i][j]=0;
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int board[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                board[i][j]=0;
            }
        }
        place_Queen(board,0,n);
        System.out.println(count);

    }
}
class replace_with_pi{
    public static void replace(String str,String out){
        if(str.length()==0){
            System.out.println(out);
            return;
        }
        if(str.charAt(0)=='p' && str.charAt(1)=='i'){
            str=str.substring(2);
            str="3.14"+str;
        }
        replace(str.substring(1),out+str.charAt(0));

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n-->0){
            String s=sc.next();
            replace(s,"");
        }
    }
}
class Tower_of_honoi{
    private  static  void  toh(int n,char src,char dest,char helper){

        if(n == 1) {
            System.out.println("Move " + n + "th disk from " + src + " to " + dest);
            return;
        }
        toh(n - 1, src, dest, helper);
        System.out.println("Move " + n + "th disk from " + src + " to " + dest);
        toh(n - 1, helper, src, dest);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        toh(sc.nextInt(),'A','B','C');
    }
}
class  mm{
    public static void main(String[] args) {

    }
}