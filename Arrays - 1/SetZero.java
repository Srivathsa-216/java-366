//Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.

import java.util.ArrayList;
import java.util.Arrays;

class SetZero{

    
    private static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        
        //set -1 for rows and cols that contains 0 and not marking -1 for which having 0
        for(int i=0; i<n; i++){
            
            for(int j=0; j<m; j++){

                if(matrix.get(i).get(j) == 0){
                    markRow(matrix, m, i);
                    markCol(matrix, n, j);
                }
            }

        }

        //Finally mark all -1 as 0
        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(matrix.get(i).get(j) == -1){
                    matrix.get(i).set(j,0);
                }
            }

        }
        
        return matrix;
    }

    private static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int j) {

        // set all the non zero elements in column to -1

        for(int i=0; i<n; i++){

            if(matrix.get(i).get(j) != 0){

                matrix.get(i).set(j,-1);
            }
            
        }

    }

    private static void markRow(ArrayList<ArrayList<Integer>> matrix, int m, int i) {

        // set all the non zero elements in row to -1

        for(int j=0; j<m; j++){

            if(matrix.get(i).get(j) != 0){

                matrix.get(i).set(j,-1);

            }
        }

    }

    static ArrayList<ArrayList<Integer>> zeroMatrixOpt(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // int[] row = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]

        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark i-th row:
                    matrix.get(i).set(0, 0);

                    // mark j-th column:
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    // check for col & row:
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }

    public static void main(String a[]){

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,2,1)));
        matrix.add(new ArrayList<>(Arrays.asList(3,0,1)));
        
        ArrayList<ArrayList<Integer>> matrix1 = matrix;
        

        int n = matrix.size();
        int m = matrix.get(0).size();

        // Brute Force Approach
        // ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix,n,m);

        // System.out.println("The final matrix is ::");

        // for(ArrayList<Integer> row:ans){

        //     for(Integer ele: row){
        //         System.out.print(ele+" ");
        //     }

        //     System.out.println();

        // }

        //optimal way
        ArrayList<ArrayList<Integer>> ans1 = zeroMatrixOpt(matrix1, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans1) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }


    }



}