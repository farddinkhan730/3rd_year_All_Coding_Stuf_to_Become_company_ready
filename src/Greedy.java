import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy {

}

class Knapsack{
    static class sort{
        int profit;
        int weight;
        float ratio;
        sort(int profit,int weight,float ratio){
            this.profit=profit;
            this.weight=weight;
            this.ratio=ratio;
        }
    }
    public static   void insertion_sort(sort a[],int n){
        for (int i = 0; i <n ; i++) {
            sort temp=a[i];
            int j=i;
            while (j>0 && temp.ratio>a[j-1].ratio){
                a[j]=a[j-1];
                j=j-1;
            }
            a[j]=temp;
        }
    }
    public static void main(String[] args) {
        int m=50;
        float pr=0;
        int p[]= { 60, 40, 100, 120 };
        int w[]= { 10, 40, 20, 30 };
        sort p_w[]=new sort[p.length];
        for (int i = 0; i <p.length ; i++) {
            float ra=(float)p[i]/(float) w[i];
            p_w[i]=new sort(p[i],w[i],ra);
        }
        insertion_sort(p_w, p_w.length);

        for (int i = 0; i < p_w.length ; i++) {
            if(m>0 && p_w[i].weight<=m){
                m=m-p_w[i].weight;
                pr+=p_w[i].profit;
            }
            else if(m>0 && m-p_w[i].weight<=0){
                float remaning_weight_price=(float)m*p_w[i].ratio;

                m-=remaning_weight_price/p_w[i].ratio;

                pr+=remaning_weight_price;
            }
            else break;
        }
        System.out.println("Profit "+ pr);
    }
}
class  activity_selection{
    static class  combin{
        String s;
        int st;
        int ed;
        combin(String s,int st,int ed){
            this.s=s;
            this.st=st;
            this.ed=ed;
        }
        combin(){

        }
    }
    public static void main(String[] args) {
        String acti[]={"A1","A2","A3"};
        int st[]=      {12,10,20};
        int end[]=     {25,20,30};
        combin []a=new combin[acti.length];

        for (int i = 0; i <st.length ; i++) {
            a[i]=new combin(acti[i],st[i],end[i] );
        }
        Arrays.sort(a, new Comparator<combin>() {
            @Override
            public int compare(combin o1, combin o2) {
                return o1.ed-o2.ed;
            }
        });
        System.out.println(a[0].s);
        int j=0;
        for (int i = 1; i <a.length ; i++) {
//            System.out.println(a[i].s+" "+ " "+a[i].st+" "+" "+a[i].ed);
            if(a[j].ed<=a[i].st){
                j=i;
                System.out.println(a[i].s);
            }
        }
    }
}
class lcs{
    static int lcs(String s,String s1,int currs,int currs1,int dp[][]){
        if(currs==s.length() || currs1==s1.length()){
            return 0;
        }

        if(dp[currs][currs1] != -1) {
            return dp[currs][currs1];
        }
        if(s.charAt(currs) == s1.charAt(currs1)) {
            return dp[currs][currs1] =  lcs(s, s1, currs + 1, currs1 + 1, dp) + 1;
        }
//        else {
            int c1=lcs(s,s1,currs+1,currs1,dp);
            int c2=lcs(s,s1,currs,currs1+1,dp);
//        }
            return dp[currs][currs1]=Math.max(c1,c2);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        int dp[][]=new int[str1.length()][str2.length()];
        for (int i = 0; i <str1.length() ; i++) {
            for (int j = 0; j <str2.length() ; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(lcs(str1,str2,0,0,dp));
    }
}

class l1cs{
    static int lcs(String s,String s1,int currs,int currs1,int dp[][]){
        if(currs==s.length() || currs1==s1.length()){
            return 0;
        }

        if(dp[currs][currs1] != -1) {
            return dp[currs][currs1];
        }
        if(s.charAt(currs) == s1.charAt(currs1)) {
            return dp[currs][currs1] =  lcs(s, s1, currs + 1, currs1 + 1, dp) + 1;
        }
//        else {
        int c1=lcs(s,s1,currs+1,currs1,dp);
        int c2=lcs(s,s1,currs,currs1+1,dp);
//        }
        return dp[currs][currs1]=Math.max(c1,c2);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        int dp[][]=new int[str1.length()][str2.length()];
        for (int i = 0; i <str1.length() ; i++) {
            for (int j = 0; j <str2.length() ; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(lcs(str1,str2,0,0,dp));
    }
}
// dynamic programming
class FG{

    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    static int knapSackRec(int W, int wt[],
                           int val[], int n,
                           int [][]dp)
    {

        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W) {

            return dp[n][W] = knapSackRec(W, wt, val,
                    n - 1, dp);
        }

        else {

            return dp[n][W] = max((val[n - 1] +
                            knapSackRec(W - wt[n - 1], wt,
                                    val, n - 1, dp)),
                    knapSackRec(W, wt, val,
                            n - 1, dp));
        }
    }



    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int val[] =new int[n];
        int wt[] = new int[n];

        for (int i = 0; i < n; i++) {
            val[i]=sc.nextInt();
            wt[i]=sc.nextInt();
        }
//        for (int i = 0; i < n; i++) {
//        }
        int W = 50;
        int N = val.length;
        int dp[][] = new int[N + 1][W + 1];

        for(int i = 0; i < N + 1; i++)
            for(int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        System.out.println(knapSackRec(W, wt, val, N, dp));
    }
}



