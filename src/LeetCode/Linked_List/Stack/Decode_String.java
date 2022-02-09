package LeetCode.Linked_List.Stack;

public class Decode_String {
    public static String decodeString(String s) {
        String str="";
        int n=0;
        int i=0,j=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c=='['){
                n=s.charAt(i-1)-'0';
                String temp="";
                String g="";
                j=i+1;
                while(j<s.length()){
                    if(s.charAt(j)!=']'){
                        g+=s.charAt(j);
                    }
                    else{
                        break;
                    }
                    j++;
                }
                while(n>0){
                    temp=temp+g;
                    n--;
                }
                str+=temp;
                i=j;
            }
            i++;
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
