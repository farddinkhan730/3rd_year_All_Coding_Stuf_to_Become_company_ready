package LeetCode.Linked_List.Stack;

import java.util.*;

public class simply_fy {
    public static int numDifferentIntegers(String word) {
        char c[]=word.toCharArray();
        String s="";
        boolean b=false;
        int i=0;
        if(word.charAt(0)=='0')i++;
        while (i <c.length) {
            int j=i;
            while (j<c.length && c[j]-'0'>=0 && c[j]-'0'<=9)
            {
                if(c[j]=='0' && s.charAt(s.length()-1)==' '){
                    j++;
                    continue;
                }
                s+=c[j];
                b=true;
                j++;
            }
            if (b){
                s+=" ";
                i=j;
                b=false;
            }
            else
            i++;

        }
        Set<String> st=new HashSet();
        for(String k:s.split(" ")){
            st.add(k);
        }
        return st.size();
    }
    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("110sdasd12121cxzc12dscx00010vcv10"));
    }
}