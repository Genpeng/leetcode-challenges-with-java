package c03_linked_list.lc0148_sort_list;

import entity.ListNode;

/**
 * This is the solution of No. 148 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/sort-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * <p>
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * ==========================================================================================================
 * <p>
 * Tags: linked list;sort;divide and conquer;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 * @date    2019/06/30
 */
public class Solution3 {
    /**
     * Approach 3: Merge Sort (Bottom up)
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(1)
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the sorted list
     */
    public ListNode sortList(ListNode head) {
        // Count the length of the linked list, Time Complexity: O(N)
        int len = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            ++len;
        }
        // Split the list into sublists with different length, and merge them, Time Complexity: O(N * log(N))
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tail, curr, l, r;
        ListNode[] pair;
        for (int n = 1; n < len; n <<= 1) {
            tail = dummyHead;
            curr = dummyHead.next;
            while (curr != null) {
                l = curr;
                r = split(l, n);
                curr = split(r, n);
                pair = merge(l, r);
                tail.next = pair[0];
                tail = pair[1];
            }
        }
        return dummyHead.next;
    }

    /**
     * Split the linked list into two parts, where the first part has `n` nodes.
     *
     * @param head ListNode, the head of the linked list
     * @param n    int, the number of first part
     * @return ListNode, the head of the second part
     */
    private ListNode split(ListNode head, int n) {
        // There are only two situations:
        // 1. head = null, if the length of list is less than n
        // 2. head != null, if the length of list is greater than or equal to n
        while (--n > 0 && head != null) {
            head = head.next;
        }
        ListNode rest = head == null ? head : head.next;
        if (head != null) {
            head.next = null;
        }
        return rest;

        // or can be write as follow:
//        ListNode rest = null;
//        if (head != null) {
//            rest = head.next;
//            head.next = null;
//        }
//        return rest;
    }

    /**
     * Merge two sorted linked list, and return head and tail pointers.
     *
     * @param l1 ListNode, the head of one linked list
     * @param l2 ListNode, the head of other linked list
     * @return ListNode[], the head and tail of the new sorted linked list
     */
    private ListNode[] merge(ListNode l1, ListNode l2) {
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
        while (tail.next != null) {
            tail = tail.next;
        }
        return new ListNode[]{dummyHead.next, tail};
    }

    public static void main(String[] args) {
        // test `split` method
//        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
//        System.out.println(head);
//        Solution3 solution = new Solution3();
//        ListNode rest = solution.split(head, 2);
//        System.out.println(head);
//        System.out.println(rest);
//
//         test `merge` method
//        ListNode l1 = new ListNode(new int[] {1, 2, 3, 4});
//        ListNode l2 = new ListNode(new int[] {5, 6, 7, 8});
//        System.out.println(l1);
//        System.out.println(l2);
//        Solution3 solution = new Solution3();
//        ListNode[] pair = solution.merge(l1, l2);
//        System.out.println(pair[0]);
//        System.out.println(pair[1]);

        // test `sortList` method
        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        System.out.println(head);
        Solution3 solution = new Solution3();
        System.out.println(solution.sortList(head));
    }
}