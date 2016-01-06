package string.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ6ÈÕ
 */
public class LongestCommonPrefix14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		// do need to sort the array
		/**
		 * we want to find the prefix of all string in the array, not the
		 * longest repeated prefix
		 */
		// msd(strs, 0, strs.length - 1, 0);
		StringBuilder prefix = new StringBuilder();
		int min = strs[0].length();
		for (int j = 1; j < strs.length; j++) {
			if (strs[j].length() < min) {
				min = strs[j].length();
			}
		}
		for (int j = 0; j < min; j++) {
			int pointer = 0;
			while (pointer < strs.length) {
				if (strs[pointer].charAt(j) == strs[0].charAt(j)) {
					pointer++;
				} else {
					break;
				}
			}

			if (pointer == strs.length) {
				prefix.append(strs[0].charAt(j));
			} else {
				break;
			}
		}
		return prefix.toString();
	}

	public int charAt(String s, int d) {
		if (d < s.length()) {
			return s.charAt(d);
		} else {
			return -1;
		}
	}

	public String lcp(String v, String w) {
		if (w.equals("") || w == null) {
			return v;
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < Math.min(v.length(), w.length()); j++) {
			if (v.charAt(j) == w.charAt(j)) {
				sb.append(v.charAt(j));
			} else {
				break;
			}
		}
		return sb.toString();
	}

	public void msd(String[] strs, int low, int high, int position) {
		if (high <= low) {
			return;
		}
		String[] temp = new String[strs.length];
		int[] count = new int[258];
		// 1.count the frequency
		for (int j = low; j <= high; j++) {
			count[charAt(strs[j], position) + 2]++;
		}

		// 2.caculate the cumulates
		for (int j = 1; j < count.length; j++) {
			count[j] = count[j] + count[j - 1];
		}

		// 3.put result to the temp array
		for (int j = low; j <= high; j++) {
			int p = count[charAt(strs[j], position) + 1]++;
			temp[p] = strs[j];
		}

		// 4 rewrite
		for (int j = low; j <= high; j++) {
			strs[j] = temp[j - low];
		}

		// recursively call the method
		for (int j = 0; j < 256; j++) {
			msd(strs, low + count[j], low + count[j + 1] - 1, position + 1);
		}
	}

	public static void main(String[] args) {
		String[] b = new String[] { "a", "aa" };
		LongestCommonPrefix14 l = new LongestCommonPrefix14();
		System.out.println("longest common prefix: " + l.longestCommonPrefix(b));
	}
}
