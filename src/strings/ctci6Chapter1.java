package strings;

import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by da.teng on 2/19/17.
 */
public class ctci6Chapter1 {

    /**
     * Is Unique: Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?*/
    public static boolean isUnique(String s) {
        boolean[] isExistings = new boolean[256];
        for (char c : s.toCharArray()) {
            if (!isExistings[c]) {
                isExistings[c] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.*/
    public static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] ints = new int[256];
        for (char c : a.toCharArray()) {
            ints[c] ++;
        }

        for (char c : b.toCharArray()) {
            ints[c] --;
            if (ints[c] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * URLify: Write a method to replace all spaces in a string with '%20'
     * You may assume that the string has sufficient space at the end to hold the additional characters,
     * and that you are given the "true" length of the string.
     * (Note: if implementing in Java,
     * please use a character array so that you can perform this operation in place.)*/
    public static char[] URLify(char[] cs, int trueLength) {
        int end = 0;
        for (int i = 0; i < cs.length; i ++) {
            char c = cs[i];
            if (c != ' ') {
                trueLength --;
            }
            if (trueLength == 0) {
                end = i;
                break;
            }
        }

        int j = cs.length - 1;

        for (int i = end; i >= 0; i --) {
            char c = cs[i];
            if (c == ' ') {
                cs[j] = '0';
                j --;
                cs[j] = '2';
                j --;
                cs[j] = '%';
                j --;
            } else {
                cs[j] = c;
                j --;
            }
        }
        return cs;
    }

    public static boolean palindromePermutation(String s) {
        int countOdd = 0;
        HashMap<Character, Integer> keeper = new HashMap<>();

        for (char c : s.toLowerCase().toCharArray()) {
            if (c != ' ') {
                if (keeper.containsKey(c)) {
                    keeper.put(c, keeper.get(c)+1);
                } else {
                    keeper.put(c, 1);
                }

                if (keeper.get(c) % 2 == 0) {
                    countOdd --;
                } else {
                    countOdd ++;
                }
            }
        }
        return countOdd <= 1;
    }

    /**
     * One Away: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character.
     * Given two strings, write a function to check if they are one edit (or zero edits) away.
     */

    public static boolean isOneAway (String a, String b) {
        if (a.length() == b.length()) {
            return isOneReplacementAway(a, b);
        } else if (b.length() - a.length() == 1) {
            return isOneInsertionAway(a, b);
        } else if (a.length() - b.length() == 1) {
            return isOneRemoveAway(a, b);
        }
        return false;
    }

    private static boolean isOneReplacementAway (String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i ++) {
            if (a.charAt(i) != b.charAt(i)) {
                count ++;
            }
        }
        return count <= 1;
    }

    private static boolean isOneInsertionAway (String a, String b) {
        int count = 0;
        int aindex = 0;
        for (int bindex = 0; bindex < b.length(); bindex ++) {
            if (a.charAt(aindex) != b.charAt(bindex)) {
                count ++;
                if (count > 1) {
                    return false;
                }
            } else {
                aindex ++;
            }
        }
        return true;
    }

    private static boolean isOneRemoveAway (String a, String b) {
        int count = 0;
        int aindex = 0;
        for (int bindex = 0; bindex < b.length(); bindex ++) {
            if (a.charAt(aindex) != b.charAt(bindex)) {
                bindex --;
                count ++;
                if (count > 1) {
                    return false;
                }
            }
            aindex ++;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.print(isUnique("abca"));
//        System.out.print(URLify("abc d e    ".toCharArray(), 5));
//        System.out.print(palindromePermutation("Tact Coa"));
        System.out.print(isOneAway("pale", "ple"));
        System.out.print(isOneAway("pale", "bae"));
    }
}
