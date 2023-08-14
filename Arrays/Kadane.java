// Problem: Given an integer array arr, find the contiguous subarray (containing at least one number) which
//has the largest sum and returns its sum and prints the subarray.

public class Kadane {


     private static long maxSubarraySum(int[] arr, int n) {

        long maxi = Integer.MIN_VALUE; //maximum sum value
        long sum = 0;

        for( int i=0 ; i<n ; i++){

            sum += arr[i];

            if( sum > maxi){
                maxi = sum;
            }

            // if sum < 0: discard the sum calculated
            if (sum < 0){
                sum=0;
            }

        }

        // to consider the empty sub array following is used
        if (maxi < 0) maxi = 0;
        
        return maxi;
    }
    
    
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr,n);
        System.out.println("The maximum sum of subarray is :: "+maxSum);
    }

   

}
