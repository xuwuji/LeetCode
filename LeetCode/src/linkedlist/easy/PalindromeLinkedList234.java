package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ23ÈÕ
 */
public class PalindromeLinkedList234 {
	private ListNode head;

	public boolean isPalindrome(ListNode head) {
		// get the length of the list
		ListNode pointer = head;
		int count = 0;
		while (pointer != null) {
			count++;
			pointer = pointer.next;
		}
		if (count == 0 || count == 1) {
			return true;
		}

		// set a pointer to the first node of the right side of the list
		ListNode right = head;
		int middle = (count % 2 == 0) ? (count / 2) : (count / 2) + 1;
		for (int i = 0; i < middle; i++) {
			right = right.next;
		}

		// reverse the left side of the list
		ListNode ReverseHead = null;

		while (head != right) {
			ListNode temp = head.next;
			head.next = ReverseHead;
			ReverseHead = head;
			head = temp;

		}

		// if it is a odd list, then move the pointer of the left to the its
		// next
		if (count % 2 != 0) {
			ReverseHead = ReverseHead.next;
		}

		// check two sides
		while (ReverseHead != null && right != null) {
			if (ReverseHead.val != right.val) {
				return false;
			}
			ReverseHead = ReverseHead.next;
			right = right.next;
		}

		return true;
	}

	public static void main(String[] args) {
		PalindromeLinkedList234 r = new PalindromeLinkedList234();
		r.head = new ListNode(1);
		r.head.next = new ListNode(2);
		r.head.next.next = new ListNode(3);
		r.head.next.next.next = new ListNode(2);
		r.head.next.next.next.next = new ListNode(1);
		r.isPalindrome(r.head);
		// ListNode node = r.head;

		// node = node.next;
		// r.iterator(node);
		// ListNode newNode = r.reverseList(r.head);
		// r.iterator(newNode);
	}
}
