package LeetCode.Linked_List.Array;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hs=new HashMap<>();
        List<List<String>> al=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char st[]=s.toCharArray();
            Arrays.sort(st);
            String str=new String(st);
            if(hs.containsKey(str)){

                hs.get(str).add(s);
            }
            else{
                List<String> ls=new ArrayList<>();
                ls.add(s);
                hs.put(str,ls);
            }
        }
        for (Map.Entry<String,List<String>> e:hs.entrySet()) {
            al.add(e.getValue());
        }
        return al;
    }
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
       String b[]=Arrays.copyOfRange(strs,0,3);
    }
}
class exam{
    public void method(){
        System.out.println("My MEthod");
    }
}
class bird extends exam{
    @Override
    public void method() {
        System.out.println("asf");
    }
}
class dog extends bird{
    @Override
    public void method() {
        System.out.println("ads");
    }
}

class drived{
    public static void main(String[] args) {
        drived obj=new drived();
        exam oj1=new bird();
        exam ob=new dog();
    }
}

class concatinstion{
    public static void main(String[] args) {
        String s="1,2,8,4,5,1,2,3,8,9,2";
        s=s.replace(",","");
        int n1=s.indexOf('5');
        int n2=s.lastIndexOf('8');
        String s1="";
        for (int i = n1; i <=n2 ; i++) {
            s1+=s.charAt(i);
        }
        int n=0;
        for (int i = 0; i < s.length(); i++) {
            if(i>=n1 && i<=n2){
                continue;
            }
            n=n+Integer.parseInt(s.substring(i,i+1));
        }
        System.out.println(n+Integer.parseInt(s1));
    }
}
class generateOTP{
    public static void main(String[] args) {
//        String s="13456";
//        String s1="";
//        for (String i:s.split("")) {
//            int n=Integer.parseInt(i);
//            if(n%2==0){
//                continue;
//            }
//            else {
//                s1+=n*n;
//            }
//        }
//        System.out.println(s1.substring(0,5));
        Stack<Integer> sta=new Stack<>();
        sta.push(50);
        sta.push(40);
        sta.push(30);
        sta.push(20);
        sta.push(10);
        System.out.println(sta);
        for (int i = sta.size()-1;i>=0 ; i--) {
            int m=sta.get(i);
           sta.removeElementAt(i);
            sta.push(m);

        }
        System.out.println(sta);
    }
}