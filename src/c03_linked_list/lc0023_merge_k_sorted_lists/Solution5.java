package c03_linked_list.lc0023_merge_k_sorted_lists;

import entity.ListNode;

/**
 * This is the solution of No. 23 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: linked list;two pointers;divide and conquer;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution5 {
    /**
     * Approach 5: Divide & Conquer (Top down)
     * Time Complexity: O(N * log(K))
     * Space Complexity: O(log(K))
     *
     * @param lists ListNode[], k sorted linked lists
     * @return ListNode, the new sorted linked list
     */
    public ListNode mergeLists(ListNode[] lists) {
        final int n = lists.length;
        if (n == 0) {
            return null;
        }
        return mergeLists(lists, 0, n - 1);
    }

    /**
     * Merge k lists where the start index is `si`, and the end index is `ei`
     *
     * @param lists ListNode[], k lists
     * @param si int, the start index
     * @param ei int, the end index
     * @return ListNode, the new sorted list
     */
    private ListNode mergeLists(ListNode[] lists, int si, int ei) {
        if (si == ei) {
            return lists[si];
        }
        int mi = si + ((ei - si) >> 1);
        ListNode l1 = mergeLists(lists, si, mi);
        ListNode l2 = mergeLists(lists, mi + 1, ei);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[] {1, 4, 5});
        ListNode head2 = new ListNode(new int[] {1, 3, 4});
        ListNode head3 = new ListNode(new int[] {2, 6});
        ListNode[] lists = new ListNode[] {head1, head2, head3};
        Solution5 solution = new Solution5();
        System.out.println(solution.mergeLists(lists));
    }
}