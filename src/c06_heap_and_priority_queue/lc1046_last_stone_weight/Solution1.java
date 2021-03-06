package c06_heap_and_priority_queue.lc1046_last_stone_weight;

import java.util.PriorityQueue;

/**
 * This is the solution of No. 1046 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/last-stone-weight/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * - If x == y, both stones are totally destroyed;
 * - If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *   At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 * Example 1:
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 * Note:
 * - 1 <= stones.length <= 30
 * - 1 <= stones[i] <= 1000
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: heap;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Heap
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(N)
     *
     * @param stones int[], the weights of stones
     * @return int, the weight of the remaining stone, or 0 if there are no stones left
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int stone : stones) { // O(N * log(N))
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int gap = pq.poll() - pq.poll();
            if (gap > 0) {
                pq.offer(gap);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}