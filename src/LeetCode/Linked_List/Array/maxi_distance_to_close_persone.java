package LeetCode.Linked_List.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class maxi_distance_to_close_persone {
     static class posi{
         int p;
        int l,r;

        public posi(int p,int l, int r) {
            this.p=p;
            this.l = l;
            this.r = r;

        }
    }
        public static int maxDistToClosest(int[] seats) {

            int result=0;
            ArrayList<posi> al=new ArrayList<>();
            for(int i=0;i<seats.length;i++){
                if(seats[i]==1) continue;
                else
                distance(seats,i,al);
            }
            for (int i = 0; i < al.size(); i++) {

                if (al.get(i).l==al.get(i).r)
                {
                    if(result<al.get(i).l) result=al.get(i).p;
                }
                else if (al.get(i).l+al.get(i).r==seats.length)
                {
                    if (al.get(i).l<al.get(i).r)
                    {
                        result=al.get(i).p;

                    }
                    else {
                        result =al.get(i).p;
                    }
                }
            }

            for (int i = 0; i < al.size(); i++) {
                System.out.println(al.get(i).l+" "+al.get(i).r);
            }
            return result;
        }
        public static void distance(int a[], int pos, ArrayList<posi> al){

            int ld=0,rd=0;
            for(int i=pos;i>=0;i--){
                if(a[i]!=1){
                    ld++;
                }
                else break;
            }
            for(int i=pos;i<a.length;i++){
                if(a[i]!=1){
                    rd++;
                }
                else break;
            }
            al.add(new posi(pos,ld,rd));
        }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{0,0,0,0,0,0,1}));
        HashSet<Integer> hs=new HashSet<>();
        int a[]={0,1,0,0,2,1,0,2,1,0,0,2,0,2,1};

    }
}
//{1,0,0,0,1,0,1}