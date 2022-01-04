package Graph;

import java.util.ArrayList;

public class reorder_routes {
    public static int minReorder(int n, int[][] connections) {
//        int count=0;
//        for (int i = 0; i <connections.length ; i++) {
//            for (int j = 0; j <connections[i].length-1 ; j++) {
//                if(connections[i][j]<connections[i][j+1]){
//                    count++;
//                }
//            }
//        }
//        return count;
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for (int i = 0; i <connections.length ; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i <connections.length ; i++) {
            al.get(connections[i][0]).add(connections[i][1]);
        }
//        for (int i = 0; i <al.size() ; i++) {
//            for (int j = 0; j <al.get(i).size() ; j++) {
//                System.out.println(i+" "+al.get(i).get(j));
//            }
//        }
    return 0;

    }

    public static void main(String[] args) {
        System.out.println(minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
}
