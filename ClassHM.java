import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.*;

public class ClassHM {
    public boolean isZeroSubArraypresent(int []arr)
    {
        HashMap<Integer,Boolean>hm=new HashMap<>();
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
                return true;
            else
                hm.put(sum,true);
        }
        return false;
    }
    public int countOfZeroSubarray(int[] arr)
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int sum=0;
        int count=0;
        hm.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
            {
                count+=hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            }
            else
                hm.put(sum,1);
            
        }
        return count;
    }
    public int longestSubarray(int []arr)
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int sum=0;
        int gans=0;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
            {
                int length=i-hm.get(sum);
                gans=Math.max(gans,length);
            }
            else
            {
                hm.put(sum,i);
            }
        }
        return gans;
    }
    public int longestConsectiveSeq(int []arr)
    {
        HashMap<Integer,Boolean>hm=new HashMap<>();
        // for(int x:arr)
        //     hm.put(x,true);
        for(int i=0;i<arr.length;i++)
            hm.put(arr[i],true);
        
        for(int i=0;i<arr.length;i++)
        {
            if(hm.containsKey(arr[i]-1))
                hm.put(arr[i],false);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            if(hm.get(arr[i])==true)
            {   
                int length=1;
                while(hm.containsKey(arr[i]+length))
                {
                    length++;
                }
                ans=Math.max(ans,length);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // HashMap<Integer,String>hm=new HashMap<>();
        // hm.put(1,"HIMANSHU");
        // hm.put(2,"Sachin");
        // hm.put(3,"Rahul");
        // hm.put(1,"Richa");


        // // System.out.println(hm.get(1));
        // // System.out.println(hm.get(2));
        // // System.out.println(hm.size());
        // // // System.out.println(hm.get(5));
        // // System.out.println(hm.getOrDefault(5,"Not Found"));
        // hm.put(5,"Pankaj");
        // // System.out.println(hm.getOrDefault(5,"Not Found"));

        // for(int x:hm.keySet())
        // {
        //     System.out.println(x);
        // }

        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());

        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(50);

        System.out.println(pq.peek());
        System.out.println(pq.size());
        System.out.println(pq.remove());
        System.out.println(pq.peek());


        
    }
}
