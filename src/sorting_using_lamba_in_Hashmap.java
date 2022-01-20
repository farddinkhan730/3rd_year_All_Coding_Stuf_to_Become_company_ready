import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class sorting_using_lamba_in_Hashmap {
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k==1 && nums.length==1){
            return new int[]{nums[0]};
        }
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hs=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(nums[i])){
                hs.put(nums[i],hs.get(nums[i])+1);
            }
            else{
                hs.put(nums[i],1);
                al.add(nums[i]);
            }
        }
        // for(int l:hs.values()){
        //      if(!al.contains(l))al.add(l);
        // }
        Collections.sort(al,(a, b)->(hs.get(a)!=hs.get(b))?hs.get(b)-hs.get(a):b-a);

        int a[]=new int[k];
        // int i=0;
        // System.out.println(hs);
        // System.out.println(al);
        // for (Map.Entry<Integer,Integer> e:hs.entrySet()){
        // int ke=e.getKey();
        // int v=e.getValue();
        // if((k)==0){
        // break;
        // }
        // if(v==al.get(i)){
        for(int i=0;i<k;i++){
            a[i]=al.get(i);

        }

        return a;
    }
}