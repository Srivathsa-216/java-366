//Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
//This problem is a variation of the popular Dutch National flag algorithm. 

import java.util.ArrayList;
import java.util.Arrays;

public class DNF {

    private static void sortArray(ArrayList<Integer> arr, int n) {

        int low=0, mid=0, high=n-1; //3 pointers


        while( mid <= high){

            if( arr.get(mid) == 0){

                //swapping arr[mid] and arr[low]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;


            } else if(arr.get(mid) == 1){
            
                mid++;
            
            } else {

                //swapping of arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;

            }
 

        }

    }
    

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        int n = arr.size();
        sortArray(arr,n);
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

    }

}
