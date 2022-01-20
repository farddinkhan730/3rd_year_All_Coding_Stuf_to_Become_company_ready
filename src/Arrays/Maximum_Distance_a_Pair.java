package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;

public class Maximum_Distance_a_Pair {
    static class Pair{
        int v;
        int count;

        public Pair(int v, int count) {
            this.v = v;
            this.count = count;
        }
    }
    public static int[] frequencySort(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        Pair a[] = new Pair[max + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Pair(0, 0);
        }

        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = new Pair(nums[i], a[nums[i]].count + 1);
        }
        Arrays.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count - o1.count;
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].v + " " + a[i].count);
        }

        int i = 0;

        for (int j = 0; j < a[i].count; j++) {
            while (i<a[j].count) {
                nums[i] = a[j].v;
                i++;
            }
        }


        for (i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return new int[4];

    }
    public static int maxDistance(int[] nums1, int[] nums2) {
        int mxdst=0;
      int i=0;
            while(i<nums1.length){
                int j=i;
                int e=nums2.length;
                while (j<e){
                    int mid=j+(e-j)/2;

                    if(nums2[mid]>=nums1[i]){
                        mxdst=Math.max(mxdst,mid-i);
                    }
                    else e=mid-1;
                }
                i++;
        }
        return mxdst;
    }
    public static void main(String[] args) {
        int n[]={1,1,2,3,2,2};
        int n1[]={55,30,5,4,2};
//        maxDistance(n,n1);
        frequencySort(n);
    }
}
