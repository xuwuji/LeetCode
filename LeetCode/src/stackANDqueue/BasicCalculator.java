package stackANDqueue;

public class BasicCalculator {
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
		String value = head.value;
		if (head.next == null) {
			head = null;
		} else {
			head = head.next;
		}
		return value;

	}

	public String peek() {
		return head.value;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int calculate(String s) {
		BasicCalculator stack = new BasicCalculator();
		s = s.replace(" ", "");
		int index = 0;

		for (int j = index; j < s.length(); j = index) {
			String curr = String.valueOf(s.charAt(index));

			// check the "+" "-" "(" operator
			if (curr.equals("+") || curr.equals("-") || curr.equals("(")) {
				stack.push(curr);
				index++;
			}

			// if it is the )
			else if (curr.equals(")")) {
				int temp = 0;
				int result = 0;
				while (!stack.peek().equals("(")) {
					String pop_value = stack.pop();
					if (pop_value.equals("+")) {
						result = result + temp;
					} else if (pop_value.equals("-")) {
						result = result - temp;
					} else {
						temp = Integer.valueOf(pop_value);
					}
				}
				result = result + temp;
				if (stack.peek().equals("(")) {
					stack.pop();
				}
				stack.push(String.valueOf(result));
				index++;
			}

			// it is a number
			else {
				String number;
				StringBuilder sbuilder = new StringBuilder();
				while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
					sbuilder.append(s.charAt(index));
					index++;
				}
				number = sbuilder.toString();
				stack.push(number);
			}

		}

		// if the fomula has no "(" ")"
		int temp = 0;
		int result = 0;
		while (!stack.isEmpty()) {
			String pop_value = stack.pop();
			if (pop_value.equals("+")) {
				result = result + temp;
			} else if (pop_value.equals("-")) {
				result = result - temp;
			} else {
				temp = Integer.valueOf(pop_value);
			}
		}
		result = result + temp;
		stack.push(String.valueOf(result));

		return Integer.valueOf(stack.pop());

	}

	public static void main(String[] args) {
		BasicCalculator solution = new BasicCalculator();
		String s = "2-1 + 2";
		System.out.println(solution.calculate(s));
		char i = 1;
		System.out.println("i" + i);
	}
}
