package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
 * with value 3, the linked list should become 1 -> 2 -> 4 after calling your
 * function.
 * 
 * 
 * @author xuwuji
 * @time Dec 22, 2015
 */
public class DeleteNodeinaLinkedList237 {
	public void deleteNode(ListNode node) {
		while (node.next != null) {
			node.val = node.next.val;
			if (node.next.next != null) {
				node = node.next;
			} else {
				node.next = null;
			}
		}

	}
}
