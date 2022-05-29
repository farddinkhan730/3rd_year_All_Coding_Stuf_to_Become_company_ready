import java.util.*;

//public class LFU {
//    public static void main(String[] args) {
//        HashMap<Integer,Integer> hm=new HashMap<>();
////        ArrayList<Integer> hm=new ArrayList<>(2);
//        hm.put(1,2);
//        hm.put(7,4);
//        hm.put(5,6);
////        hm.add(2);
////        hm.add(4);
////        hm.add(6);
//        System.out.println(hm);
//        System.out.println(hm.size());
//    }
//}
//class LFUCache {
//    HashMap<Integer,Integer> hm;
//    public LFUCache(int capacity) {
//        hm=new HashMap<>(capacity);
//    }
//
//    public int get(int key) {
//
//        return key;
//    }
//
//    public void put(int key, int value) {
//
//    }
//}
//
//
//class AllOne {
//
////    class pair implements Comparable<pair>{
////        String str;
////        int count;
////
////        public pair(String str, int count) {
////            this.str = str;
////            this.count = count;
////        }
////
////        @Override
////        public int compareTo(pair o) {
////            return o.count-this.count;
////        }
////    }
//    ArrayList<String> al;
//    ArrayList<Integer> cnt;
//    int min,max;
//    public AllOne() {
//        al=new ArrayList<>();
//        cnt=new ArrayList<>();
//        min=0;
//        max=0;
//    }
//
//    public void inc(String key) {
//        if (al.contains(key)){
//            int idx=al.indexOf(key);
//            int val=cnt.remove(idx);
//            val++;
//            cnt.add(idx,val);
//            min=Math.min(min,val);
//        }
//        else {
//            al.add(key);
//            cnt.add(1);
//
//        }
//    }
//
//    public void dec(String key) {
//        key.in
//    }
//
//    public String getMaxKey() {
//
//    }
//
//    public String getMinKey() {
//
//    }
//}

class MedianFinder {

    PriorityQueue<Integer> pq=new PriorityQueue<>();
    ArrayList<Integer> al;
    public MedianFinder() {
        al=new ArrayList<>();
    }

    public void addNum(int num) {
        al.add(num);
    }

    public double findMedian() {
        if(al.isEmpty()){
            return 0.0;
        }
        if(al.size()%2==0){
            int a=al.get(al.size()/2);
            int b=al.get(al.size()/2-1);
            double d=(a+b)/2;
            return d;
        }
        return al.get(al.size()/2);
    }
}
class Sn {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<Set<Integer>> al=new ArrayList<>();

        al.add(new HashSet<>());

        for(int i=0;i<nums.length;i++){
            List<Set<Integer>> l1=new ArrayList<>();
            for(Set<Integer> l:al){
                Set<Integer> nw=new HashSet<>(l);
                nw.add(nums[i]);
                l1.add(nw);
            }
            for(Set<Integer> l:l1){
                al.add(l);
            }
        }
        List<List<Integer>>ql=new ArrayList<>();
        for (int i = 0; i <al.size() ; i++) {
            ql.add(new ArrayList<>(al.get(i)));
        }
        return ql;

    }
    public static List<String> letterCasePermutation(String s) {
        List<String> st=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            int j=0;
            String temp=s;
            while(j<temp.length()){
                if((temp.charAt(j)>='A') && (temp.charAt(j)<='Z')){
                    temp=temp.replace(temp.charAt(j),Character.toLowerCase(temp.charAt(j)));
                }
                else if(temp.charAt(j)>='a'&& temp.charAt(j)<='z' ){
                    temp=temp.replace(temp.charAt(j),Character.toUpperCase(temp.charAt(j)));
                }
                if (!st.contains(temp)){
                    st.add(temp);
                    break;
                }
                j++;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }
}