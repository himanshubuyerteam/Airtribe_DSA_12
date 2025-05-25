public class Class5 {

    public static int capacityToShip(int []arr,int days)
    {
        int s=0;
        int e=0;
        for(int x:arr)
        {
            s=Math.max(s,x);
            e=e+x;
        }

        while(s<e)
        {
            int midVal=(s+e)/2;
            if(isPossible(arr,days,midVal))
                e=midVal;
            else
                s=midVal+1;
        }
        return s;
    }
    public static boolean isPossible(int []arr,int days,int cap)
    {
        int dayUsed=1;
        int currWt=0;

        for(int wt:arr)
        {
            currWt+=wt;
            if(currWt>cap)
            {
                dayUsed++;
                currWt=wt;
            }
        }
        if(dayUsed>days)
            return false;
        else
            return true;

    }
   
    public static int [] mergeSort(int []arr,int s,int e)
    {
        if(s==e)
            return new int[]{arr[s]};
        int midIdx=(s+e)/2;
        int []lsa=mergeSort(arr,s,midIdx);
        int []rsa=mergeSort(arr,midIdx+1,e);
        int []fsa=merge2SortedArray(lsa, rsa);
        return fsa;
    }
    public static int [] merge2SortedArray(int []arr1,int []arr2)
    {
        int []ans=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                ans[k]=arr1[i];
                i++;
                k++;
            }
            else
            {
                ans[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i<arr1.length)
        {
            ans[k]=arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length)
        {
            ans[k]=arr2[j];
            k++;
            j++;
        }
        return ans;
    }
    

    public static void quickSort(int []arr,int s,int e)
    {
        if(s>e)
            return;
        int pivotEle=arr[e];
        int pi=partation(arr, s, e, pivotEle);
        quickSort(arr,s,pi-1);
        quickSort(arr, pi+1, e);
    }
    public static int partation(int arr[],int s,int e,int pivotEle)
    {
        int i=s;
        int j=s;
        while(i<=e)
        {
            if(arr[i]<=pivotEle)
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
    
    public static void InsertionSort(int []arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int ele=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>ele)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=ele;
        }
    }
    public static void main(String[] args) {
        int []arr={5,2,8,10,1,0,11,14};
        // quickSort(arr,0,arr.length-1);
        InsertionSort(arr);
        for(int x:arr)
            System.out.print(x+" ");
    }
}
