package linkedlist.easy;

import java.util.HashSet;

import linkedlist.other.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ23ÈÕ
 */

public class RemoveDuplicatesfromSortedList83 {
	/**
	 * Use one set to store the scaned value and one virtual node to delete the
	 * real head
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode virtualNode = new ListNode(0);
		virtualNode.next = head;
		ListNode virtualHead = virtualNode;

		while (head != null) {
			if (set.contains(head.val)) {
				virtualHead.next = virtualHead.next.next;
				head = virtualHead.next;
			} else {
				set.add(head.val);
				virtualHead = virtualHead.next;
				head = head.next;
			}
		}
		return virtualNode.next;
	}

	/**
	 * don't use the virtual head
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesWithOutVirtualHead(ListNode head) {
		if (head == null) {
			return null;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode pointer = head;
		set.add(pointer.val);
		while (pointer != null && pointer.next != null) {
			if (set.contains(pointer.next.val)) {
				pointer.next = pointer.next.next;

			} else {
				set.add(pointer.next.val);
				pointer = pointer.next;
			}
		}
		return head;
	}

	/**
	 * use two pointers and no set
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicatesWithOutSet(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null) {
			if (slow.val == fast.val) {
				slow.next = slow.next.next;
				fast = slow.next;
			} else {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return head;

	}
}
