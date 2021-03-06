package c07_math_and_digit.lc0836_rectangle_overlap;

/**
 * This is the solution of No. 836 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/rectangle-overlap/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that
 * only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 *
 * Example 2:
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 *
 * Notes:
 * - Both rectangles rec1 and rec2 are lists of 4 integers.
 * - All coordinates in rectangles will be between -10^9 and 10^9.
 * ==========================================================================================================
 *
 * Tags: math;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Check Area
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param rec1 int[], one rectangle represented as a list [x1, y1, x2, y2]
     * @param rec2 int[], the other rectangle
     * @return boolean, true if two rectangle overlap
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }
}