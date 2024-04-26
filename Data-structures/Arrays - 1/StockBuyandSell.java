//Problem: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

public class StockBuyandSell {
    
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int maxPro = maxProfit(arr);
        System.out.println("Max Profit can be attained is ::"+maxPro);
    }

    private static int maxProfit(int[] arr) {
        int maxpro = 0;
        int minprice = Integer.MAX_VALUE;
        for( int i = 0; i<arr.length; i++){

            minprice = Math.min(minprice, arr[i]);
            maxpro = Math.max(maxpro, arr[i] - minprice);

        }

        return maxpro;
    }

}
