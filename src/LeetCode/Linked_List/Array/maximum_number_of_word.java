package LeetCode.Linked_List.Array;

import java.util.ArrayList;
import java.util.List;

public class maximum_number_of_word
{
    public int mostWordsFound(String[] sentences) {
        int count=0;

        for (String s:sentences) {
            count=Math.max(count,s.split(" ").length);
        }
        for(int i=0;i<sentences.length;i++){
            String[] s=sentences[i].split(" ");

//            int len=0;
//            for (String str:s) {
//                len+=str.length();
//            }
            count=Math.max(count,s.length);
        }
        return count;

    }
    public static void main(String[] args) {

    }
}
class kids{
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        List<Boolean> ls=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                ls.add(true);

            }
            else{
                ls.add(false);
            }
        }
        System.out.println(ls);
        return ls;
    }

    public static void main(String[] args) {
        kidsWithCandies(new int[]{2,3,5,1,3},3);
    }
}
