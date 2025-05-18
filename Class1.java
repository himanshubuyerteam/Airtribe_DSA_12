class Class1{

    public static void selectionSort(int []arr)
    {
        int noOfElement=arr.length;
        for(int itr=0;itr<noOfElement-1;itr++)
        {
            int minIdx= itr;
            for(int j=itr+1;j<noOfElement;j++)
            {
                if(arr[j]<arr[minIdx])
                {
                    minIdx=j;
                }
            }
            int temp=arr[itr];
            arr[itr]=arr[minIdx];
            arr[minIdx]=temp;
        }
    }
    public static void bubbleSort(int []arr)
    {
        boolean swapped;
        int noOfElement=arr.length;
        for(int itr=1;itr<=noOfElement-1;itr++)
        {
            swapped=false;
            for(int j=0;j<noOfElement-itr;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(swapped==false)
            {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int []arr={1,4,12,15,10,90,46,47,0};
        System.out.println("Before sorting");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        bubbleSort(arr);
        System.out.println("After sorting");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}