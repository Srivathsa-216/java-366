//Problem:  Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlap {
    
    public static void main(String[] args) {
        
        int arr[][] = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);
        System.out.println("The merged intervals are ::");
        for(List<Integer> it: ans){
            System.out.print("["+ it.get(0) + ","+ it.get(1)+ "]");
        }
        System.out.println();

    }

    private static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {

        int n = arr.length; // size of array


        //sort the given intervals
        Arrays.sort(arr, new Comparator<int[] >() {
            public int compare(int a[], int[] b){
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){

            //if the current interval doesnt lie in the last interval
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)){

                ans.add(Arrays.asList(arr[i][0], arr[i][1]));

            }

            //if the current interval lies in the last interval
            else{

                ans.get(ans.size() - 1).set(1,
                    Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));

            }
        }


        return ans;
    }

}
