public class BinarySearch {

    public static int binarySearch(int arr[],int tar)
    {
        int s=0;
        int e=arr.length-1;
        while(s<=e)
        {
            int mi=(s+e)/2;
            int me=arr[mi];
            if(me==tar)
                return mi;
            else if(me>tar)
                e=mi-1;
            else
                s=mi+1;
        }
        return -1;
    }
    public static int firstOcc(int []arr,int tar)
    {
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while(s<=e)
        {
            int mi=(s+e)/2;
            int me=arr[mi];
            if(me==tar)
            {
                ans=mi;
                e=mi-1;
            }
            else if(me>tar)
            {
                e=mi-1;
            }
            else
            {
                s=mi+1;
            }
        }
        return ans;
    }
    public static int lastOcc(int []arr,int tar)
    {
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while(s<=e)
        {
            int mi=(s+e)/2;
            int me=arr[mi];
            if(me==tar)
            {
                ans=mi;
                s=mi+1;
            }
            else if(me>tar)
            {
                e=mi-1;
            }
            else
            {
                s=mi+1;
            }
        }
        return ans;
    }
    public static int countOcc(int []arr,int tar)
    {
        int fo=firstOcc(arr, tar);
        int lo=lastOcc(arr, tar);
        int count=lo-fo+1;
        return count;
    }

    public static int findSqrt(int num)
    {
        int s=0;
        int e=num;
        while(s<=e)
        {
            int mid=(s+e)/2;
            int me=mid*mid;
            if(me==num)
                return mid;
            else if(me>num)
                e=mid-1;
            else
                s=mid+1;
        }
        return -1;
    }

    public static int findMinRSA(int []arr)
    {
        int s=0;
        int e=arr.length-1;
        while(s<e)
        {
            int mi=(s+e)/2;
            int me=arr[mi];
            if(me>arr[e])
                s=mi+1;
            else
                e=mi;
        }
        return arr[e];
    }
    public static int findRotation(int []arr)
    {
        int s=0;
        int e=arr.length-1;
        while(s<e)
        {
            int mi=(s+e)/2;
            int me=arr[mi];
            if(me>arr[e])
                s=mi+1;
            else
                e=mi;
        }
        return e;
    }

    public static int searchRSA(int []arr,int tar)
    {
        if(arr[0]==tar)
            return 0;
        if(arr[arr.length-1]==tar)
            return arr.length-1;
        int minIdx=findRotation(arr);

        int ans=binarySearch(arr,0,minIdx-1, tar);
        if(ans==-1)
            ans=binarySearch(arr,minIdx,arr.length-1, tar);
        return ans;
    }
    //Leetcode 
    public static int binarySearch(int []arr,int s,int e,int tar)
    {
        int si=s;
        int ei=e;
        while(si<=ei)
        {
            int mi=(si+ei)/2;
            int me=arr[mi];
            if(me==tar)
                return mi;
            else if(me>tar)
                ei=mi-1;
            else
                si=mi+1;
        }
        return -1;
    }
    public static boolean ispossibletoEat(int eatingSpeed,int arr[],int hr)
    {
        int time=0;
        for(int i=0;i<arr.length;i++)
        {
            time+=Math.ceil(arr[i]/(eatingSpeed*1.0));
        }
        if(time<=hr)    
            return true;
        else
            return false;
    }
    public static int koko(int arr[],int hr)
    {
        int si=1;
        int ei=1;
        for(int x:arr)
            ei=Math.max(ei,x);
        while(si<ei)
        {
            int eatingSpeed=(si+ei)/2;
            if(ispossibletoEat(eatingSpeed,arr,hr))
                ei=eatingSpeed;
            else
                si=eatingSpeed+1;
        }
        return si;
    }
    public static void main(String[] args) {
        
    }
}
