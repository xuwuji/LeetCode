package stackANDqueue;

public class ValidParentheses {
	private Node head;

	class Node {
		private String value;
		private Node next;
	}

	public void push(String s) {

		Node node = new Node();
		node.value = s;

		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public String pop() {
		if (head == null) {
			return "";
		}
		String value = head.value;
		if (head.next == null) {
			head = null;
		} else {
			head = head.next;
		}
		return value;

	}

	public boolean isValid(String s) {
		int length = s.length();
		ValidParentheses solution = new ValidParentheses();
		if (length == 0) {
			return true;
		} else if (length % 2 == 1) {
			return false;
		} else {
			for (int i = 0; i < length; i++) {
				String a = String.valueOf(s.charAt(i));
				if (a.equals("(") || a.equals("[") || a.equals("{")) {
					solution.push(a);
				} else if (a.equals(")")) {
					if (!"(".equals(solution.pop())) {
						return false;
					}
				} else if (a.equals("}")) {
					if (!"{".equals(solution.pop())) {
						return false;
					}
				} else if (a.equals("]")) {
					if (!"[".equals(solution.pop())) {
						return false;
					}
				}

			}
		}
		if (solution.head != null) {
			return false;
		}
		return true;

	}

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		String s = ")}{({))[{{[}";
		solution.isValid(s);
	}
}
