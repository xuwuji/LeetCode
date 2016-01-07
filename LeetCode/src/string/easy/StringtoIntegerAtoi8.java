package string.easy;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ7ÈÕ
 */
public class StringtoIntegerAtoi8 {

	public static int myAtoi(String str) {

		if (str.length() == 0) {
			return 0;
		}

		StringBuilder sb = new StringBuilder();

		// 1.delete all white space at the front m
		int j = 0;
		while (str.charAt(j) == ' ') {
			j++;
		}

		for (int i = j; i < str.length(); i++) {
			sb.append(str.charAt(i));
		}

		String s = sb.toString();
		sb = new StringBuilder();

		if (s.length() == 1) {
			if (!valid(s.charAt(0))) {
				return 0;
			} else {
				return Integer.valueOf(s);
			}
		}

		if (operator(s.charAt(0))) {
			sb.append(s.charAt(0));
		} else if (valid(s.charAt(0))) {
			sb.append(s.charAt(0));
		} else {
			return 0;
		}
		// s = sb.toString();
		System.out.println(sb.toString());
		System.out.println(Integer.MIN_VALUE);
		// 2.ignore unvalid char
		for (int i = 1; i < s.length(); i++) {
			System.out.println(i);
			System.out.println(sb.toString());
			if (operator(s.charAt(i - 1)) && !valid(s.charAt(i))) {
				System.out.println("here");
				return 0;
			}

			if (operator(s.charAt(i - 1)) && operator(s.charAt(i))) {
				System.out.println("there");
				return 0;
			}

			if (valid(s.charAt(i - 1)) && !valid(s.charAt(i))) {

				if (exceed(sb.toString())) {
					if (sb.charAt(0) == '-') {
						return Integer.MIN_VALUE;
					} else {
						return Integer.MAX_VALUE;
					}
				} else {
					return Integer.valueOf(sb.toString());
				}

			} else if (valid(s.charAt(i))) {
				sb.append(s.charAt(i));
			}

		}

		String result = sb.toString();
		if (result.length() == 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
			return 0;
		}

		if (result.length() == 0) {
			return 0;
		}
		// 3. check the str
		if (exceed(result)) {
			if (result.charAt(0) == '-') {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		return Integer.valueOf(result);
	}

	private static boolean exceed(String s) {

		if (s.length() > 11) {
			return true;
		}

		// negative
		if (s.length() == 11 && s.charAt(0) == '-') {
			if (s.charAt(10) > '8') {
				return true;
			} else {
				return false;
			}
		}

		// positive
		if (s.length() == 11 && s.charAt(0) != '+') {

			return true;

		}

		// positive
		if (s.length() == 11 && s.charAt(0) == '+') {
			if (s.charAt(10) > '7') {
				return true;
			}
		}

		// positive
		if (s.length() == 10 && s.charAt(0) != '-' && s.charAt(0) != '+') {
			if (s.charAt(9) > '7') {
				return true;
			}
		}

		// positive
		if (s.length() == 10 && s.charAt(0) != '-' && s.charAt(0) != '+') {
			if (s.charAt(9) > '7') {
				return true;
			}
		}

		return false;
	}

	private static boolean valid(char c) {
		return c <= '9' && c >= '0';
	}

	private static boolean operator(char c) {
		return c == '-' || c == '+';
	}

	public static void main(String[] args) {
		// System.out.println(Integer.valueOf("-2147448"));
		System.out.println(StringtoIntegerAtoi8.myAtoi(" b11228552307"));
	}

}
