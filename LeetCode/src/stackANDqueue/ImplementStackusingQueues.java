package stackANDqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();

	// add element x onto stack.
	public void push(int x) {
		if (!q1.isEmpty()) {
			q1.add(x);
		} else if (!q2.isEmpty()) {
			q2.add(x);
		} else {
			q1.add(x);
		}

	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!q1.isEmpty()) {
			while (q1.size() > 1) {
				q2.add(q1.remove());
			}
			q1.remove();
		} else {
			while (q2.size() > 1) {
				q1.add(q2.remove());
			}
			q2.remove();
		}
	}

	// Get the top element.
	public int top() {
		if (!q1.isEmpty()) {
			while (q1.size() > 1) {
				q2.add(q1.remove());
			}
			int value = q1.peek();
			q2.add(q1.remove());
			return value;
		} else {
			while (q2.size() > 1) {
				q1.add(q2.remove());
			}
			int value = q2.peek();
			q1.add(q2.remove());
			return value;
		}
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}
