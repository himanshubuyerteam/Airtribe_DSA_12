public class dp2 {

    public boolean targetSumSubset(int []arr,int targetSum)
    {
        boolean [][]dp=new boolean[arr.length+1][targetSum+1];

        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=false;
                else if(j==0)
                    dp[i][j]=true;
                else
                {
                    if(dp[i-1][j]==true)
                        dp[i][j]=true;
                    else
                    {
                        int virat_run=arr[i-1];
                        int team_run=j;
                        if(team_run>=virat_run)
                        {
                        
                            if(dp[i-1][j-team_run]==true)
                                dp[i][j]=true;
                        }
                    }
                }

            }
        }
        return dp[arr.length][targetSum];
    }
    public int knapsack(int []wt,int []val,int maxWt)
    {
        int noOfItem=wt.length;
        
        int [][]dp=new int[noOfItem+1][maxWt+1];

        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                int op1= dp[i-1][j];
                int op2=0;
                if(j>=wt[i-1])
                {
                    op2=dp[i-1][j-wt[i-1]]+val[i-1];
                }
                dp[i][j]=Math.max(op1,op2);
            }
        }
        return dp[dp.length][maxWt];
    }
    public int unbounedKnapsack(int []wt,int []val,int maxWt)
    {
        int noOfItem = wt.length;

        int []dp=new int[maxWt+1];

        for(int i=1;i<dp.length;i++)
        {
            int max=0;
            for(int j=0;i<noOfItem;j++)
            {
                if(wt[j]<=i)
                {
                    max=Math.max(dp[i-wt[j]]+val[i],max);
                }
                dp[i]=max;
            }
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        
    }

}
