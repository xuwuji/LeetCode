package stackANDqueue;

import java.util.Stack;

public class TwoStacksToOneQueue {
	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		s1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (s2.isEmpty()) {
			while (s1.size() > 1) {
				s2.push(s1.pop());
			}
			s1.pop();
		} else {
			s2.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (s2.isEmpty()) {
			while (s1.size() > 1) {
				s2.push(s1.pop());
			}
			int value = s1.peek();
			while (s2.size() > 0) {
				s1.push(s2.pop());
			}
			return value;
		}
		return s2.peek();

	}

	// Return whether the queue is empty.
	public boolean empty() {
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}

		return false;
	}
}
