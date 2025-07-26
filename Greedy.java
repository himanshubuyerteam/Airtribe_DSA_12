import java.util.*;
class Item
{
    int val;
    int wt;
    Item(int val,int wt)
    {
        this.val=val;
        this.wt=wt;
    }
}
public class Greedy {
    public double fractionalKnapsack(int[] val, int[] wt, int maxWt) 
    {
        List<Item>al=new ArrayList<>();
        for(int i=0;i<val.length;i++)
        {
            Item item=new Item(val[i], wt[i]);
            al.add(item);
        }

        al.sort((a,b)->Double.compare((double)b.val/b.wt,(double)a.val/a.wt));
        
        double profit=0.0;
        int currWt=0;

        for(Item i:al)
        {
            if(currWt + i.wt <=maxWt)
            {
                currWt = currWt+ i.wt;
                profit = profit+i.val;
            }
            else
            {
                int wtICanCarry = maxWt- currWt;
                double profitByBreak = ((double)i.val/i.wt)*wtICanCarry;
                profit= profit+ profitByBreak;
                break;
            }
        }
        return profit;
    }
    public boolean jumpGame1(int arr[])
    {
        int maxJump=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i>maxJump)
                return false;
            maxJump=Math.max(maxJump,i+arr[i]);
            if(maxJump==arr.length-1)
                return true;
        }
        return true;
    }
    public int jumpGame2(int []arr)
    {
        int jump=0;
        int currEnd=0;
        int farrestEnd=0;
        for(int i=0;i<arr.length-1;i++)
        {
            farrestEnd= Math.max(farrestEnd,i+arr[i]);

            if(i==currEnd)
            {
                jump++;
                currEnd=farrestEnd;
            }
        }
        return jump;
    }
    class Solution {
    public long minimumDifference(int[] nums) {
        int N = nums.length; // 3*n
        int n = N / 3;
        
        long[] leftMinSum = new long[N];
        long[] rightMaxSum = new long[N];
        
        // Max heap for left side (to keep n smallest elements)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            
            leftMinSum[i] = leftSum;
        }
        
        // Min heap for right side (to keep n largest elements)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = N - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            
            rightMaxSum[i] = rightSum;
        }
        
        long result = Long.MAX_VALUE;
        
        for (int i = n - 1; i <= 2 * n - 1; i++) {
            result = Math.min(result, leftMinSum[i] - rightMaxSum[i + 1]);
        }
        
        return result;
    }
}
}
