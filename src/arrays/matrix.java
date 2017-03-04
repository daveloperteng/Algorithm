package arrays;

/**
 * Created by da.teng on 3/3/17.
 */
public class matrix {

    /**Problem Description:

     Given two sparse matrices A and B, return the result of AB.

     You may assume that A's column number is equal to B's row number.

     Example:

     A = [
     [ 1, 0, 0],
     [-1, 0, 3]
     ]

     B = [
     [ 7, 0, 0 ],
     [ 0, 0, 0 ],
     [ 0, 0, 1 ]
     ]


          |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                       | 0 0 1 |*/
    public static int[][] multiply(int[][] a, int[][]b) {
        int[][] result = new int[a.length][b[0].length];

        for(int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j ++) {
                int sum = 0;
                for (int bindex = 0; bindex < b.length; bindex ++) {
                    sum += a[i][bindex] * b[bindex][i];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }



}
