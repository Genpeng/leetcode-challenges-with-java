package c01_array.lc0026_remove_duplicates_from_sorted_array;

import java.util.Arrays;

/**
 * This is the solution of No. 26 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3,
 * and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: fast & slow pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: slow & fast pointers
     *
     * Complexity Analysis:
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 41.5 MB, less than 17.02% of Java online submissions for Remove Duplicates from Sorted Array.
     *
     * @param nums int[], the input array
     * @return int, the length of the array without duplicates
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                ++i;
                if (i < j) {
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(nums));
        Solution1 solution = new Solution1();
        int newLength = solution.removeDuplicates(nums);
        int[] newNums = Arrays.copyOf(nums, newLength);
        System.out.println(Arrays.toString(newNums));
    }
}