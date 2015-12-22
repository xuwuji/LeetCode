package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ22ÈÕ
 */
public class ReverseLinkedList206 {
	private ListNode head;

	/**
	 * Did the first time, it will copy each node and insert each node in the
	 * head of the list
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = new ListNode(head.val);
			temp.next = newHead;
			newHead = temp;
			head = head.next;
		}
		return newHead;
	}

	/**
	 * second time
	 * 
	 * In place reverse
	 * 
	 * @param pointer
	 * @return
	 */
	public ListNode reverseList1(ListNode pointer) {
		if (pointer == null || pointer.next == null) {
			return pointer;
		}
		ListNode newHead = null;
		while (pointer != null) {
			ListNode temp = pointer.next;
			pointer.next = newHead;
			newHead = pointer;
			pointer = temp;
		}
		return newHead;
	}

	public void iterator(ListNode pointer) {
		while (pointer != null) {

			System.out.print(pointer.val + " ");
			pointer = pointer.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList206 r = new ReverseLinkedList206();
		r.head = new ListNode(1);
		r.head.next = new ListNode(2);
		r.head.next.next = new ListNode(3);
		r.head.next.next.next = new ListNode(4);
		// r.iterator(r.head);
		ListNode newNode = r.reverseList(r.head);
		r.iterator(newNode);
	}
}
