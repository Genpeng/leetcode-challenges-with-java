package c02_string.lc0557_reverse_words_in_a_string_iii;

/**
 * This is the solution of No. 557 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note:
 * In the string, each word is separated by single space and there will not be any extra space in the string.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: string;fast and slow pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Fast and Slow Pointers
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 99.50% of Java online submissions for Reverse Words in a String III.
     * Memory Usage: 41.3 MB, less than 19.30% of Java online submissions for Reverse Words in a String III.
     *
     * @param s String, the input string
     * @return String, the modified string
     */
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        final int L = ca.length;
        for (int i, j = 0; j < L; ++j) {
            if (ca[j] != ' ') {
                i = j;
                while (j+1 < L && ca[j+1] != ' ') {
                    ++j;
                }
                reverse(ca, i, j);
            }
        }
        return String.valueOf(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; ++i, --j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String result = "s'teL ekat edoCteeL tsetnoc";
        Solution2 solu = new Solution2();
        System.out.println(solu.reverseWords(s).equals(result));
    }
}