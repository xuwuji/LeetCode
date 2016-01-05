package string.easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author xuwuji
 * @time Jan 5, 2016
 */
public class CountandSay38 {
	/**
	 * the sequence is always beginning with 1, and generate the nth sequence
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		String s = String.valueOf(n);
		StringBuilder sb = new StringBuilder();
		if (n < 0) {
			return null;
		}
		if (n == 1) {
			return "1";
		}

		s = "1";
		for (int time = 1; time < n; time++) {
			int count = 1;
			for (int i = 0; i < s.length(); i++) {
				if (i + 1 == s.length()) {
					sb.append(String.valueOf(count) + String.valueOf(s.charAt(i)));
					break;
				} else if (s.charAt(i) == s.charAt(i + 1)) {
					count++;
				} else {
					sb.append(String.valueOf(count) + String.valueOf(s.charAt(i)));
					count = 1;
				}
			}
			s = sb.toString();
			sb = new StringBuilder();
		}
		return s;
	}

	/**
	 * use the recursive style, it is faster than the above method
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSayRecursive(int n) {
		return countAndSayRecursiveHelper("1", n);
	}

	public String countAndSayRecursiveHelper(String data, int time) {
		StringBuilder sb = new StringBuilder();
		if (time <= 0) {
			return null;
		}
		if (time == 1) {
			return data;
		}

		/**
		 * count part, no need to change
		 */
		int count = 1;

		for (int i = 0; i < data.length(); i++) {
			if (i + 1 == data.length()) {
				sb.append(String.valueOf(count) + String.valueOf(data.charAt(i)));
				break;
			} else if (data.charAt(i) == data.charAt(i + 1)) {
				count++;
			} else {
				sb.append(String.valueOf(count) + String.valueOf(data.charAt(i)));
				count = 1;
			}
		}
		data = sb.toString();

		/**
		 * recursively call the method to process the data
		 */
		return countAndSayRecursiveHelper(data, time - 1);
	}

	public static void main(String[] args) {
		CountandSay38 c = new CountandSay38();
		System.out.println(c.countAndSay(2));
		System.out.println(c.countAndSayRecursive(2));
	}
}
