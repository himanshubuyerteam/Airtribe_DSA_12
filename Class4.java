import java.util.*;
public class Class4 {

    public static void helper(int sr,int sc,int dr,int dc,String ans,ArrayList<String>fans,int [][]arr)
    {

        if(sr>arr.length || sc>arr[0].length || sr<0 || dc<0 || arr[sr][sc]==0 )
            return;
        if(sr==dr && sc==dc)
        {
            fans.add(ans);
            return;
        }
        // MARK VISITED
        arr[sr][sc]=0;
        helper(sr-1, sc, dr, dc, ans+"U", fans,arr);
        helper(sr, sc+1, dr, dc, ans+"R", fans,arr);
        helper(sr+1, sc, dr, dc, ans+"D", fans,arr);
        helper(sr, sc-1, dr, dc, ans+"L", fans,arr);
        //UNMRKED VISTED
        arr[sr][sc]=1;
    }
    public ArrayList<String>RatInMaze(int [][]arr)
    {
        int n=arr.length;
        ArrayList<String>ans=new ArrayList<>();
        int sr=0;
        int sc=0;
        int dr=n-1;
        int dc=n-1;
        if(arr[sr][sc]==0 || arr[dr][dc]==0)
            return ans;
        helper(sr, sc, dr, dc, "", ans, arr);
        return ans;
    }
}
