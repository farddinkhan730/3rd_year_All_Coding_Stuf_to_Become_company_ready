package LeetCode.Linked_List.dp;

import java.util.Arrays;

public class minimum_cost_homecoming {

        public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

            return minCost1(rowCosts,colCosts,startPos[0],startPos[1],startPos[0],startPos[1],homePos[0],homePos[1],"",new boolean[rowCosts.length][colCosts.length]);
        }
    public static int minCost1(int[] r, int[] c,int ss,int se,int cr,int cc,int er,int ec,String s,boolean b2[][]) {

            if(cr<er){
                if(cr<ss) return 0;

            }
            else if(cr>er)
                if (cr>ss) return 0;

        if(cr>=r.length || cc>=c.length || cr<0 || cc<0 ||b2[cr][cc] ){
            return 0;
        }
        if(cr==er && cc==ec){
            if(s.equals("c")){
                return c[cc];
            }
            if(s.equals("r"))
                return r[cr];
            else return 0;
        }
        b2[cr][cc]=true;

        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c1=Integer.MAX_VALUE,d=Integer.MAX_VALUE;
        a=c[cc]+minCost1(r,c,ss,se,cr,cc+1,er,ec,"c",b2);
        b=r[cr]+minCost1(r,c,ss,se,cr+1,cc,er,ec,"r",b2);
        c1=r[cr]+minCost1(r,c,ss,se,cr-1,cc,er,ec,"r",b2);
        d=c[cc]+minCost1(r,c,ss,se,cr,cc-1,er,ec,"c",b2);

        return Math.min(a,Math.min(b,Math.min(c1,d))) + (s.equals("c")?c[cc]:r[cr]);

    }


    public static void main(String[] args) {
        int []startPos = {1, 0};
        int []homePos = {2, 3};
        int rowCosts []= {5, 4, 3};
        int []colCosts = {8, 2, 6, 7};
        System.out.println(minCost(startPos,homePos,rowCosts,colCosts));
       String s="";
       char c[]={'d','c'};

    }
}
