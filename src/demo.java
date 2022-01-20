import java.lang.reflect.Array;
import java.util.*;

public class demo {
    public static void main(String[] args) {
//        HashMap<Integer,Integer> hs=new HashMap<>();
//        Collections.sort(new ArrayList<>(),Collections.reverseOrder());
//        HashSet<Integer> hs=new HashSet<>();
//        HashSet<Integer> hs1=new HashSet<>();
//        hs.add(2);
//        hs.add(4);
//        hs.add(1);
//        hs1.add(2);
//        hs1.add(3);
//        System.out.println(hs);
//        System.out.println(hs1);
//        hs.retainAll(hs1);
//        System.out.println(hs);
//        int b[]=new int[3];
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();

        l.add(2);
        l.add(3);
        l.add(4);
        ls.add(l);
        l.add(23);
        l=new ArrayList<>();
        l.add(2);
        ls.add(l);
        l=new ArrayList<>();
        ls.add(l);
        Collections.sort(ls, Comparator.comparingInt(ArrayList::size));
        System.out.println(ls);
    }
}
class Sol {
    public static boolean wordPattern(String pattern, String s) {
        String str[]=s.split(" ");
        if(pattern.length()!=str.length) return false;

        System.out.println(pattern.length()+" "+str.length);
        int i=0,j=str.length-1;
        while(i<j){

            if(pattern.charAt(i)!=pattern.charAt(j) && str[i]!=str[j]){
                return false;
            }
            System.out.println(i+" "+j);
            i++;
            j--;

        }
        return true;
    }

    public static void main(String[] args) {
       String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
}
