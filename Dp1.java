import java.util.*;
public class Dp1 {
    
    public static int fib(int n)
    {
        System.out.println("Calculation Fib for this number "+n);
        if(n<=1)
            return n;
        int ra1=fib(n-1);
        int ra2=fib(n-2);
        int ans=ra1+ra2;
        return ans;
    }

    //Approch1
    //Memoization/ Top Down
    // O(N)- Time Complexity
    // O(N)- Space Complexity
    
    public static int fib_memo(int n,int []notes)
    {
        if(n<=1)
            return n;
        // step2. check if already calculated
        if(notes[n]!=-1)
            return notes[n];
        System.out.println("Calculation Fib for this number "+n);
        int ra1=fib_memo(n-1,notes);
        int ra2=fib_memo(n-2,notes);
        int ans=ra1+ra2;
        // step1. before return save the ans
        notes[n]=ans;
        return ans;
    }
    //Approch2
    //Tabulation/ Bottom Up
    // O(N)- Time Complexity
    // O(N)- Space Complexity
    public static int fib_tab(int n)
    {
        int []arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
            arr[i]=arr[i-1]+arr[i-2];
        return arr[n];
    }
    
    public static void mazePath(int n,int m)
    {
        System.out.println(mazePathHelper(0,0,n-1,m-1));
        int [][]arr=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                arr[i][j]=-1;
        }
        System.out.println(mazePathHelper_Memo(0,0,n-1,m-1,arr));
    }
    public static int mazePathHelper(int sr,int sc,int dr,int dc)
    {
        if(sr == dr && sc == dc)
            return 1;
        if(sr>dr || sc>dc)
            return 0;
        int ra1 = mazePathHelper(sr+1, sc, dr, dc);
        int ra2= mazePathHelper(sr, sc+1, dr, dc);
        return ra1+ra2;
    }
    public static int mazePathHelper_Memo(int sr,int sc,int dr,int dc,int [][]arr)
    {
        if(sr == dr && sc == dc)
            return 1;
        if(sr>dr || sc>dc)
            return 0;
        if(arr[sr][sc]!=-1)
            return arr[sr][sc];
        int ra1 = mazePathHelper_Memo(sr+1, sc, dr, dc,arr);
        int ra2= mazePathHelper_Memo(sr, sc+1, dr, dc,arr);
        arr[sr][sc]=ra1+ra2;
        return ra1+ra2;
    }

    public static int mazePath_Tab(int n,int m)
    {
        int [][]dp=new int [n][m];
        
        for(int i =0;i<n;i++)
            dp[i][m-1]=1;

        for(int i=0;i<m;i++)
            dp[n-1][i]=1;

        for(int i=n-2;i>=0;i--)
        {
            for(int j=m-2;j>=0;j--)
            {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
    public static int minCostPath_rec(int [][]arr)
    {
        int n=arr.length;
        int m=arr[0].length;
        return minCostPath_Rec_Helper(arr,0,0,n-1,m-1);
    }

    public static int minCostPath_Rec_Helper(int [][]arr,int sr,int sc,int dr,int dc)
    {
        
        if( sr ==dr && sc == dc)
            return arr[sr][sc];
        if(sr>dr || sc>dc)
            return Integer.MAX_VALUE;
        
        int ra1= minCostPath_Rec_Helper(arr, sr+1, sc, dr, dc);
        int ra2= minCostPath_Rec_Helper(arr, sr, sc+1, dr, dc);
        
        int mcost= Math.min(ra1,ra2)+arr[sr][sc];
        return mcost;        
    }

    public static int minCostPath_Rec_Helper_memo(int [][]arr,int sr,int sc,int dr,int dc,int [][]notes`)
    {
        
        if( sr ==dr && sc == dc)
            return arr[sr][sc];
        if(sr>dr || sc>dc)
            return Integer.MAX_VALUE;
        if(notes[sr][sc]!=Integer.MAX_VALUE)
            return notes[sr][sc];
        int ra1= minCostPath_Rec_Helper(arr, sr+1, sc, dr, dc);
        int ra2= minCostPath_Rec_Helper(arr, sr, sc+1, dr, dc);
        
        int mcost= Math.min(ra1,ra2)+arr[sr][sc];
        notes[sr][sc]=mcost;
        return mcost;        
    }

    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;

        int [][]dp=new int[n][m];

        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1 && j==dp[0].length-1)
                    dp[i][j]=arr[i][j];
                else if(i==dp.length-1)//last row
                    dp[i][j]=arr[i][j]+dp[i][j+1];
                else if(j==dp[0].length-1)
                    dp[i][j]=arr[i][j]+dp[i+1][j];
                else
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+arr[i][j];
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) 
    {
        // int n=6;
        // int []notes=new int[n+1];
        // Arrays.fill(notes,-1);
        // // System.out.println(fib(n));    
        // System.out.println(fib_memo(n,notes));
        mazePath(3, 3);
    }
}
