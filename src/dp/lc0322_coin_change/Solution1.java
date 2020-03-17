package dp.lc0322_coin_change;

/**
 * This is the solution of No. 322 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/coin-change/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * - You may assume that you have an infinite number of each kind of coin.
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking
     * Time Complexity: O(S ^ n)
     * Space Complexity: O(n)
     * where S is the amount to change, and n is the number of coins
     *
     * @param coins int[], coins of different denominations
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, 0, amount);
    }

    /**
     * Compute the fewest number of coins that you need to make up that amount, and return -1 if it
     * does not exist any combination of coins, where the index of coins you can use start from `si`.
     *
     * Time Limit Exceeded
     *
     * @param coins int[], coins of different denominations
     * @param si int, the start index of `coins`
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    private int coinChange(int[] coins, int si, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (si < coins.length) {
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i <= amount / coins[si]; ++i) {
                int sub = coinChange(coins, si + 1, amount - coins[si] * i);
                if (sub != -1) {
                    minNum = Math.min(minNum, i + sub);
                }
            }
            return minNum == Integer.MAX_VALUE ? -1 : minNum;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        Solution1 solution = new Solution1();
        System.out.println(solution.coinChange(coins, amount));
    }
}