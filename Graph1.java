import java.util.*;
public class Graph1 {
    public int noofIsland(char [][]graph)
    {
        int ans=0;
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[0].length;j++)
            {
                if(graph[i][j]=='1' )
                {
                    dfs(i,j,graph);
                    ans++;
                }
            }
        
        }
        return ans;
    }
    public void dfs(int i,int j,char [][]graph)
    {
        if(i>=graph.length || i<0 || j>=graph[0].length || j<0 ||
             graph[i][j]=='0')
            return;
        // vis[i][j]=true;
        graph[i][j]='0';
        dfs(i+1,j,graph);
        dfs(i-1,j,graph);
        dfs(i,j+1,graph);
        dfs(i,j-1,graph);
    }
       
    class data
    {
        int x;
        int y;
        int time;
        data(int x,int y,int time)
        {
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
    public int rottenOrganes(int [][]arr)
    {
        int ans=0;
        int fc=0;
        int rc=0;
        boolean [][]vis =new boolean[arr.length][arr[0].length];
        LinkedList<data>q=new LinkedList();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==2)
                {
                    rc++;
                    q.add(new data(i,j,0));
                    vis[i][j]=true;
                }
                else if(arr[i][j]==1)
                {
                    fc++;
                }
            }
        }

        if(fc==0)
            return 0;
        
        int [][]dir={{0,-1},{0,1},{-1,0},{1,0}};

        while(q.size()>0)
        {
            data fnt= q.remove();
            ans=Math.max(ans,fnt.time);

            for(int []d:dir)
            {
                int nr=fnt.x+d[0];
                int nc= fnt.y+d[1];
                if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && vis[nr][nc]==false && arr[nr][nc]==1)
                {
                    vis[nr][nc]=true;
                    q.add(new data(nr,nc,fnt.time+1));
                    fc--;
                }
            }
        }

       if(fc==0)
        return ans;
        else
            return -1;
        
    }

}
