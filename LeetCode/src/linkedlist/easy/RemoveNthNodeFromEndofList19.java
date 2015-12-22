package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 * 
 * @author xuwuji
 * @time Dec 22, 2015
 */
public class RemoveNthNodeFromEndofList19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		ListNode pointerSlow = head;
		ListNode pointerFast = head;

		for (int i = 0; i < n; i++) {
			pointerFast = pointerFast.next;
			if (pointerFast == null) {
				return head.next;
			}
		}

		while (pointerFast.next != null) {
			pointerSlow = pointerSlow.next;
			pointerFast = pointerFast.next;
		}
		pointerSlow.next = pointerSlow.next.next;
		return head;
	}
}
