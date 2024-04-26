
class fS {
    
    public static void main(String args[])
    {   
        Scanner in=new Scanner(System.in);
        System.out.println("0");
        System.out.println("1");
        int a=0;
        int b=1;
        int n=25; //  Size of fibonacci series
        for(int j=1;j<n-1;j++)
        {
            int c=a+b;
            a=b;
            b=c;
            System.out.println(c);
        }
    }
}
