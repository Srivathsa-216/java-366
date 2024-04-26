//v1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
//v2: Given the row number n. Print the n-th row of Pascal’s triangle.
//v3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    //v1
    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    //v2
    public static void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    //v3
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangleList(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }


    public static void main(String[] args) {

        int r = 5; // row number
        int c = 3; // col number

        //v1
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);

        //v2
        int row = 5;
        pascalTriangle(row);

        //v3
        int n = 5;
        List<List<Integer>> ans = pascalTriangleList(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}  
        