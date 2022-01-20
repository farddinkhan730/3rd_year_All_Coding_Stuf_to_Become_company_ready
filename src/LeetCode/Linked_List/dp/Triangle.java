package LeetCode.Linked_List.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triangle {

        public static int minimumTotal(List<List<Integer>> triangle) {
            return minimumTotal1(triangle,0,0);
        }
        public static int minimumTotal1(List<List<Integer>> triangle,int cr,int cc) {

            if(cr==triangle.size()-1){
                return triangle.get(cr).get(cc);
            }

            int ans=Integer.MAX_VALUE;

            return ans;
        }

    public static void main(String[] args) {
        List<List<Integer>> t=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> ls=new ArrayList<>();
            ls.add(-1);
            t.add(ls);
            ls=new ArrayList<>();
            ls.add(2);
            ls.add(3);
            t.add(ls);
        ls=new ArrayList<>();
        ls.add(1);
        ls.add(-1);
        ls.add(-3);
        t.add(ls);

        System.out.println(minimumTotal(t));
        String s="";

    }

}
