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

	public boolean isEmpty() {
		return head == null;
	}

	public int calculate(String s) {
		int length = s.length();
		BasicCalculator s1 = new BasicCalculator();
		BasicCalculator s2 = new BasicCalculator();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			String a = String.valueOf(s.charAt(i));
			if (a.equals("(")) {

			} else if (a.equals(" ")) {

			} else if (a.equals(")")) {

			} else {
				builder.append(a);
			}
		}
		String formula = builder.toString();
		System.out.println(formula);

		if (formula.indexOf("+") == -1 && formula.indexOf("-") == -1) {
			return Integer.valueOf(formula);
		}

		int index = 0;
		for (int j = index; j < formula.length(); j++) {

			//check the plus operator
			if (String.valueOf(formula.charAt(index)).equals("+")) {
				s2.push(String.valueOf(formula.charAt(index)));
				index++;
				System.out.println("index:" + index);
			} else if (String.valueOf(formula.charAt(index)).equals("-")) {
				System.out.println(String.valueOf(formula.charAt(index)));
				System.out.println("push2");
				s2.push(String.valueOf(formula.charAt(index)));
				index++;
				System.out.println("index:" + index);
			} else {
				String a = "";
				while (index<formula.length()&&!String.valueOf(formula.charAt(index)).equals("+")
						&& !String.valueOf(formula.charAt(index)).equals("-")) {
					StringBuilder sbuilder = new StringBuilder();
					sbuilder.append(formula.charAt(index));
					System.out.println("index:" + index);
					index++;
					a = sbuilder.toString();
				}
				System.out.println("index:" + index);
				System.out.println(a);
				if (s1.isEmpty()) {
					s1.push(a);
					System.out.println("push1");
				} else {
					System.out.println("else");
					String f = s1.pop();
					String operator = s2.pop();
					String result = "";
					if (operator.equals("+")) {
						result = String.valueOf(Integer.valueOf(a) + Integer.valueOf(f));
					} else {
						result = String.valueOf(Integer.valueOf(f) - Integer.valueOf(a));
					}
					System.out.println(result);
					s1.push(result);
				}
			}
		}
		return Integer.valueOf(s1.pop());
	}

	public static void main(String[] args) {
		BasicCalculator solution = new BasicCalculator();
		String s = "1-11";
		solution.calculate(s);
	}
}
