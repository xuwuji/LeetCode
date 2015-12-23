package linkedlist.easy;

import linkedlist.other.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A: a1 �� a2 �K c1 �� c2 �� c3 �J B: b1 �� b2 �� b3 begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author wuxu
 * @time 2015��12��23��
 */
public class IntersectionofTwoLinkedLists160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// get the length of two list
		ListNode pointerA = headA;
		ListNode pointerB = headB;
		int countA = 0, countB = 0;
		while (pointerA != null) {
			countA++;
			pointerA = pointerA.next;
		}
		while (pointerB != null) {
			countB++;
			pointerB = pointerB.next;
		}

		// change the head of each list to "relative equal"
		// compare each node and return if they are equal
		if (countA > countB) {
			int difference = (countA - countB);
			for (int i = 0; i < difference; i++) {
				headA = headA.next;
			}
		} else {
			int difference = (countB - countA);
			for (int i = 0; i < difference; i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
}
