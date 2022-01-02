package Sorting;

public class insertionsort {
    public static void sort(int a[],int n){

        for (int i = 1; i < n; i++) {
            int temp=a[i];
            int j=i;

            while (j>0 && a[j-1]>temp){
                a[j]=a[j-1];
                j=j-1;
//               swap(temp,a[i]);

            }
            a[j]=temp;
        }
    }
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
    public static void print(int a[],int n){
        for (int i = 0; i <n ; i++) {
            System.out.print(a[i] +" ");
        }
    }
    public static void main(String[] args) {
        int a[]={12,2,34,1,23};
        sort(a,a.length);
        print(a,a.length);
    }
}
