package LeetCode.Linked_List;

public class getmax_in_generated_array {

    public static void main(String[] args) {
        int n=0;
        int nm[]=new int[n+1];

        nm[0]=0;nm[1]=1;

        int max=0;
        for (int i = 1; i <= n; i++) {
            if(2*i<=n ){
             nm[2*i]=nm[i];
             max=Math.max(max,nm[2*i]);
            }
            if(2*i+1<=n){
                nm[2*i+1]=nm[i]+nm[i+1];
                max=Math.max(max,nm[2*i+1]);
            }
        }
        for (int i = 0; i <=n ; i++) {
            System.out.println(nm[i]);
        }
        System.out.println(max);
    }
}
