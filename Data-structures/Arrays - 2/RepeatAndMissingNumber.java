//Problem: You are given a read-only array of N integers with values also in the range [1, N] 
//both inclusive. Each integer appears exactly once except A which appears twice and B which 
//is missing. The task is to find the repeating and missing numbers A and B where A repeats 
//twice and B is missing.


class RepeatAndMissingNumber{

    public static void main(String[] args) {
        int a[] = {3, 1, 2, 5, 4, 6, 7, 5};
        int ans[] = findMissingRepeatingNumbers(a);
        System.out.println("The repeating and missing numbers are :: { "+ans[0]+" , "+ans[1]+" }");
    }

    private static int[] findMissingRepeatingNumbers(int[] a) {
        long n = a.length; // size of array

        //Finding Sn and S2n
        long Sn = (n * ( n+1 ))/2;
        long S2n = (n * (n+1) * (2*n+1))/6;

        //Calculating S and S2
        long S = 0, S2 = 0;
        for(int i = 0;i < n;i++ ){
            
            S += a[i];
            S2 += (long)a[i] * (long)a[i];

        }

        //S-Sn = X - Y
        long val1 = S - Sn;

        //S2-S2n = X^2 - Y^2
        long val2 = S2 - S2n;

        //Finding X+Y = (X^2 - Y^2)/(X -Y):
        val2 = val2/val1;

        //Find X and Y : X = ((X+Y)(X-Y))/2 and Y = X-(X-Y)
        //Here X-Y = val1 and X+Y = val2:

        long x = (val1 + val2)/2;
        long y = x - val1;

        int[] ans = {(int)x , (int)y};
        
        return ans;

    }

}