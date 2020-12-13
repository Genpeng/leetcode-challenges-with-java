package c08_dp.lc0064_minimum_path_sum;

/**
 * This is the solution of No. 64 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes
 * the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 200
 * - 0 <= grid[i][j] <= 100
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;dp;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Dynamic Programming with memory optimization (v1)
     * Suppose dp[i][j] represents the minimum path sum from (0, 0) to (i, j),
     * the state transition equation can be written as follow:
     *            / grid[i][j] + min{dp[i-1][j], dp[i][j-1]}, i * j > 0
     * dp[i][j] = - grid[i][j] + dp[i-1][j], i > 0 and j = 0
     *            \ grid[i][j] + dp[i][j-1], i = 0 and j > 0
     *            \ grid[i][j], i = 0 and j = 0
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     *
     * @param grid int[][], a m x n grid filled with non-negative numbers
     * @return int, the minimum path sum from (0, 0) to (m, n)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        prev[0] = grid[0][0];
        for (int j = 1; j < n; ++j) {
            prev[j] = grid[0][j] + prev[j-1];
        }
        for (int i = 1; i < m; ++i) {
            curr[0] = grid[i][0] + prev[0];
            for (int j = 1; j < n; ++j) {
                curr[j] = grid[i][j] + Math.min(curr[j-1], prev[j]);
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return prev[n-1];
    }
}