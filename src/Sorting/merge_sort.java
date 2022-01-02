package Sorting;

public class merge_sort {
    static void merge(int a[], int beg, int mid, int end)
    {
        int LA[]=new int[mid], RA[]=new int[end-mid];
        for (int i = 0; i < mid; i++)
            LA[i] = a[i];

        int k=0;
        for (int j = mid; j < end; j++)
            RA[k++] = a[j];

        int i = 0;
        int	j = 0;
        k = 0;
        while (i < LA.length && j < RA.length)
        {
            if(LA[i] <= RA[j])
            {
                a[k] = LA[i];
                i++;
            }
            else
            {
                a[k] = RA[j];
                j++;
            }
            k++;
        }
        while (i< LA.length)
        {
            a[k] = LA[i];
            i++;
            k++;
        }
        while (j< RA.length)
        {
            a[k] = RA[j];
            j++;
            k++;
        }
    }
    static void mergeSort(int a[], int beg, int end)
    {
        if (beg < end)
        {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }

    public static void main(String[] args) {
        int a[]={12,21,2,410};
        mergeSort(a,0,a.length-1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
