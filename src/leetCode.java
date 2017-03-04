import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by da.teng on 2/22/17.
 */
public class leetCode {

    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.

     For example,
     Given [10, 9, 2, 5, 3, 7, 101, 18],
     The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
     Note that there may be more than one LIS combination, it is only necessary for you to return the length.

     Your algorithm should run in O(n2) complexity*/
    public static int getLongestIncreasingSub(int[] input) {
        int[] carry = new int[input.length];

        for (int x = 0; x < carry.length; x ++) {
            carry[x] = 1;
        }

        for (int j = 1; j < input.length; j ++) {
            for (int i = 0; i < j; i ++) {
                if (input[j] > input[i]) {
                    carry[j] = Math.max(carry[i] + 1, carry[j]);
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i : carry) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

     For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */
    public static int largestSum(int[] input) {
        int currentMax = input[0];
        int globalMax = input[0];

        for (int i = 1; i < input.length; i ++) {
            currentMax = Integer.max(currentMax + input[i], input[i]);
            globalMax = Integer.max(globalMax, currentMax);
        }
        return globalMax;
    }

    /**Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     "pwke" is a subsequence and not a substring.*/
    public static int longestNoRepeating(String s) {
        int start = 0;
        int result = 0;
        HashMap<Character, Integer> buff = new HashMap<>();

        for (int a = 0; a < s.length(); a ++) {
            char c = s.charAt(a);
            if (buff.containsKey(c)) {
                start = Math.max(start, buff.get(c) + 1);
            }
            result = Math.max(result, a - start + 1);
            buff.put(c, a);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.print(getLongestIncreasingSub(input));
//        System.out.print(largestSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.print(longestNoRepeating("abba"));
    }
}
