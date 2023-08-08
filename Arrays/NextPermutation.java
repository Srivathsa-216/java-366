//Problem: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class NextPermutation {

     private static List<Integer> nextGreaterPermutation(List<Integer> a) {

        int n = a.size();

        //S1: Finding the break point
        int ind = -1;
        for(int i = n-2; i >= 0; i--){
            if(a.get(i) < a.get(i+1)){

                //ind is the break point
                ind = i;
                break;
            }
        }

        //S2: Find the next greater element and swap with the ind
        for(int i=n-1; i>ind; i--){

            if(a.get(i) > a.get(ind)){

                int tmp = a.get(i);
                a.set(i, a.get(ind));
                a.set(ind, tmp);
                break;
            }

        }

        //If break point doesn't exist
        if(ind == -1){
            
            //Reversing the whole array
            Collections.reverse(a);
            return a;

        }

        //S3: reverse the right half otherwise
        List<Integer> subList = a.subList(ind+1, n);
        Collections.reverse(subList);


        return a;
    }
    
    public static void main(String a[]){
        List<Integer> A = Arrays.asList(new Integer[] {3,8,5,2,3,0,0});
        List<Integer> ans = nextGreaterPermutation(A);
        
        System.out.print("The next permutation is [");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println("]");

    }

   

}
