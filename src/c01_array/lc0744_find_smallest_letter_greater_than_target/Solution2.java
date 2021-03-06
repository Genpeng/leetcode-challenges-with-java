package c01_array.lc0744_find_smallest_letter_greater_than_target;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 *
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * Note:
 * - letters has a length in range [2, 10000].
 * - letters consists of lowercase letters, and contains at least 2 unique letters.
 * - target is a lowercase letter.
 * ==========================================================================================================
 *
 * Tags: array;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Binary Search
     * Time Complexity: O(log(N))
     * Space Complexity: O(1)
     *
     * @param letters char[], a list of sorted characters letters containing only lowercase letters
     * @param target char, a target letter
     * @return char, the smallest element in the list that is larger than the given target
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (letters[n-1] <= target) {
            return letters[0];
        }
        // There must exist at least one letter greater than the target letter
        int li = 0, ri = n - 1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (letters[mi] <= target) {
                li = mi + 1;
            } else {
                ri = mi - 1;
            }
        }
        return letters[li];
    }
}