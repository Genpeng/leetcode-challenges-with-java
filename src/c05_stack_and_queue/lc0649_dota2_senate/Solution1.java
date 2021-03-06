package c05_stack_and_queue.lc0649_dota2_senate;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the solution of No. 649 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/dota2-senate/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 *
 * The Dota2 senate consists of senators coming from two parties. Now the senate wants to make a decision
 * about a change in the Dota2 game. The voting for this change is a round-based procedure. In each round,
 * each senator can exercise one of the two rights:
 *
 * Ban one senator's right:
 * 1. A senator can make another senator lose all his rights in this and all the following rounds.
 * 2. Announce the victory:
 *    If this senator found the senators who still have rights to vote are all from the same party,
 *    he can announce the victory and make the decision about the change in the game.
 *
 * Given a string representing each senator's party belonging. The character 'R' and 'D' represent
 * the Radiant party and the Dire party respectively. Then if there are n senators, the size of
 * the given string will be n.
 *
 * The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting. All the senators who have lost their rights
 * will be skipped during the procedure.
 *
 * Suppose every senator is smart enough and will play the best strategy for his own party, you need to
 * predict which party will finally announce the victory and make the change in the Dota2 game. The output
 * should be Radiant or Dire.
 *
 * Example 1:
 * Input: "RD"
 * Output: "Radiant"
 * Explanation: The first senator comes from Radiant and he can just ban the next senator's right in the round 1.
 * And the second senator can't exercise any rights any more since his right has been banned.
 * And in the round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
 *
 * Example 2:
 * Input: "RDD"
 * Output: "Dire"
 * Explanation:
 * The first senator comes from Radiant and he can just ban the next senator's right in the round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And the third senator comes from Dire and he can ban the first senator's right in the round 1.
 * And in the round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 *
 * Note:
 * - The length of the given string will in the range [1, 10,000].
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;queue;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Simulation
     *
     * Complexity Analysis:
     * Time Complexity: O(L)
     * Space Complexity: O(L)
     *
     * Result of Submission:
     * Runtime: 8 ms, faster than 59.86% of Java online submissions for Dota2 Senate.
     * Memory Usage: 39.2 MB, less than 78.23% of Java online submissions for Dota2 Senate.
     *
     * @param senate String, a string representing each senator's party belonging
     * @return String, the party finally win the victory
     */
    public String predictPartyVictory(String senate) {
        final int L = senate.length();
        Deque<Integer> q = new ArrayDeque<>();
        int[] remain  = new int[2]; // 0 - Dire, 1 - Radiant
        int[] ban = new int[2];
        for (int i = 0; i < L; ++i) {
            int pos = senate.charAt(i) == 'R' ? 1 : 0;
            ++remain[pos];
            q.offerLast(pos);
        }
        while (remain[0] > 0 && remain[1] > 0) {
            int pos = q.pollFirst();
            if (ban[pos] > 0) {
                --remain[pos];
                --ban[pos];
            } else {
                ++ban[pos ^ 1];
                q.offerLast(pos);
            }
        }
        return remain[0] > 0 ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.predictPartyVictory("RD").equals("Radiant"));
        System.out.println(solu.predictPartyVictory("RDD").equals("Dire"));
    }
}