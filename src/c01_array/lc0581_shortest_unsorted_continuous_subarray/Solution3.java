package c01_array.lc0581_shortest_unsorted_continuous_subarray;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the solution of No. 581 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray
 * in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 0
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 0
 *
 * Constraints:
 * - 1 <= nums.length <= 104
 * - -10^5 <= nums[i] <= 10^5
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Monotonous Stack
     * Find out the leftmost and rightmost elements whose position is wrong.
     *
     * References:
     * [1] https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
     * [2] https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/Java-O(n)-Time-O(1)-Space
     *
     * Complexity Analysis:
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums int[], the input integer array
     * @return int, the length of shortest such subarray
     */
    public int findUnsortedSubarray(int[] nums) {
        final int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int l = n;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        int r = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}) == 5);
        System.out.println(solu.findUnsortedSubarray(new int[] {1, 2, 3, 4}) == 0);
        System.out.println(solu.findUnsortedSubarray(new int[] {1}) == 0);
    }
}