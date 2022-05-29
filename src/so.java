import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// * Definition for a binary tree node.
public class so {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        return buildbst(1,n);
    }
    public List<TreeNode>  buildbst(int s,int e){
        if(s>e){
            List<TreeNode> ls=new ArrayList<>();
            ls.add(null);
            return ls;
        }
        List<TreeNode> ans=new ArrayList<>();
        for(int i=s;i<=e;i++){
            List<TreeNode> left=buildbst(s,i-1);
            List<TreeNode> right=buildbst(i+1,e);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        so obj=new so();
        System.out.println(obj.generateTrees(3));
    }
}

class Stt {
    public String decodeString(String s) {

        Stack<Character> st=new Stack<>();

        String s1="";
        int i=0;
        String str="";
        while (i<s.length()){

            if(s.charAt(i)>='1' || s.charAt(i)=='[' || s.charAt(i)>='a' ){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==']'){
                String temp="";
                while (!st.isEmpty()){
                    if (st.peek()>='a')
                    temp=st.pop()+temp;
                    else if (st.peek()=='['){
                        st.pop();
                    }
                    else {
                        int n=st.pop()-'0';
                        while (n-->1){
                            temp+=temp;
                        }
                    }
                }
                str+=temp;
            }
            i++;
        }


        return str;
    }
}
class Soion {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls=new ArrayList<>();
        int n=matrix.length,m=matrix[0].length;
        boolean b[][]=new boolean[n][m];

        so(matrix,0,0,ls,b);
        return ls;
    }
    public void so(int[][] m,int i,int j,List<Integer> ls,boolean b[][]) {
        // if(j>=m[0].length ||j<0 || i<0 || i>=m.length || b[i][j] ){
        //     return ;
        // }

        ls.add(m[i][j]);

        b[i][j]=true;
        if(j+1<m[0].length && b[i][j+1] == false) {
            so(m,i,j+1,ls,b);
        } else if(i+1<m.length && b[i+1][j] == false) {
//            b[i][j]=true;
            so(m,i+1,j,ls,b);
        } else if(j-1>=0 && b[i][j-1] == false) {
//            b[i][j]=true;
            so(m,i,j-1,ls,b);

        } else if(i-1>=0 && b[i-1][j] == false) {
//            b[i][j]=true;
            so(m,i-1,j,ls,b);
        }



    }

    public static void main(String[] args) {
        Soion obj=new Soion();
        obj.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }
}
class vn {
    public int scoreOfParentheses(String s) {
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(char c:s.toCharArray()){
            int as=0;
            while(!st.isEmpty() && Character.isDigit(st.peek())){
                as+=st.pop()-'0';
            }
            if(!st.isEmpty() && c==')' && st.peek()=='('){
                st.pop();
                if(as!=0){
                    st.push((2*as+"").charAt(0));
                }
                else{
                    st.push('1');
                }
            }
            else if(c=='('){
                st.push(c);
            }
        }
        while(!st.isEmpty()){

            ans+=st.pop()-'0';
        }
        return ans;
    }

    public static void main(String[] args) {
        vn obj=new vn();
        System.out.println(obj.scoreOfParentheses("()()"));
    }
}
class xon {
    public int scoreOfParentheses(String s) {
        Stack<String> st=new Stack<>();
        int ans=0;
        for(char c:s.toCharArray()){
            int an=0;
            boolean b=false;
            if(!st.isEmpty() && (c+"").equals(")")){
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    b=true;
                    an+=(Integer.parseInt(st.pop()));
                }
                if(!st.isEmpty() && b && st.peek().equals("(")){
                    st.pop();
                    an*=2;
                    st.push((an+""));
                }
                else if(!st.isEmpty() && st.peek().equals("(")){
                    // else{
                    st.pop();
                    st.push("1");
                }
            }
            else if((c+"").equals("(")){
                st.push(c+"");
            }
        }
        while(!st.isEmpty()){
            System.out.println(st.peek());
            ans+=(Integer.parseInt(st.pop()));
        }
        return ans;
    }

    public static void main(String[] args) {
        xon obj=new xon();
        obj.scoreOfParentheses("(()(()()))");
    }
}

class Stion {
    public int calculate(String s) {

        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i)==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    int n=st.pop()-0;
                    if(st.peek()=='+' && st.size()>=3){
                        st.pop();
                        int k=n+(st.pop()-0);
                        st.pop();
                        st.push((char)k);
                    }
                    else if(st.peek()=='-' && st.size()>=3){
                        st.pop();
                        int k=(st.pop()-0)-n;
                        st.pop();
                        st.push((char)k);
                    }
                    else{
                        int m=st.pop();
                        st.pop();
                        st.push((char)m);
                    }

                }
                st.pop();
            }
            st.push(s.charAt(i));

        }
        return st.pop()-0;
    }

    public static void main(String[] args) {
       Stion obj=new Stion();
        HashMap<String,Integer> hs=new HashMap<>();

        System.out.println(obj.calculate("1 + 1"));
    }
}
class ccv{
    public boolean validPalindrome(String s) {

        if(ispal(s)){
            return true;
        }
        for(int i=0;i<s.length()/2;i++){

            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                s.replaceAll(s.charAt(i)+"","");
                // System.out.println(st);
                if(ispal(s)){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
    public boolean ispal(String s){

        for(int i=0;i<s.length()/2;i++){

            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuffer str=new StringBuffer();
        str.reverse();

    }
}
class plmk{
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> l=new ArrayList<>();

        for (int i = 0; i < words1.length ; i++) {
            boolean b=true;
            for (int j = 0; j < words2.length ; j++) {
                if (!(words1[i].contains(words2[j]))){
                    b=false;
                }
            }
            if(b){
                l.add(words1[i]);
            }
        }
        System.out.println(l);
        return l;
    }
    public static void main(String[] args) {
        String []words1 ={"amazon","apple","facebook","google","leetcode"};
        String []words2 = {"e","o"};
        wordSubsets(words1,words2);
    }
}