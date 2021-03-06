package c01_array.lc0016_3sum_closest;

import java.util.Arrays;

/**
 * This is the solution of No. 16 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/3sum-closest/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the three integers. You may assume that
 * each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     *
     * Complexity Analysis:
     * Time Complexity: O(N ^ 3)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 65 ms, faster than 6.98% of Java online submissions for 3Sum Closest.
     * Memory Usage: 38.8 MB, less than 6.74% of Java online submissions for 3Sum Closest.
     *
     * @param nums int[], the input integer array
     * @param target int, the target integer
     * @return int, the sum closest to target
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; ++j) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                for (int k = j + 1; k < n; ++k) {
                    if (k > j + 1 && nums[k] == nums[k-1]) {
                        continue;
                    }
                    int s = nums[i] + nums[j] + nums[k];
                    if (closestSum == Integer.MAX_VALUE || Math.abs(s - target) < Math.abs(closestSum - target)) {
                        closestSum = s;
                    }
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.threeSumClosest(new int[] {-1, 2, 1, -4}, 1) == 2);
    }
}