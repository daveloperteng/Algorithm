package dynamicProgramming;

/**
 * Created by da.teng on 2/16/17.
 */
public class dp {

    /*Fibonacci*/
    public static int fibonacci(int num) {
        int[] buff = new int[num + 1];
        buff[1] = 1;
        buff[2] = 1;

        return fibonacci(buff, num);
    }

    private static int fibonacci(int[] buff, int num) {
        if (buff[num] != 0) {
            return buff[num];
        }

        buff[num] = fibonacci(buff, num - 1) + fibonacci(buff, num - 2);
        return buff[num];
    }

    /**
     * Question: paint grid with red, blue, green. green can't be next to blue. how many possible ways?*/

    //top down
    public static int paintGrid1(int length) {
        int[][] buff = new int[length+1][4];
        buff[1][1] = 1;
        buff[1][2] = 1;
        buff[1][3] = 1;

        return paintGrid1Helper(buff, length, 1) + paintGrid1Helper(buff, length, 2) + paintGrid1Helper(buff, length, 3);
    }

    private static int paintGrid1Helper(int[][] buff, int step, int color) {
        if (buff[step][color] != 0) {
            return buff[step][color];
        }

        if (color == 1) {
            buff[step][1] = paintGrid1Helper(buff, step - 1, 1) + paintGrid1Helper(buff, step - 1, 3);
        }

        if (color == 2) {
            buff[step][2] = paintGrid1Helper(buff, step - 1, 2) + paintGrid1Helper(buff, step - 1, 3);
        }

        if (color == 3) {
            buff[step][3] = paintGrid1Helper(buff, step - 1, 1) + paintGrid1Helper(buff, step - 1, 2)
                    + paintGrid1Helper(buff, step - 1, 3);
        }

        return buff[step][color];
    }

    /**
     * an int[][] if the value is 0, it means, you can pass that, if the value is 1, it is a block.
     * starting from [0][0] to [length-1][length-1], how many possible ways*/
    public static int dpGrid(int[][] grids) {
        return dpGridHelper(grids, 0, 0, grids.length - 1);
    }

    private static int dpGridHelper(int[][] grids, int x, int y, int boundary) {
        if (x == boundary && y == boundary) {
            return 1;
        }

        if (grids[x][y] == 1) {
            return 0;
        }

        if (y == boundary) {
            return dpGridHelper(grids, x + 1, y, boundary);
        }

        if (x == boundary) {
            return dpGridHelper(grids, y + 1, x, boundary);
        }

        return dpGridHelper(grids, x + 1, y, boundary) + dpGridHelper(grids, x, y + 1, boundary);

    }

    /**Given int[][] with numbers on it,
     * from start(0,0) to end(bottom right), what is the max values it will pass*/
    public static int maxPath(int[][] grids) {
        return maxPathHelper(grids, 0, 0, grids.length - 1, 0);
    }

    private static int maxPathHelper(int[][] grids, int x, int y, int boundary, int sum) {
        sum += grids[x][y];

        if(x == boundary && y == boundary) {
            return sum;
        }

        if (x == boundary) {
            return maxPathHelper(grids, x, y + 1, boundary, sum);
        }

        if (y == boundary) {
            return maxPathHelper(grids, x + 1, y, boundary, sum);
        }

        return Math.max(maxPathHelper(grids, x + 1, y, boundary, sum), maxPathHelper(grids, x, y + 1, boundary, sum));

    }

    /*Find the Celebrity
    Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
    The definition of a celebrity is that all the other n - 1people know him/her but he/she does not know any of them.
    Now you want to find out who the celebrity is or verify that there is not one.
    The only thing you are allowed to do is to ask questions like:
    "Hi, A. Do you know B?" to get information of whether A knows B.
    You need to find out the celebrity (or verify there is not one) by asking as few questions
    as possible (in the asymptotic sense).
    You are given a helper function bool knows(a, b) which tells you whether A knows B.
    Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
    Note: There will be exactly one celebrity if he/she is in the party.
    Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
    **/
    public int findCelebrity(int n) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (know(left, right)) {
                left ++;
            } else {
                right --;
            }
        }

        int candidate = left;

        for (int i = 0; i < n; i ++) {
            if (i != candidate) {
                if (know(candidate, i) | !know(i, candidate)) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    /**This is supposed to be an API, return true, if a knows b, return false if a doesnt know b*/
    private boolean know(int a, int b) {
        return true;
    }

    public static void main(String[] args) {
        System.out.print(fibonacci(8));
        System.out.print(paintGrid1(2));

        int[][] grids = new int[4][4];
        grids[1][2] = 1;
        grids[3][0] = 1;

        System.out.print(dpGrid(grids));

        int[][] maxGrids = new int [3][3];
        maxGrids[0][0] = 1;
        maxGrids[0][1] = 3;
        maxGrids[0][2] = 5;
        maxGrids[1][0] = 2;
        maxGrids[1][1] = 1;
        maxGrids[1][2] = 4;
        maxGrids[2][0] = 6;
        maxGrids[2][1] = 3;
        maxGrids[2][2] = 2;

        System.out.print(maxPath(maxGrids));
    }
}
