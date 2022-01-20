package LeetCode.Linked_List.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Jump_game_IV {

        public static int minJumps(int[] arr) {
            HashMap<Integer, Queue<Integer>> hs=new HashMap<>();
            for (int i = 0; i <arr.length ; i++) {
                if(hs.containsKey(arr[i])){
                    hs.get(arr[i]).add(i);
                    continue;
                }
                hs.put(arr[i],new LinkedList<>());
            }
            System.out.println(hs);
//            for (int i = 0; i < hs.size(); i++) {
//                System.out.println(arr[i]+" " +hs.get(arr[i]));
//
//            }
            System.out.println(minJumps1(arr,0,hs,0));

            return 0;
        }
    public static int minJumps1(int[] arr,int i,HashMap<Integer,Queue<Integer>> hs,int jump) {
        if (i== arr.length-1) return jump;
        if(i<0 || i>= arr.length) return Integer.MAX_VALUE;

        int a=0,b=0,c=0;
        a=minJumps1(arr,i+1,hs,jump+1);
        b=minJumps1(arr,i-1,hs,jump+1);
        while (hs.get(arr[i]).size()>0){
            c=  minJumps1(arr,hs.get(arr[i]).poll(),hs,jump+1);
        }
        return Math.min(a,Math.min(b,c));

    }


        public static void main(String[] args) {
        minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
    }

}
