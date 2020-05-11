package c08_dp.lc0005_longest_palindromic_substring;

/**
 * This is the solution of No. 5 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * ==========================================================================================================
 *
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(N ^ 3)
     * Space Complexity: O(1)
     *
     * @param s String, an input string
     * @return String, the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int L = s.length();
        String ans = "";
        for (int i = 0; i < L; ++i) {
            for (int j = i; j < L; ++j) {
                if (isPalindromic(s, i, j) && j-i+1 > ans.length()) {
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }

    private boolean isPalindromic(String s, int i, int j) {
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        Solution1 solu = new Solution1();
        System.out.println(solu.longestPalindrome(s));
    }
}