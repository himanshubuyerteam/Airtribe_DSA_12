public class Rec {

    public static void pd(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        pd(n-1);
    }
    public static void pi(int n)
    {
        if(n==0)
            return;
        // pi(n-1);
        System.out.println(n);
        pi(n-1);
    }

    public static void pdi(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    public static int fact(int n)
    {
        if(n==1)
            return n;
        int rans=fact(n-1);
        int myans=rans*n;
        return myans;
    }

    public static int sumOfDigit(int num)
    {
        if(num>=1 && num<=9)
            return num;
        int rans=sumOfDigit(num/10);
        int myans=rans+num%10;
        return myans;
    }

    public static int multiply(int a,int b)
    {
        if(b==1)
            return a;
        int rans=multiply(a, b-1);
        int myans=rans+a;
        return myans;
    }

    public static int power(int a,int b)
    {
        if(b==1)
            return a;
        int rans=power(a, b-1);
        int mans=rans*a;
        return mans;
    }
    public static int powerBetter(int a,int b)
    {
        if(b==1)
            return a;
        int rans=powerBetter(a, b/2);
        int myans=rans*rans;
        if(b%2==1)
            myans=myans*a;
        return myans;
    }

    public static int mazePath(int sr,int sc,int dr,int dc)
    {
        if(sr>dr || sc>dc)
            return 0;
        if(sr==dr && dc==sc)
            return 1;
        int ra1=mazePath(sr+1, sc, dr, dc);
        int ra2=mazePath(sr, sc+1, dr, dc);
        int ra3=mazePath(sr+1, sc+1, dr, dc);
        int ma=ra1+ra2+ra3;
        return ma;
    }
    public static void main(String[] args) {
        
        int n=179;
        int a=n/10;
        System.out.println(a);
    }
}
