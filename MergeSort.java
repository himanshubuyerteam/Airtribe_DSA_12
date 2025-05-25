// //Merge Sort
// public class MergeSort {

//     public static int [] mergeSort(int []arr)
//     {
//         return mergeSortHelper(arr,0,arr.length-1);
//     }
//     public static int [] mergeSortHelper(int []arr,int si,int ei)
//     {
//         if (si == ei)
//             return new int[] { arr[si] };
//         int mid=(si+ei)/2;
//         int []lsa=mergeSortHelper(arr,si,mid);
//         int []rsa=mergeSortHelper(arr,mid+1,ei);
//         int []fans=merge2SortedArray(lsa,rsa);
//         return fans;
//     }
//     public static int [] merge2SortedArray(int []lsa,int []rsa)
//     {
//         int []fans=new int[lsa.length+rsa.length];
//         int i=0;
//         int j=0;
//         int k=0;
//         while(i<lsa.length && j<rsa.length)
//         {
//             if(lsa[i]<rsa[j])
//                 fans[k++]=lsa[i++];
//             else
//                 fans[k++]=rsa[j++];
//         }
//         while(i<lsa.length)
//             fans[k++]=lsa[i++];
//         while(j<rsa.length)
//             fans[k++]=rsa[j++];
//         return fans;
//     }
//     public static void main(String[] args) {
//         int []arr={6,3,9,19,11,2};
//         int []ans=mergeSort(arr);
//         for(int i=0;i<ans.length;i++)
//             System.out.print(ans[i]+" ");
//     }
// }




// QuickSort
class MergeSort{
    public static void quickSort(int []arr)
    {
        quickSortHelper(arr,0,arr.length-1);
    }
    static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partation(arr, low, high,arr[high]);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }
    public static int partation(int []arr,int si,int ei,int pivotElement)
    {
        int i=si;
        int j=si;
        while(i<=ei)
        {
            if(arr[i]<=pivotElement)
            {
                swap(arr,i,j);
                i++;
                j++;
            }
            else
                i++;
        }
       return j-1;    
    }

    public static void swap(int []arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int []arr={6,3,9,19,11,2};
                quickSort(arr);
                for(int i=0;i<arr.length;i++)
                    System.out.print(arr[i]+" ");
    }
}