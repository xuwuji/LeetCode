package sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

	public static String largestNumber(int[] nums) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String max = list.get(0);
			for (int j = 0; j < list.size(); j++) {
				if (larger(list.get(j), max)) {
					max = list.get(j);
				}
			}
			sb.append(max);
			list.remove(max);
		}

		if (String.valueOf(sb.charAt(0)).equals("0") && sb.length() == 1) {
			return "0";
		}

		if (String.valueOf(sb.charAt(0)).equals("0") && String.valueOf(sb.charAt(1)).equals("0")) {
			return "0";
		}

		return sb.toString();
	}

	private static boolean larger(String a, String b) {
		int length = 0;
		if (a.length() == b.length()) {
			return a.compareTo(b) > 0;
		} else {
			if ((a + b).compareTo(b + a) > 0) {
				return true;
			} else if ((a + b).compareTo(b + a) < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 121, 12 };
		// System.out.println(largestNumber(a));
		System.out.println(larger("12", "128"));

	}
}
