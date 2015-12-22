package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 * 
 * @author xuwuji
 * @time Dec 22, 2015
 */
public class RemoveLinkedListElements203 {
	/**
	 * By myself
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {

		while (head != null && head.val == val) {
			head = head.next;
		}

		ListNode pointer = head;

		while (pointer != null && pointer.next != null) {
			if (pointer.next.val == val) {
				pointer.next = pointer.next.next;
			} else {
				pointer = pointer.next;
			}

		}
		return head;
	}

	/**
	 * create a virtual head node before the real head node, this makes easy to
	 * delete the real head node
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElementsByVirtualHeadNode(ListNode head, int val) {
		// create a virtual node to represent the head node before the real node
		ListNode virtualNode = new ListNode(0);
		virtualNode.next = head;
		// create pointer to scan the list
		ListNode virtualHead = virtualNode;

		while (head != null) {
			if (head.val == val) {
				virtualHead.next = virtualHead.next.next;
			} else {
				virtualHead = virtualHead.next;
			}
			head = head.next;
		}
		return virtualNode.next;
	}

	public ListNode removeElementsByVirtualHeadNode2(ListNode head, int val) {
		// create a virtual node to represent the head node before the real node
		ListNode virtualNode = new ListNode(0);
		virtualNode.next = head;
		// create pointer to scan the list
		ListNode virtualHead = virtualNode;

		while (head != null) {
			if (head.val == val) {
				virtualHead.next = virtualHead.next.next;
			} else {
				virtualHead = virtualHead.next;
			}
			head = head.next;
		}
		return virtualNode.next;
	}
}
