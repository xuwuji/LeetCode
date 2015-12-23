package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ23ÈÕ
 */
public class MergeTwoSortedLists21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode pointer = head;

		while (l1 != null || l2 != null) {
			if (l1 == null) {
				while (l2 != null) {
					pointer.next = l2;
					pointer = pointer.next;
					l2 = l2.next;
				}
			} else if (l2 == null) {
				while (l1 != null) {
					pointer.next = l1;
					pointer = pointer.next;
					l1 = l1.next;
				}
			}
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					pointer.next = l1;
					pointer = pointer.next;
					l1 = l1.next;
				} else {
					pointer.next = l2;
					pointer = pointer.next;
					l2 = l2.next;
				}
			}

		}
		return head.next;
	}
}
