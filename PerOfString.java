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
