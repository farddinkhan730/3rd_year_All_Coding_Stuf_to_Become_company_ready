package LeetCode.Linked_List.Stack;

import java.util.Stack;

public class Remove_ALL_ADJACENT_DUPLICATE {
    class pair{
        char s;
        int count;

        public pair(char s, int count) {
            this.s = s;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {

        Stack<pair> st=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {

            if(!st.isEmpty() && s.charAt(i)==st.peek().s && st.peek().count==k){
                st.pop();
            }
            else if(!st.isEmpty() && s.charAt(i)==st.peek().s){
                st.peek().count++;
            }
            else {
                st.push(new pair(s.charAt(i),1));
            }

        }
        String str="";
        while (!st.isEmpty()){
            str=st.pop()+str;
           
        }

        return str;
        // int n=0;
//        HashMap<Character,Integer> hm=new HashMap<>();
//
//        for(int i=0;i<s.length();i++){
//
//            if(hm.containsKey(s.charAt(i))){
//                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
//            }
//            else{
//
//                hm.put(s.charAt(i),1);
//            }
//        }
//        System.out.println(hm);
//        String sr="";
//        boolean b=false;
//        if(k%2==0) b=true;
//        for (Map.Entry<Character,Integer> en:hm.entrySet()){
//            int tp=en.getValue();
//            if(tp!=k){
//                if(b && tp%2==00){
//                    continue;
//
//                }
//                else
//                    while(tp>0){
//                        sr+=en.getKey();
//                        tp--;
//                    }
//            }
//
//        }
//        return sr;
    }
}
