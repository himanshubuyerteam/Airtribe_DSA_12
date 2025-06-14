import java.util.*;
import java.util.LinkedList;
import java.io.*;
class Node{
    Node left;
    Node right;
    int val;
}
public class BinaryTree {

    public int size(Node root)
    {
        if(root==null)
            return 0;
        int ls = size(root.left);
        int rs = size(root.right);
        return ls+rs+1;
    }
    public int sum(Node root)
    {
        if(root==null)
            return 0;
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls+rs+root.val;
    }
    public int maximum(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        int lmax=maximum(root.left);
        int rmax=maximum(root.right);
        int cmax=Math.max(lmax,rmax);
        int mmax=Math.max(cmax,root.val);
        return mmax;
    }

    public int minimum(Node root)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        int lmin=minimum(root.left);
        int rmin=minimum(root.right);
        int cmin=Math.min(lmin,rmin);
        int mmin=Math.min(cmin,root.val);
        return mmin;
    }

    public boolean isPresent(Node root,int key)
    {
        if(root==null)
            return false;
        if(root.val==key)
            return true;
        boolean lans=isPresent(root.left,key);
        boolean rans=isPresent(root.right,key);
        if(lans || rans)
            return true;
        return false;
    }

    public boolean isPresent(Node root,int key,ArrayList<Node>path)
    {
        if(root==null)
            return false;
        if(root.val==key)
        {
            path.add(root);    
            return true;
        }
        boolean lans=isPresent(root.left,key,path);
        if(lans==true)
        {
            path.add(root);
            return true;
        }
        boolean rans=isPresent(root.right,key,path);
        if(rans == true)
        {
            path.add(root);
            return true;
        }
        return false;
    }
    Node lca=null;
    public boolean isPresent(Node root,int key,Set<Node>path)
    {
        if(root==null)
            return false;
        if(root.val==key)
        {
            if(path.contains(root))
            {    
                lca=root;
                return true;
            }
            path.add(root);   
            return true;
        }
        boolean lans=isPresent(root.left,key,path);
        if(lans==true)
        {
            path.add(root);
            return true;
        }
        boolean rans=isPresent(root.right,key,path);
        if(rans == true)
        {
            path.add(root);
            return true;
        }
        return false;
    }

    public void LCA_setApproach(Node root,Node n1,Node n2)
    {
        Set<Node>path1=new HashSet<>();
        isPresent(root,n1.val, path1);
        isPresent(root,n2.val,path1);
    }
    public Node LCA(Node root,Node n1,Node n2)
    {
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();
        isPresent(root,n1.val,path1);
        isPresent(root,n2.val,path2);

        int i=path1.size()-1;
        int j=path2.size()-1;
        Node lca=null;
        while(i>=0 && j>=0)
        {
            if(path1.get(i).val == path2.get(j).val)
            {
                i--;
                j--;
            }
            else
            {
                lca=path1.get(i+1);
                break;
            }
        }
        return lca;
    }
    
    public void printInorder(Node root)
    {
        if(root==null)
            return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }
    public void printPreorder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.val+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public void printPostorder(Node root)
    {
        if(root==null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val+" ");
    }

    public void printLevelOrderSingleLine(Node root)
    {
        Queue<Node>q=new LinkedList();
        q.add(root);
        while(q.size()>0)
        {
            Node fnt=q.remove();
            System.out.print(fnt.val+" ");
            if(fnt.left!=null)
                q.add(fnt.left);
            if(fnt.right!=null)
                q.add(fnt.right);
        }
    }
    public void printLevelOrderLevelWise(Node root)
    {
        Queue<Node>q=new LinkedList();
        q.add(root);
        while(q.size()>0)
        {
            int s=q.size();
            while(s>0)
            {
                Node fnt=q.remove();
                System.out.print(fnt.val+" ");
                if(fnt.left!=null)
                    q.add(fnt.left);
                if(fnt.right!=null)
                    q.add(fnt.right);
                s--;
            }
            System.out.println();
        }
    }

    public int height_Edge(Node root)
    {
        if(root==null)
            return -1;
        int lh=height_Edge(root.left);
        int rh=height_Edge(root.right);
        int mh=Math.max(lh,rh)+1;
        return mh;
    }

    public int height_Node(Node root)
    {
        if(root==null)
            return 0;
        int lh=height_Node(root.left);
        int rh=height_Node(root.right);
        int mh=Math.max(lh,rh)+1;
        return mh;
    }


    public static void main(String[] args) {
        
    }
}
