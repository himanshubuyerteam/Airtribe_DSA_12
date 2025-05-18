import java.util.*;
public class Nqueen 
{
    public boolean isSafePlace(char [][]arr,int row,int col)
    {
        //Check for Col  (2,5)  
        for(int i=0;i<row;i++)
        {
            if(arr[i][col]=='Q')
                return false;
        }

        //Upper Left Diagoal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(arr[i][j]=='Q')
                return false;
        }

        //Upper Right Diagoal
        for(int i=row-1,j=col+1;i>=0 && j<arr.length;i--,j++)
        {
            if(arr[i][j]=='Q')
                return false;
        }

        return true;

    }
    public void helper(int noOfQueen,List<List<String>>ans,char [][]arr,int row)
    {
        if(row==noOfQueen)
        {
            List<String>smallans=new ArrayList<>();
            for(char []a:arr)
            {
                smallans.add(new String(a));
            }
            ans.add(smallans);
            return;
        }
        for(int col=0;col<noOfQueen;col++)
        {
            if(isSafePlace(noOfQueen,arr,row,col))
            {
                arr[row][col]='Q';
                helper(noOfQueen, ans, arr, row+1);
                arr[row][col]='.';
            }
        }
    }
    public List<List<String>> nqueen(int num)
    {
        List<List<String>> ans=new ArrayList<>();
        char [][]arr=new char[num][num];

        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num;j++)
            {
                arr[i][j]='.';
            }
        }
        helper(num,ans,arr,0);
        return ans;
    }
}



import java.util.ArrayList;
import java.util.*;
public class PerOfString {
    public static void swap(StringBuilder str,int i,int j)
    {
        char temp=str.charAt(i);
        str.setCharAt(i,str.charAt(j));
        str.setCharAt(j,temp);
    }
    public static void permutation(StringBuilder str,List<String>ans,int idx)
    {
        if(idx==str.length())
        {
            ans.add(str.toString());
            return;
        }
        for(int i=idx;i<str.length();i++)
        {
            swap(str,i,idx);
            permutation(str,ans,idx+1);
            swap(str,i,idx);
        }
    }

    public static void main(String[] args) {
        StringBuilder str=new StringBuilder("abc");
        List<String>ans=new ArrayList<>();
        permutation(str,ans,0);
        System.out.println(ans);
    }
}



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
