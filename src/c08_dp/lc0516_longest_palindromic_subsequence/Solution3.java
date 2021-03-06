package c08_dp.lc0516_longest_palindromic_subsequence;

/**
 * This is the solution of No. 516 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that
 * the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Recursion with memoization
     *
     * Complexity Analysis:
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N ^ 2)
     *
     * @param s String, an input string
     * @return int, the length of longest palindromic subsequence
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        int L = s.length();
        int[][] memo = new int[L][L];
        return lps(s, 0, L-1, memo);
    }

    private int lps(String s, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + lps(s, i+1, j-1, memo);
        } else {
            memo[i][j] = Math.max(lps(s, i+1, j, memo), lps(s, i, j-1, memo));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution3 solu = new Solution3();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}