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
