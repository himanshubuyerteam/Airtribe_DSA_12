
public class BST {

    public int sumBST(Node root) 
    {
        if (root == null)
            return 0;
        int ls = sumBST(root.left);
        int rs = sumBST(root.right);
        return ls + rs + root.val;
    }
    public int sizeBST(Node root)
    {
        if(root==null)
            return 0;
        int ls = sizeBST(root.left);
        int rs = sizeBST(root.right);
        return ls+rs+1;
    }

    public int maximumBST(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        int lmax=maximumBST(root.left);
        int rmax=maximumBST(root.right);
        int cmax=Math.max(lmax,rmax);
        int mmax=Math.max(cmax,root.val);
        return mmax;
    }
    public int maximumBST2(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        while(root.right!=null)
            root=root.right;
        return root.val;
    }
    public int minimumBST2(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        while(root.left!=null)
            root=root.left;
        return root.val;
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
    public boolean isPresent2(Node root,int key)
    {
        if(root==null)
            return false;
        if(root.val==key)
            return true;
        if(root.val>key)    
            return isPresent2(root.left, key);
        else
            return isPresent2(root.right, key);
    }
    
    public Node LCABst(Node root,int n1,int n2)
    {
        Node curr=root;
        while(curr!=null)
        {
            if(curr.val> n1 && curr.val >n2)
                curr=curr.left;
            else if(curr.val<n1 && curr.val <n2)
                curr=curr.right;
            else
                return curr;
        }
        return null;
    }
    public Node LCABstRec(Node root,int n1,int n2)
    {
        if(root==null)
            return null;
        if((root.val>=n1 && root.val<=n2) || (root.val>=n2 && root.val<=n1))
            return root;
        if(root.val>n1 && root.val>n2)
            return LCABstRec(root.left,n1,n2);
        else if(root.val<n2 && root.val<n1)
            return LCABstRec(root.right,n1,n2);
        return null;
    }

    public class data
    {
        long min;
        long max;
        boolean isBST;
        data(long min,long max,boolean isBST)
        {
            this.min=min;
            this.max=max;
            this.isBST=isBST;
        }
    }
    public static data isBST(Node root)
    {
        if(root==null)
        {
            data nullcase=new data(Long.MIN_VALUE, Integer.MAX_VALUE, true);
            return nullcase;
        }
        data ldata=isBST(root.left);
        data rdata=isBST(root.right);

        boolean c1= ldata.max<root.val;
        boolean c2=rdata.min>root.val;
        boolean c3=ldata.isBST;
        boolean c4=rdata.isBST;

        boolean myisBst=c1&&c2&&c3&&c4;
        long mymin=Math.min(root.val,Math.min(ldata.min,rdata.min));
        long mymax=Math.max(root.val,Math.max(ldata.max,rdata.max));

        data mydata=new data(mymin, mymax, myisBst);
        return mydata;
       
    }
    public static boolean isTreeBST(Node root)
    {
        data d=isBST(root);
        return d.isBST;
    }


    public boolean isTreeBST2(Node root)
    {
        return isBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isBSTHelper(Node root,long lowerLimit, long UpperLimit)
    {
        if(root==null)
            return true;
        if(root.val>UpperLimit || root.val<lowerLimit)
            return false;
        boolean lans=isBSTHelper(root.left, lowerLimit, root.val-1);
        boolean rans=isBSTHelper(root.right, root.val+1, UpperLimit);
        return lans&& rans;
    }

    public Node insertInBST(Node root,int key)
    {
        if(root==null)
           return new Node(key);
        if(root.val>key)
            root.left=insertInBST(root.left,key);
        else
            root.right=insertInBST(root.right,key);
        return root;
    }

    public Node removeFromBST(Node root,int key)
    {
        if(root==null)
            return null;
        if(root.val>key)
        {
            Node lans=removeFromBST(root.left,key);
            root.left=lans;
        }
        if(root.val<key)
        {
            Node rans=removeFromBST(root.right,key);
            root.right=rans;
        }
        if(root.val==key)
        {
            if(root.left==null || root.right==null)
                return root.left==null?root.right:root.left;
            Node replaceNode=maximumBST(root.left);
            root.val=replaceNode.val;

            // IMPORTANT STEP
            root.left=removeFromBST(root.left, replaceNode.val);
        }
    }
    public static void main(String[] args) {

    }
}
