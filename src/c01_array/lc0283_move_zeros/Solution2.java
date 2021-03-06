package c01_array.lc0283_move_zeros;

import java.util.Arrays;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/move-zeroes/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * ==========================================================================================================
 *
 * Tags: fast & slow pointers;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/07
 */
public class Solution2 {
    /**
     * Approach 2: Move all nonzero elements to head, and then replace remaining elements to zero
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums int[], the input integer array
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        for (int i = idx; i < n; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        Solution2 solution = new Solution2();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
